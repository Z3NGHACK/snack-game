package Snake_Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake_meduim_level extends JFrame implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;

    private static final int GRID_SIZE = 25;
    private static final int TILE_SIZE = 25;

    private LinkedList<Point> snake;
    private Point food;
    private int direction; 
    private boolean running;
    private int score; 
    private Timer timer; 
    private int initialDelay = 75; 
    private int speedIncrement = 5; 
    private int maxSpeed = 50; 
    private List<Point> obstacles; 
    private int snakeMaxLength = 3; 
    private Image foodImage1;
    private Image foodImage2;
    private Image foodImage;
    private Image backgroundImage;
    private JLabel scoreLabel;
    private Timer foodAndHeadAnimationTimer;    
    private boolean foodImageToggle = false;
    private boolean headImageToggle = false;
    private boolean headImageToggleUp = false;
    private boolean headImageToggleRight = false;
    private boolean headImageToggleLeft = false;
    private boolean headImageToggleDown = false;
    private boolean obstacleImageToggle = false;
    
    private Image headImage;
    private Image headImage1;
    private Image bodyImage;
    private Image tailImage;
    private Image headImageUp1;
    private Image headImageDown1;
    private Image headImageRight1;
    private Image headImageLeft1;
    private Image headImageUp;
    private Image headImageDown;
    private Image headImageRight;
    private Image headImageLeft;
    private Image headImage2;
    private Image headImageUp2;
    private Image headImageDown2;
    private Image headImageRight2;
    private Image headImageLeft2;
    private Image obstacleImage;
    private Image obstacleImage1;
    private Image obstacleImage2;
    private Image bodyImageUp;
    private Image bodyImageDown;
    private Image bodyImageRight;
    private Image bodyImageLeft;
    private Image tailImageUp;
    private Image tailImageDown;
    private Image tailImageRight;
    private Image tailImageLeft;

    public Snake_meduim_level() {
        setTitle("Snake Game");
        setSize(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(this);

        snake = new LinkedList<>();
        snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2));
        direction = 1; 

        obstacles = new LinkedList<>(); 
        AudioPlayer.playSound("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\audio\\playing.wav");
        
        spawnFood(); 
        loadImage();
        spawnObstacles();
        createScoreLabel();
        
        running = true;
        score = 0; // Initialize score
        timer = new Timer(initialDelay, this);
        timer.start();
    }
    
    private void loadImage() {
        try {
            backgroundImage = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\bg.jpg").getImage();
            foodImage1 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\food1.jpg").getImage();
            foodImage2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\food2.jpg").getImage();
            obstacleImage1 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\obstacle.jpg").getImage();
            obstacleImage2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\obstacle2.jpg").getImage();
            bodyImage = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\body.jpg").getImage();
            tailImage = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\tail.jpg").getImage();
            headImage1 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head.jpg").getImage();
            headImage2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head2.jpg").getImage();
            headImage = headImage1;
            foodImage = foodImage1;
            obstacleImage = obstacleImage1;            
            
            headImageUp1 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head_up.jpg").getImage();
            headImageDown1 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head_down.jpg").getImage();
            headImageLeft1 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head_left.jpg").getImage();
            headImageRight1 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head_right.jpg").getImage();

            headImageUp2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head2_up.jpg").getImage();
            headImageDown2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head2_down.jpg").getImage();
            headImageLeft2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head2_left.jpg").getImage();
            headImageRight2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\head2_right.jpg").getImage();

            headImageUp = headImageUp1;
            headImageDown = headImageDown1;
            headImageRight = headImageRight1;
            headImageLeft = headImageLeft1;
            
            bodyImageUp = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\body_up.jpg").getImage();
            bodyImageDown = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\body_down.jpg").getImage();
            bodyImageLeft = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\body_left.jpg").getImage();
            bodyImageRight = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\body_right.jpg").getImage();
            
            tailImageUp = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\tail_up.jpg").getImage();
            tailImageDown = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\tail_down.jpg").getImage();
            tailImageLeft = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\tail_left.jpg").getImage();
            tailImageRight = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\tail_right.jpg").getImage();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        foodAndHeadAnimationTimer = new Timer(500, new ActionListener() { 
        	@Override
            public void actionPerformed(ActionEvent e) {
        		headImageToggle = !headImageToggle;
                headImage = headImageToggle ? headImage1 : headImage2;
                
                foodImageToggle = !foodImageToggle;
                foodImage = foodImageToggle ? foodImage1 : foodImage2;
                
        		headImageToggleUp = !headImageToggleUp;
                headImageUp = headImageToggleUp ? headImageUp1 : headImageUp2;

        		headImageToggleDown = !headImageToggleDown;
                headImageDown = headImageToggleDown ? headImageDown1 : headImageDown2;

        		headImageToggleRight = !headImageToggleRight;
                headImageRight = headImageToggleRight ? headImageRight1 : headImageRight2;
                
        		headImageToggleLeft = !headImageToggleLeft;
                headImageLeft = headImageToggleLeft ? headImageLeft1 : headImageLeft2;

        		obstacleImageToggle = !obstacleImageToggle;
                obstacleImage = obstacleImageToggle ? obstacleImage1 : obstacleImage2;
                repaint();
            }
        });
        foodAndHeadAnimationTimer.start(); 
    }

    private void spawnFood() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(GRID_SIZE);
            y = rand.nextInt(GRID_SIZE);
        } while (snake.contains(new Point(x, y)) || obstacles.contains(new Point(x, y)));

        food = new Point(x, y);
    }
  
    private void spawnObstacles() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) { 
            int x, y;
            do {
                x = rand.nextInt(GRID_SIZE);
                y = rand.nextInt(GRID_SIZE);
            } while (snake.contains(new Point(x, y)) || food.equals(new Point(x, y)) ||
                     obstacles.contains(new Point(x, y)) || isOnBorder(x, y));
            obstacles.add(new Point(x, y));
        }
    }

    private boolean isOnBorder(int x, int y) {
        return x == 0 || x == GRID_SIZE - 1 || y == 0 || y == GRID_SIZE - 1;
    }

    private void move() {
        Point head = snake.getFirst();
        Point newHead;

        switch (direction) {
            case 0: // up
                newHead = new Point(head.x, (head.y - 1 + GRID_SIZE) % GRID_SIZE);
                break;
            case 1: // right
                newHead = new Point((head.x + 1) % GRID_SIZE, head.y);
                break;
            case 2: // down
                newHead = new Point(head.x, (head.y + 1) % GRID_SIZE);
                break;
            case 3: // left
                newHead = new Point((head.x - 1 + GRID_SIZE) % GRID_SIZE, head.y);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }

        if (snake.contains(newHead) || obstacles.contains(newHead)) {
            running = false;
            timer.stop();
            playLoseSound();
            endGame();
        } else {
            snake.addFirst(newHead);
            if (snake.size() > snakeMaxLength) {
                snake.removeLast();
            }
        }

        if (newHead.equals(food)) {
            spawnFood();
            updateScore();
            playEatingSound();
            if (score % speedIncrement == 0 && initialDelay > maxSpeed) {
                initialDelay /= 2;
                timer.setDelay(initialDelay);
            }
            snakeMaxLength += 1;
        }
    }
    
    public static void playEatingSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\audio\\eating.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep( 200);
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void playLoseSound() {
    	try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\audio\\gameOver.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep( 500);
	        clip.close();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}


    private void createScoreLabel() {
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(0, 0,30, 10); 
        add(scoreLabel);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        Point foodLocation = food.getLocation();
        g.drawImage(foodImage, foodLocation.x * TILE_SIZE, foodLocation.y * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);

        g.drawImage(foodImage, food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);

        for (Point obstacle : obstacles) {
            g.drawImage(obstacleImage, obstacle.x * TILE_SIZE, obstacle.y * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
        }


        int headX = snake.getFirst().x * TILE_SIZE;
        int headY = snake.getFirst().y * TILE_SIZE;

        switch (direction) {
            case 0:
                g.drawImage(headImageUp, headX, headY, TILE_SIZE, TILE_SIZE, this);
                break;
            case 1: 
                g.drawImage(headImageRight, headX, headY, TILE_SIZE, TILE_SIZE, this);
                break;
            case 2: 
                g.drawImage(headImageDown, headX, headY, TILE_SIZE, TILE_SIZE, this);
                break;
            case 3: 
                g.drawImage(headImageLeft, headX, headY, TILE_SIZE, TILE_SIZE, this);
                break;
        }
        
        for (int i = 1; i < snake.size(); i++) {
            Point current = snake.get(i);
            int x = current.x * TILE_SIZE;
            int y = current.y * TILE_SIZE;

            Point next = (i < snake.size() - 1) ? snake.get(i + 1) : snake.get(i - 1);
            int nextX = next.x * TILE_SIZE;
            int nextY = next.y * TILE_SIZE;

            if (i == snake.size() - 1) {
                drawTail(g, x, y, nextX, nextY);
            } else {
                g.drawImage(bodyImage, x, y, TILE_SIZE, TILE_SIZE, this);
            }
        }

        scoreLabel.setText("Score: " + score);

        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawTail(Graphics g, int x, int y, int nextX, int nextY) {
        if (snake.size() == 1) {
            g.drawImage(tailImage, x, y, TILE_SIZE, TILE_SIZE, this);
        } else if (x == nextX && y == nextY) {
            g.drawImage(tailImage, x, y, TILE_SIZE, TILE_SIZE, this);
        } else if (x == nextX) {
            if (y < nextY) {
                g.drawImage(tailImageDown, x, y, TILE_SIZE, TILE_SIZE, this);
            } else {
                g.drawImage(tailImageUp, x, y, TILE_SIZE, TILE_SIZE, this);
            }
        } else if (y == nextY) {
            if (x < nextX) {
                g.drawImage(tailImageRight, x, y, TILE_SIZE, TILE_SIZE, this);
            } else {
                g.drawImage(tailImageLeft, x, y, TILE_SIZE, TILE_SIZE, this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_UP) && (direction != 2)) {
            direction = 0;
        } else if ((key == KeyEvent.VK_DOWN) && (direction != 0)) {
            direction = 2;
        } else if ((key == KeyEvent.VK_LEFT) && (direction != 1)) {
            direction = 3;
        } else if ((key == KeyEvent.VK_RIGHT) && (direction != 3)) {
            direction = 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public int getScore() {
        return this.score;
     }
    
    private void updateScore() {
        this.score++;
        System.out.println("Updated Score: " + this.score);
    }
    
    private int calculatePlayerRank(int playerScore) {
        List<player_meduim> leaderboardData = leaderboard_meduim.readAndSortCsvData();
        int rank = 1;
        for (player_meduim player : leaderboardData) {
            if (playerScore >= player.getScore()) {
                return rank;
            }
            rank++;
        }
        return rank;
    }
    
    private void endGame() {
        int playerRank = calculatePlayerRank(score);
        String message;
        AudioPlayer.stopSound();
        
        if(playerRank == 1) {
        	AudioPlayer.playSound("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\audio\\firework.wav");
            ImageIcon congratImage = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\c.gif"); 
            JLabel messageLabel = new JLabel("<html>Congratulations! You are in the 1st rank!<br>Your score is: " + score + ".</html>");
            messageLabel.setIcon(congratImage);
            messageLabel.setHorizontalTextPosition(JLabel.CENTER);
            messageLabel.setVerticalTextPosition(JLabel.BOTTOM);

            Object[] options = {"Try Again", "Close", "Back to menu"};
            int option = JOptionPane.showOptionDialog(
                    this,
                    messageLabel,
                    "Congratulations",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (option == JOptionPane.YES_OPTION) {
                restartGame();
            } else if (option == JOptionPane.NO_OPTION) {
                main_page.gameEnded_meduim(this.score);
                System.exit(0);
            } else if (option == JOptionPane.CANCEL_OPTION) {
                main_page.gameEnded_meduim(this.score);
                main_page(); 
            }
        } else {
            message = "Game over! Your score is: " + score + ". Your rank is: " + playerRank;
            int option = JOptionPane.showOptionDialog(
                    this,
                    message,
                    "Game Over",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{"Try Again", "Close", "Back to menu"},
                    "OK"
            );

            if (option == JOptionPane.YES_OPTION) {
                restartGame();
            } else if (option == JOptionPane.NO_OPTION) {
                main_page.gameEnded_meduim(this.score);
                System.exit(0);
            } else if (option == JOptionPane.CANCEL_OPTION) {
                main_page.gameEnded_meduim(this.score);
                main_page();
            }
        }
    }

   
	private void restartGame() {
		snake.clear(); 
	    snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2));
	    snake.add(new Point(GRID_SIZE / 2 - 1, GRID_SIZE / 2));
	    snake.add(new Point(GRID_SIZE / 2 - 2, GRID_SIZE / 2)); 
	    direction = 1;
        AudioPlayer.playSound("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\playing.wav");
	
	    score = 0; 
	    scoreLabel.setText("Score: " + score); 
	
	    spawnFood(); 
	
	    running = true;
	    timer.restart(); 
	  }
	
    private void main_page() {
    	main_page main = new main_page();
    	main.mode_page();
    	dispose();
    }

  public static void main(String[] args) {
	  SwingUtilities.invokeLater(() -> new Snake_meduim_level().setVisible(true));
  }
}