package Snake_Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WAR_hard {
    private String name;  
    private int score;    
    private final String filePath_hard = "hard_file.csv";

    public WAR_hard(String name, int score) {
        this.name = name;
        this.score = score;
    }

    private void writeToFile_hard(String nameToWrite, int scoreToWrite) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath_hard, true))) {
            System.out.println("Writing to file: Name - " + nameToWrite + ", Score - " + scoreToWrite);
            writer.write(nameToWrite + "," + scoreToWrite);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScore_hard(String name, int score) {
        this.name = name;
        this.score = score;
        System.out.println("Received Score: " + this.score);
        writeToFile_hard(name, score);
    }

    public static void main(String[] args) {
        main_page main = new main_page();
        Snake_hard_level hard = new Snake_hard_level();

        WAR_hard war = new WAR_hard(main.getName_hard(), hard.getScore());
        war.setScore_hard(main.getName_hard(), hard.getScore());
    }

}
