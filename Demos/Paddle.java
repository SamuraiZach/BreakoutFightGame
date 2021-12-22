package Demos;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Paddle extends Rectangle
{
    int Start_X, Start_Y, PADDING = 10, WindowWidth = 400, WindowHeight = 800;
    public int dx, dy;
    public Paddle(int x, int y, int height, int width, int dx, int dy)
    {
        super(x, y, height, width);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.dx = dx;
        this.dy = dy;
        Start_X = x;
        Start_Y = y;
    }
    public void padReset(){
        this.setLocation(Start_X, Start_Y);
        this.dx = 0;
    }
    public void move() {
        this.translate(dx,dy);
        if (this.getMinX() < 0) {
            this.setLocation(0, y);
        } else if (this.getMaxX() > 400) {
            this.setLocation(WindowWidth - this.width, y);
        }
    }
    public void BallpaddleCollision(Ball b){
        if((b.getX() + b.width >= getX())&&(b.getX() <= getX() + width)&&(b.getY()+b.height == getY())){
            b.dy *= -1;
        }
    }
    public void update() {
        move();
    }
    public void draw(Graphics2D win) {
        Color padClr = Color.white;
        win.setColor(padClr);
        win.fill(this);
        
    }
}