package Snake_Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WAR_easy {
    private String name;  
    private int score;    
    private final String filePath_easy = "easy_file.csv";

    public WAR_easy(String name, int score) {
        this.name = name;
        this.score = score;
    }

    private void writeToFile_easy(String nameToWrite, int scoreToWrite) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath_easy, true))) {
            System.out.println("Writing to file: Name - " + nameToWrite + ", Score - " + scoreToWrite); // Debug statement
            writer.write(nameToWrite + "," + scoreToWrite);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScore_easy(String name, int score) {
        this.name = name;
        this.score = score;
        System.out.println("Received Score: " + this.score);
        writeToFile_easy(name, score);
    }

    public static void main(String[] args) {
        main_page main = new main_page();
        Snake_easy_level easy = new Snake_easy_level();

        WAR_easy war = new WAR_easy(main.getName_easy(), easy.getScore());
        war.setScore_easy(main.getName_easy(), easy.getScore());
    }

}
