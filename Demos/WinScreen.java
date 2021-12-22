package Demos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
public class WinScreen
{
    public int leftX = 0, right = 400, y = 400;
    final String fontStyle = "Trebuchet MS";
    public void drawString(Graphics2D g, String text, int x, int y) {
        g.drawString(text, x, y);
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
    public void drawWinScreen(Graphics2D brush){
        brush.setColor(Color.WHITE);
        int textSize, centerAlignment, textWidth, yLevel;
        String text;
        textSize = 40;
        yLevel = y - 25;
        text = "Congrats on winning!!";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        textSize = 40;
        yLevel = y+ 20;
        text = "Press X to restart";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
        
        textSize = 40;
        yLevel = y+ 50;
        text = "Or close out :)";
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2);
        brush.drawString(text, centerAlignment, yLevel);
    }
}
