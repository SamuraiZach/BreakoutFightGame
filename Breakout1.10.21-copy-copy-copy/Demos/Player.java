package Demos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Player extends Rectangle
{
    public int dx, dy, health;
    public int WindowWidth = 400, WindowHeight = 800;
    public int starthealth = 60;
    public boolean statboost = false, healboost = false;
    public Player(int x, int y, int height, int width, int dx){
        super(x, y, height, width);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.dx = dx;
        health = 60;
    }
    public void update(Fight f){
        move();
        health = f.returnHealthp();
    }
    public void move(){
        this.translate(dx, 0);
        if (this.getMinX() < 10) {
            this.setLocation(0, y);
        } else if (this.getMaxX() > 110) {
            this.setLocation(110 - this.width, y);
        }
    }
    public void draw(Graphics2D win) {
        Color padClr = Color.blue;
        win.setColor(padClr);
        win.fill(this);
    }
    public void reset(){
        statboost = false;
        healboost = false;
    }
}
