
package model;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle {
    
    //ATTRIBUTI
    protected static int SCORE_WIDTH;
    protected static int SCORE_HEIGHT;
    protected int scorePlayer1;
    protected int scorePlayer2;
    
    //COSTRUTTORI
    public Score() {
        
    }
    
    public Score(int width, int height) {
        Score.SCORE_WIDTH = width;
        Score.SCORE_HEIGHT = height;
    }
    
    //METODI
    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Consolas", Font.PLAIN, 60));
        graphics.drawLine((SCORE_WIDTH / 2), 0, (SCORE_WIDTH / 2), SCORE_HEIGHT);
        graphics.drawString(String.valueOf(this.scorePlayer2 / 10) + String.valueOf(this.scorePlayer2 % 10), (SCORE_WIDTH / 2) + 20, 50);
        graphics.drawString(String.valueOf(this.scorePlayer1 / 10) + String.valueOf(this.scorePlayer1 % 10), (SCORE_WIDTH / 2) - 85, 50);
    }
}
