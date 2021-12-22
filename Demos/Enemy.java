package Demos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Enemy extends Rectangle
{
    public int dx, dy, health;
    public int WindowWidth = 400, WindowHeight = 800;
    public int starthealth = 1000;
    public Enemy(int x, int y, int height, int width, int dy)
    {
        super(x, y, height, width);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.dx = dx;
        this.dy = dy;
        health = 1000;
    }
    public void draw(Graphics2D win) {
        Color padClr = Color.red;
        win.setColor(padClr);
        win.fill(this);
    }
    public void update(Fight f){
        move();
        health = f.returnHealthe();
    }
    public void move(){
        this.translate(0, dy);
        if (this.getY() < 50) {
            dy *= -1;
        } else if (this.getY() + height > 180) {
            dy *= -1;
        }
    }
}
