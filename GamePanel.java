
package model;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
    
    //ATTRIBUTI
    protected static final int GAME_WIDTH = 1000;  
    protected static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555)); //Il tavolo da pong ha un rapporto visivo 5:9 quindi prendiamo la larghezza e moltiplichiamo per queto rapporto
    protected static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    protected static final int BALL_DIAMETER = 20;
    protected static final int PADDLE_WIDTH = 25;
    protected static final int PADDLE_HEIGHT = 100;
    public Thread gameThread;
    public Image image;
    public Graphics graphics;
    public Random random;
    public Paddle paddle1;
    public Paddle paddle2;
    public Ball ball;
    public Score score;
    
    //COSTRUTTORI
    public GamePanel() {
        this.newPaddles();
        this.newBall();
        this.score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new KeyCheck());
        this.setPreferredSize(SCREEN_SIZE);
        
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }
    
    //METODI
    public void newBall() {
        
    }
    
    public void newPaddles() {
        this.paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        this.paddle2 = new Paddle((GAME_WIDTH - PADDLE_WIDTH), (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
    }
    
    @Override
    public void paint(Graphics g) {
        this.image = createImage(this.getWidth(), this.getHeight());
        this.graphics = this.image.getGraphics();
        this.draw(this.graphics);
        g.drawImage(this.image, 0, 0, this);
    }
    
    public void draw(Graphics graphics) {
        this.paddle1.draw(graphics);
        this.paddle2.draw(graphics);
    }
    
    public void move() {
        
    }
    
    public void checkCollision() {
        //COLLISIONI CON IL BORDO DEL FRAME
        if(this.paddle1.y <= 0)
            this.paddle1.y = 0;
        
        if(this.paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            this.paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        
        if(this.paddle2.y <= 0)
            this.paddle2.y = 0;
        
        if(this.paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            this.paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
            
    }
    
    @Override
    public void run() {
        //GAME LOOP 60FPS
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000L / amountOfTicks;
        double delta = 0;   
        
        while(true) {
            long nowTime = System.nanoTime();
            delta += (nowTime - lastTime) / ns;
            lastTime = nowTime;
            if(delta >= 1) {
                this.move();
                this.checkCollision();
                this.repaint();
                delta--;
            }
        }
       
    }
    
    //INNER CLASS
    public class KeyCheck extends KeyAdapter {
        
        //METODI INNER CLASS
        @Override
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
    
}
