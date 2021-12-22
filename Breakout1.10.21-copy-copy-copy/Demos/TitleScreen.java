package Demos;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;


public class TitleScreen
{
    // instance variables - replace the example below with your own
    final int PADDING = 10, LEFTSIDEX = 0, MAXTOPY = 800, RIGHTSIDEX = 400;
    final String fontStyle = "Montserrat";
    public void drawString(Graphics2D g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
    public void canvasClean(Graphics2D brush) {
        brush.clearRect(0, 0, 400, 800);
    }
    public int getTextWidth(Graphics2D obj, String text) {
        Font f = obj.getFont();
        FontMetrics fm = obj.getFontMetrics(f);
        int width = fm.stringWidth(text);
        return width;
    }
    public void drawTitle(Graphics2D brush) {
        brush.setColor(Color.WHITE);
        int textSize, centerAlignment, textWidth, yLevel;
        String text;
        textSize = 40;
        yLevel = 150;
        text = "BREAKOUT GAME";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);

        textSize = 25;
        yLevel = 220;
        text = "Made by Zach B.";
        brush.setFont(new Font(fontStyle, Font.PLAIN, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);

        yLevel = 440;
        text = "Press 1 for Breakout";
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);

        yLevel = 470;
        text = "Press 2 for Breakout Twist";
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);

        yLevel = 500;
        text = "Press H for Directions and Controls";
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
    }
    public void displayControls(Graphics2D brush) {
        canvasClean(brush);
        brush.setColor(Color.WHITE);
        int textSize, centerAlignment, specificAlignment, textWidth, yLevel;
        String text;

        textSize = 15;
        yLevel = 100;
        text = "How to Play:";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        specificAlignment = (400 / 4) - (textWidth / 2);
        brush.drawString(text, specificAlignment, yLevel);
        
        text = "Breakout 1";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        specificAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, specificAlignment, 50);

        textSize = 12;
        text = "Controls:";
        textWidth = getTextWidth(brush, text);
        specificAlignment = ((400 / 4) * 3) - (textWidth / 2);
        brush.drawString(text, specificAlignment, yLevel);
        
        text = "Paddle: Use A and D\nto move left and right.";
        textWidth = getTextWidth(brush, text);
        specificAlignment = (400 / 4) * 3 - (textWidth / 4);
        this.drawString(brush, text, specificAlignment, 150);
        
        textSize = 20;
        brush.setFont(new Font(fontStyle, Font.PLAIN, textSize));
        text = "Press Escape to exit to Main Menu";
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        this.drawString(brush, text, centerAlignment, 350);
        
        textSize = 15;
        yLevel = 550;
        text = "Breakout 2";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        specificAlignment = (400 / 4) - (textWidth / 2);
        brush.drawString(text, specificAlignment, yLevel);
        
        textSize = 12;
        text = "Controls:";
        textWidth = getTextWidth(brush, text);
        specificAlignment = ((400 / 4) * 3) - (textWidth / 2);
        brush.drawString(text, specificAlignment, yLevel);
        
        text = "Paddle: Use A and D\nto move left and right.";
        textWidth = getTextWidth(brush, text);
        specificAlignment = (400 / 4) * 3 - (textWidth / 4);
        this.drawString(brush, text, specificAlignment, 600);
        
        text = "1 = Selection \n Selector: Arrow Up and Arrow Down \n Move up and down.";
        textWidth = getTextWidth(brush, text);
        specificAlignment = (400 / 4) * 3 - (textWidth / 4);
        this.drawString(brush, text, 10, 630);

    }
}
