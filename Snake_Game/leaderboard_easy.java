package Snake_Game;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class leaderboard_easy extends JFrame {
    private static final String CSV_FILE = "C:\\Users\\senghak\\eclipse-workspace\\Lab\\easy_file.csv"; 
    private JTable jTable;

    public leaderboard_easy() {
        setTitle("Leaderboard - Easy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        jTable = new JTable();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        add(jScrollPane);

        populateTable();

        setVisible(true);
    }

    private void populateTable() {
        List<player_easy> sortedPlayers = readAndSortCsvData();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Rank");
        model.addColumn("Name");
        model.addColumn("Score");

        int rank = 1;
        for (player_easy player : sortedPlayers) {
            Object[] row = {rank, player.getName(), player.getScore()};
            model.addRow(row);
            rank++;
        }

        jTable.setModel(model);
    }

    public static List<player_easy> readAndSortCsvData() {
        List<player_easy> players = new ArrayList<>();
        File file = new File(CSV_FILE);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int score;
                    try {
                        score = Integer.parseInt(parts[1].trim());
                        players.add(new player_easy(name, score));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid score format for player " + name);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + e.getMessage());
        }

        Collections.sort(players, Comparator.comparingInt(player_easy::getScore).reversed());

        int rank = 1;
        for (player_easy player : players) {
            player.setRank(rank);
            rank++;
        }

        return players;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new leaderboard_easy());
    }
}

class player_easy {
    private int rank;
    private String name;
    private int score;

    public player_easy(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
