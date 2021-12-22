package Demos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Arrow extends Rectangle
{
    String text;
    int x,y,dy, height, weight;
    final String fontStyle = "Trebuchet MS";
    public Arrow(int x, int y, int height, int width, int dy)
    {
        super(x,y,height,width);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public void update(){
        move();
    }
    public void draw(Graphics2D brush){
        Color padClr = Color.white;
        brush.setColor(padClr);
        brush.fill(this);
    }
    public void move(){
        this.translate(0,dy);
        if (this.getY() < 150) {
            this.setLocation(x, 150);
        } else if (this.getY() > 240) {
            this.setLocation(x, 240);
        }
    }
    public boolean BetweenAttack(){
        if(y >= 150 && y <= 180){
            return true;
        }
        return false;
    }
    public boolean BetweenHeal(){
        if(y >= 180 && y <= 210){
            return true;
        }
        return false;
    }
    public boolean BetweenArmor(){
        if(y >= 210 && y <= 240){
            return true;
        }
        return false;
    }
}
