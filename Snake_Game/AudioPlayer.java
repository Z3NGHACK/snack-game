package Snake_Game;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioPlayer {
	private static Clip clip;

	public static void playSound(String soundFileName) {
        new Thread(() -> {
            try {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                    clip.close();
                }
                File audioFile = new File(soundFileName);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void stopSound() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public static void main(String[] args) {
        playSound("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\audio.wav"); // Replace with the path to your audio file
    }
}
