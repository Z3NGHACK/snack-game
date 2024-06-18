package Snake_Game;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class leaderboard_meduim extends JFrame {
    private static final String CSV_FILE = "C:\\Users\\senghak\\eclipse-workspace\\Lab\\meduim_file.csv"; 
    private JTable jTable;

    public leaderboard_meduim() {
        setTitle("Leaderboard - Medium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        jTable = new JTable();
        JScrollPane jScrollPane = new JScrollPane(jTable);
        add(jScrollPane);

        populateTable();

        setVisible(true);
    }

    private void populateTable() {
        List<player_meduim> sortedPlayers = readAndSortCsvData();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Rank");
        model.addColumn("Name");
        model.addColumn("Score");

        int rank = 1;
        for (player_meduim player : sortedPlayers) {
            Object[] row = {rank, player.getName(), player.getScore()};
            model.addRow(row);
            rank++;
        }

        jTable.setModel(model);
    }

    public static List<player_meduim> readAndSortCsvData() {
        List<player_meduim> players = new ArrayList<>();
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
                        players.add(new player_meduim(name, score));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid score format for player " + name);
                    }
                }
            }
        } catch (FileNotFoundException e) {
        	System.err.println("CSV file not found: " + e.getMessage());
        }

        Collections.sort(players, Comparator.comparingInt(player_meduim::getScore).reversed());

        int rank = 1;
        for (player_meduim player : players) {
            player.setRank(rank);
            rank++;
        }

        return players;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new leaderboard_meduim());
    }
}

class player_meduim {
    private int rank;
    private String name;
    private int score;

    public player_meduim(String name, int score) {
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
