package snakegame;

import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel implements ActionListener {

    private Image apple;
    private Image dot;
    private Image head;

    // Game area dimensions defined as constants
    private final int BOARD_WIDTH = 300;
    private final int BOARD_HEIGHT = 300;

    private final int ALL_DOTS = 900;
    private final int DOT_SIZE = 10;
    private final int RANDOM_POSITION = 29;

    private int apple_x;
    private int apple_y;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;

    private boolean inGame = true;
    private boolean paused = false;

    public Clip backgroundMusic;

    private int dots;
    private Timer timer;
    private int score;

    Board() {
        addKeyListener(new TAdapter());

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        setFocusable(true);

        loadImages();
        initGame();
    }

    public void playBackgroundMusic(String musicFile) {
        try {
            // Open an audio input stream.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("src/snakegame/sounds/" + musicFile));

            // Get a sound clip resource.
            backgroundMusic = AudioSystem.getClip();

            // Open the audio clip and load the sound.
            backgroundMusic.open(audioIn);

            // Start playing the background music in a loop.
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void loadImages() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
        apple = i1.getImage();

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
        dot = i2.getImage();

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/head.png"));
        head = i3.getImage();
    }

    public void initGame() {
        dots = 3;
        score = 0;

        for (int i = 0; i < dots; i++) {
            y[i] = 50;
            x[i] = 50 - i * DOT_SIZE;
        }

        locateApple();

        timer = new Timer(140, this);
        timer.start();

        playBackgroundMusic("background.wav");
    }

    public void resetGame() {
        inGame = true;
        paused = false;
        rightDirection = true;
        leftDirection = false;
        upDirection = false;
        downDirection = false;
        initGame(); // Reinitialize the game variables
    }

    public void playSound(String soundFile) {
        try {
            // Open an audio input stream.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("src/snakegame/sounds/" + soundFile));

            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();

            // Open the audio clip and load the sound.
            clip.open(audioIn);

            // Start playing the sound.
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void locateApple() {
        int r = (int)(Math.random() * RANDOM_POSITION);
        apple_x = r * DOT_SIZE;

        r = (int)(Math.random() * RANDOM_POSITION);
        apple_y = r * DOT_SIZE;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g) {
        if (inGame) {
            g.drawImage(apple, apple_x, apple_y, this);

            for (int i = 0 ; i < dots; i++) {
                if (i == 0) {
                    g.drawImage(head, x[i], y[i], this);
                } else {
                    g.drawImage(dot, x[i], y[i], this);
                }
            }

            // Draw the score
            drawScore(g);

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    // Draw the score on the screen
    public void drawScore(Graphics g) {
        String scoreMsg = "Score: " + score;
        Font small = new Font("Helvetica", Font.BOLD, 12);
        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(scoreMsg, 10, BOARD_HEIGHT - 10);
    }

    public void gameOver(Graphics g) {

        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
        playSound("gameover.wav");

        String msg = "Game Over!";
        String scoreMsg = "Final Score: " + score;
        String restartMsg = "Press 'R' to Play Again"; // Message for restarting

        Font font = new Font("SAN_SERIF", Font.BOLD, 14);
        FontMetrics metrics = getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(msg, (BOARD_WIDTH - metrics.stringWidth(msg)) / 2, BOARD_HEIGHT / 2 - 20);
        g.drawString(scoreMsg, (BOARD_WIDTH - metrics.stringWidth(scoreMsg)) / 2, BOARD_HEIGHT / 2);
        g.drawString(restartMsg, (BOARD_WIDTH - metrics.stringWidth(restartMsg)) / 2, BOARD_HEIGHT / 2 + 20);  // Play again message
    }

    public void move() {
        for (int i = dots ; i > 0 ; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (leftDirection) {
            x[0] = x[0] - DOT_SIZE;
        }
        if (rightDirection) {
            x[0] = x[0] + DOT_SIZE;
        }
        if (upDirection) {
            y[0] = y[0] - DOT_SIZE;
        }
        if (downDirection) {
            y[0] = y[0] + DOT_SIZE;
        }
    }

    public void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++;
            score++;
            locateApple();

            playSound("eat.wav");

            // Increase speed slightly as snake grows
            int delay = Math.max(40, timer.getDelay() - 5);  // Minimum delay of 40ms
            timer.setDelay(delay);
        }
    }

    public void checkCollision() {
        for(int i = dots; i > 0; i--) {
            if (( i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }

        if (y[0] >= BOARD_HEIGHT || x[0] >= BOARD_WIDTH || y[0] < 0 || x[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (inGame && !paused) {
            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    // KeyAdapter class for controlling snake movement and pausing/resuming the game
    public class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_UP && (!downDirection)) {
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }

            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }

            // Pause/Resume the game with the 'P' key
            if (key == KeyEvent.VK_P) {
                paused = !paused;
            }

            // Restart the game with the 'R' key after Game Over
            if (!inGame && key == KeyEvent.VK_R) {
                resetGame(); // Call resetGame to start fresh
            }
        }
    }

}
