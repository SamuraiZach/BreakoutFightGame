package Demos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class FightWinScreen
{
    public int leftX = 0, right = 400, y = 400;
    final String fontStyle = "Trebuchet MS";
    public void canvasClean(Graphics2D brush) {
        brush.clearRect(0, 0, 400, 800);
    }
    public int getTextWidth(Graphics2D obj, String text) {
        Font f = obj.getFont();
        FontMetrics fm = obj.getFontMetrics(f);
        int width = fm.stringWidth(text);
        return width;
    }
    public void drawWin(Graphics2D brush) {
        brush.setColor(Color.WHITE);
        int textSize, centerAlignment, textWidth, yLevel;
        String text;
        textSize = 20;
        yLevel = 150;
        text = "You have defeated the JAILER";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        textSize = 20;
        text = "Way to breakout";
        yLevel = 250;
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        text = "Haha get it? BREAKOUT! hahaaha...";
        yLevel = 450;
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        textSize = 15;
        yLevel = 480;
        text = "sorry....";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        textSize = 20;
        text = "Press X to Main Menu";
        yLevel = 600;
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
    }
    public void drawLoss(Graphics2D brush) {
        brush.setColor(Color.WHITE);
        int textSize, centerAlignment, textWidth, yLevel;
        String text;
        textSize = 20;
        yLevel = 350;
        text = "You have FAILED to defeated the JAILER";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        textSize = 20;
        yLevel = 400;
        text = "You have DIED";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        textSize = 20;
        yLevel = 650;
        text = "Press X to Main Menu";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
    }
}
