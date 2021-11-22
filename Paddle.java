
package model;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
    
    //ATTRIBUTI
    public int id;
    protected int yVelocity;
    protected int speed = 10;
    
    
    //COSTRUTTORI
    public Paddle() {
        
    }
    
    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }
    
    //METODI
    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    this.setYDirection(-speed);
                    this.move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    this.setYDirection(speed);
                    this.move();
                }
            break;
            
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    this.setYDirection(-speed);
                    this.move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    this.setYDirection(speed);
                    this.move();
                }
            break;
        }
    }
    
    public void keyReleased(KeyEvent e) {
            switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    this.setYDirection(0);
                    this.move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    this.setYDirection(0);
                    this.move();
                }
            break;
            
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    this.setYDirection(0);
                    this.move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    this.setYDirection(0);
                    this.move();
                }
            break;
        }
    }
    
    public void setYDirection(int yDirection) {
        this.yVelocity = yDirection;
    }
    
    public void move() {
        this.y = this.y + this.yVelocity;
    }
    
    public void draw(Graphics graphics) {
        if(this.id == 1) {
            graphics.setColor(Color.WHITE);
        }
        else {
            graphics.setColor(Color.white);
        }
        
        graphics.fillRect(this.x, this.y, this.width, this.height); //ricavati dal rettangolo padre
    }
}
