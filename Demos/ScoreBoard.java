package Demos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
public class ScoreBoard
{
    public int leftX = 0, right = 400, y = 780, points = 0;
    final String fontStyle = "Trebuchet MS";
    public ScoreBoard(Ball b){
        points = b.points;
    }
    public void drawString(Graphics2D g, int pointers, int x, int y){
        g.drawString(String.valueOf(pointers), x, y);
    }
        public int getTextWidth(Graphics2D obj, int pointers) {
        Font f = obj.getFont();
        FontMetrics fm = obj.getFontMetrics(f);
        int width = fm.stringWidth(String.valueOf(pointers));
        return width;
    }
    public void drawScores(Graphics2D brush){
        brush.setColor(Color.WHITE);
        int textSize, centerAlignment, textWidth, yLevel, text;
        textSize = 40;
        yLevel = y;
        text = points;
        String placeholder = String.valueOf(text);
        brush.setFont(new Font(fontStyle, Font.BOLD, textSize));
        textWidth = getTextWidth(brush, text);
        centerAlignment = (400 / 2) - (textWidth / 2) + 125;
        brush.drawString(placeholder, centerAlignment, yLevel);
    }
    public void update(Ball b){
        points = b.points;
        if(b.getY() + b.height >= 800){
            b.points -= 100;
        }
    }
    public boolean wincon(boolean WinCon){
        if(points >= 300){
            return true;
        }
        return false;
    }
}
