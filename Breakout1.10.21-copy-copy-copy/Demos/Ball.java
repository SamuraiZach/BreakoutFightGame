package Demos;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
public class Ball extends Rectangle
{
    int Start_X, Start_Y, PADDING = 10, WindowWidth = 400, WindowHeight = 800;
    public int points = 0;
    public int dx, dy;
        public Ball(int x, int y, int height, int width, int dx, int dy)
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
    public void ballReset(Breakout b){
        this.setLocation(Start_X, Start_Y);
        this.dx = 1;
        this.dy = 1;
        points  = 0;
    }
    public int getSpeed() {
        int range = 3, min = 3;
        return (int) (Math.random() * range) + min;
    }
    public int getDir() {
        int rand = (int) (Math.random() * 2);
        if (rand == 1)
            return 1;
        return -1;
    }
    public void setVel(Breakout b){
        dx = getSpeed() * getDir();
        dy = getSpeed() * getDir();
        b.BreakoutGame = true;
    }
    public void ballBounce(Breakout p) {
        if (getY() + height > WindowHeight) {
            dy *= -1;
            points -= 100;
        }else if (this.getY() < 0) {
            dy *= -1;
        }
        boolean checkBounce = (this.getMinY() <= 0) || (this.getMaxY() >= WindowHeight);
        if (checkBounce) {
            dy *= -1;
        }
        if (this.getMaxX() > WindowWidth) {
            dx *= -1;
        }else if (this.getX() < 0) {
            dx *= -1;
        }
    }
    public void update(Breakout p){
        this.translate(dx, dy);
        ballBounce(p);
    }
    public Color ballClr = Color.white;
    public void draw(Graphics2D brush) {
        brush.setColor(ballClr);
        brush.fill(this);
    }
}