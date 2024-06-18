package Snake_Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WAR_meduim {
    private String name;  
    private int score;    
    private final String filePath_meduim = "meduim_file.csv";

    public WAR_meduim(String name, int score) {
        this.name = name;
        this.score = score;
    }

    private void writeToFile_meduim(String nameToWrite, int scoreToWrite) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath_meduim, true))) {
            System.out.println("Writing to file: Name - " + nameToWrite + ", Score - " + scoreToWrite);
            writer.write(nameToWrite + "," + scoreToWrite);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScore_meduim(String name, int score) {
        this.name = name;
        this.score = score;
        System.out.println("Received Score: " + this.score);
        writeToFile_meduim(name, score);
    }

    public static void main(String[] args) {
        main_page main = new main_page();
        Snake_meduim_level meduim = new Snake_meduim_level();

        WAR_meduim war = new WAR_meduim(main.getName_meduim(), meduim.getScore());
        war.setScore_meduim(main.getName_meduim(), meduim.getScore());
    }

}
