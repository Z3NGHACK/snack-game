package Snake_Game;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class main_page {
    private Image backgroundImage, backgroundImage2, congratImage;
    private JFrame frame;
    private int imageCount = 1;
    private JButton start_btn, continue_btn, easy_btn, 
    				meduim_btn, hard_btn, leaderBoard_btn, 
    				easyl_btn, meduiml_btn, hardl_btn, 
    				game_mode, leaderboard, back_btn, 
    				cls_btn, try_btn, menu_btn;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, congrat;
    private static JTextField tf_easy;
	private static JTextField tf_meduim;
	private static JTextField tf_hard;
    private JPanel mainPanel;
    private String name; 
    private Timer animation;
    private boolean pageAnimation = false;
    
    private static ImageIcon startImageIcon, ldImageIcon, 
    				  gmImageIcon, esImageIcon, 
    				  mdImageIcon, hdImageIcon, 
    				  ctImageIcon, trImageIcon, 
    				  mnImageIcon, clImageIcon, bcImageIcon;

    public main_page() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        loadResources();
        first_page();
        frame.setContentPane(mainPanel);
    }
    
    private void loadResources() {
        try {
            backgroundImage = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\snake_img.jpg").getImage();
            backgroundImage2 = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\bg2.jpg").getImage();
            congratImage = new ImageIcon("C:\\\\Users\\\\senghak\\\\eclipse-workspace\\\\Lab\\\\src\\\\Snake_Game\\\\image\\c.gif").getImage();
            startImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\st.png");
            ldImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\lb.png");
            gmImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\gm.png");
            esImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\es.png");
            mdImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\md.png");
            hdImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\hd.png");
            ctImageIcon = new  ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\co.png");
            trImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\tr.png");
            mnImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\mn.png");
            clImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\cl.png");
            bcImageIcon = new ImageIcon("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\image\\bk.png");
            
            AudioPlayer.playSound("C:\\Users\\senghak\\eclipse-workspace\\Lab\\src\\Snake_Game\\audio\\mainSong.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void first_page() {
    	mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        mainPanel.setLayout(null);

        start_btn = new JButton(startImageIcon);
        start_btn.setBounds(170, 230, 160, 50);
        start_btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            start_page();
          }
        });
        mainPanel.add(start_btn);
        
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
    
    public void start_page() {
    	mainPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	
	    mainPanel.setLayout(null);

    	lb6 = new JLabel("OPTION");
    	lb6.setBounds(110, 110, 300, 40);
    	lb6.setFont(new Font("Arial", Font.BOLD, 18));
    	mainPanel.add(lb6);
    	
    	game_mode = new JButton(gmImageIcon);
    	game_mode.setBounds(80, 160, 130, 37);
    	game_mode.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mode_page();
        	}
        });
        mainPanel.add(game_mode) ;
        
        leaderboard = new JButton(ldImageIcon);
        leaderboard.setBounds(80, 220, 130, 37);
        leaderboard.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		leaderBoard_page();
        	}
        });
        mainPanel.add(leaderboard) ;
        
        frame.setContentPane(mainPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    
    public void leaderBoard_page() {
    	mainPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	
	    mainPanel.setLayout(null);

    	lb6 = new JLabel("LeaderBoard");
    	lb6.setBounds(100, 105, 150, 35);
    	lb6.setFont(new Font("Arial", Font.ITALIC, 17));
    	mainPanel.add(lb6);
    	
    	easyl_btn = new JButton(esImageIcon);
      	easyl_btn.setBounds(85, 140, 120, 28);
        easyl_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		leaderboard_easy leaderboard = new leaderboard_easy();
        		leaderboard.setVisible(true);
        	}
        });
        mainPanel.add(easyl_btn) ;
        
        meduiml_btn = new JButton(mdImageIcon);
        meduiml_btn.setBounds(85, 180, 120, 28);
        meduiml_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		leaderboard_meduim leaderboard = new leaderboard_meduim();
        		leaderboard.setVisible(true);
        	}
        });
        mainPanel.add(meduiml_btn);
    
        hardl_btn = new JButton(hdImageIcon); 
        hardl_btn.setBounds(85, 220, 120, 28);
        hardl_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		leaderboard_hard leaderboard = new leaderboard_hard();
        		leaderboard.setVisible(true);
        	}
        });
        mainPanel.add(hardl_btn);
        
        back_btn = new JButton(bcImageIcon);
        back_btn.setBounds(85, 255, 70, 31);
        back_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		start_page();
        	}
        });
        mainPanel.add(back_btn) ;

        frame.setContentPane(mainPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    
    
    public void mode_page() {
    	mainPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	
	    mainPanel.setLayout(null);
      
    	lb2 = new JLabel("Game Mode");
    	lb2.setBounds(100, 105, 150, 35);
    	lb2.setFont(new Font("Arial", Font.BOLD, 17));
    	mainPanel.add(lb2);
      
    	easy_btn = new JButton(esImageIcon);
      	easy_btn.setBounds(85, 140, 120, 28);
        easy_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		easy_mode();
        	}
        });
        mainPanel.add(easy_btn) ;
        
        meduim_btn = new JButton(mdImageIcon);
        meduim_btn.setBounds(85, 180, 120, 28);
        meduim_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		meduim_mode();
        	}
        });
        mainPanel.add(meduim_btn);
    
        hard_btn = new JButton(hdImageIcon);
        hard_btn.setBounds(85, 220, 120, 28);
        hard_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		hard_mode();
        	}
        });
        mainPanel.add(hard_btn);
        
        back_btn = new JButton(bcImageIcon);
        back_btn.setBounds(85, 255, 70, 31);
        back_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		start_page();
        	}
        });
        mainPanel.add(back_btn) ;
      
        frame.setContentPane(mainPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    
    
    public void easy_mode() {
    	mainPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	
	    mainPanel.setLayout(null);

    	lb4 = new JLabel("Input your name");
    	lb4.setBounds(85, 110, 150, 40);
    	lb4.setFont(new Font("Arial", Font.BOLD, 17));
    	mainPanel.add(lb4);
    	
    	lb5 = new JLabel();
    	lb5.setBounds(85, 150, 170, 20);
    	lb5.setFont(new Font("Arial", Font.PLAIN, 12));
    	mainPanel.add(lb5);
        
        tf_easy = new JTextField();
        tf_easy.setBounds(85, 175, 120, 30);
        tf_easy.setFont(new Font("Arial", Font.BOLD, 17));
        tf_easy.setBackground(Color.WHITE);
        mainPanel.add(tf_easy);

        continue_btn = new JButton(ctImageIcon);
        continue_btn.setBounds(85, 215, 120, 36);
        continue_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String get = tf_easy.getText();
                if (get.isEmpty()) {
                    lb5.setText("Please input your name");
                } else {
                	AudioPlayer.stopSound();
                    lb5.setText("");
                    Snake_easy_level snakeGame = new Snake_easy_level();
                    snakeGame.setVisible(true);
                }
            }
        });
        mainPanel.add(continue_btn);
        
        back_btn = new JButton(bcImageIcon);
        back_btn.setBounds(85, 255, 70, 31);
        back_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mode_page();
        	}
        });
        mainPanel.add(back_btn) ;

        frame.setContentPane(mainPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    public static void gameEnded_easy(int finalScore) {
        String playerName = getName_easy();
        WAR_easy war = new WAR_easy(playerName, finalScore);
        war.setScore_easy(playerName, finalScore);
    }
    

    public void meduim_mode() {
    	mainPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	
	    mainPanel.setLayout(null);

	    lb4 = new JLabel("Input your name");
    	lb4.setBounds(85, 110, 150, 40);
    	lb4.setFont(new Font("Arial", Font.BOLD, 17));
    	mainPanel.add(lb4);
    	
    	lb5 = new JLabel();
    	lb5.setBounds(85, 150, 170, 20);
    	lb5.setFont(new Font("Arial", Font.PLAIN, 12));
    	mainPanel.add(lb5);
        
        tf_meduim = new JTextField();
        tf_meduim.setBounds(85, 175, 120, 30);
        tf_meduim.setFont(new Font("Arial", Font.BOLD, 17));
        tf_meduim.setBackground(Color.WHITE);
        mainPanel.add(tf_meduim);

        continue_btn = new JButton(ctImageIcon);
        continue_btn.setBounds(85, 215, 120, 36);
        continue_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String get = tf_meduim.getText();
                if (get.isEmpty()) {
                    lb5.setText("Please input your name");
                } else {
                	AudioPlayer.stopSound();
                    lb5.setText("");
                    Snake_meduim_level snakeGame = new Snake_meduim_level();
                    snakeGame.setVisible(true);
                }
            }
        });
        mainPanel.add(continue_btn);
        
        back_btn = new JButton(bcImageIcon);
        back_btn.setBounds(85, 255, 70, 31);
        back_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mode_page();
        	}
        });
        mainPanel.add(back_btn) ;

        frame.setContentPane(mainPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    public static void gameEnded_meduim(int finalScore) {
        String playerName = getName_meduim(); 
        WAR_meduim war = new WAR_meduim(playerName, finalScore);
        war.setScore_meduim(playerName, finalScore);
    }
    
    
    
    public void hard_mode() {
    	mainPanel = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(backgroundImage2, 0, 0, getWidth(), getHeight(), this);
	        }
	    };
	
	    mainPanel.setLayout(null);

	    lb4 = new JLabel("Input your name");
    	lb4.setBounds(85, 110, 150, 40);
    	lb4.setFont(new Font("Arial", Font.BOLD, 17));
    	mainPanel.add(lb4);
    	
    	lb5 = new JLabel();
    	lb5.setBounds(85, 150, 170, 20);
    	lb5.setFont(new Font("Arial", Font.PLAIN, 12));
    	mainPanel.add(lb5);
        
        tf_hard = new JTextField();
        tf_hard.setBounds(85, 175, 120, 30);
        tf_hard.setFont(new Font("Arial", Font.BOLD, 17));
        tf_hard.setBackground(Color.WHITE);
        mainPanel.add(tf_hard);

        continue_btn = new JButton(ctImageIcon);
        continue_btn.setBounds(85, 215, 120, 36);
        continue_btn.setFont(new Font("Arial", Font.BOLD, 17));
        continue_btn.setBackground(Color.white);
        continue_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String get = tf_hard.getText();
                if (get.isEmpty()) {
                    lb5.setText("Please input your name");
                } else {
                	AudioPlayer.stopSound();
                    lb5.setText("");
                    Snake_hard_level snakeGame = new Snake_hard_level();
                    snakeGame.setVisible(true);
                }
            }
        });
        mainPanel.add(continue_btn);
        
        back_btn = new JButton(bcImageIcon);
        back_btn.setBounds(85, 255, 70, 31);
        back_btn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mode_page();
        	}
        });
        mainPanel.add(back_btn) ;

        frame.setContentPane(mainPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    public static void gameEnded_hard(int finalScore) {
        String playerName = getName_hard(); 
        WAR_hard war = new WAR_hard(playerName, finalScore);
        war.setScore_hard(playerName, finalScore);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new main_page());
    }

    public static String getName_easy() {
    	return tf_easy.getText();   
    }
  
    public static String getName_meduim() {
        return tf_meduim.getText();
    }
  
    public static String getName_hard() {
    	return tf_hard.getText();
    }
}