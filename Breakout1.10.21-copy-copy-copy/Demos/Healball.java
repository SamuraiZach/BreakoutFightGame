package Demos;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Healball extends Rectangle
{
    // instance variables - replace the example below with your own
    int dy;
    int count;
    int startx, starty;
    boolean isVisible = true;
    public Healball(int x, int y, int height, int width, int dy)
    {
        super(x, y, height, width);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.dy = dy;
        count = 0;
        this.startx = x;
        this.starty = y;
    }
    public void update(Player p){
        translate(0, dy);
        ballPlayerbounce2(p);
    }
    public void ballPlayerbounce2(Player p) {
        if(getX() + width >= p.getX() && getX() + width <= p.getX() + p.width && (getY() + height == p.getY() || getY() == p.getY() + p.height)){
            p.statboost = true;
            this.count += 1;
            reshape(0,0,0,0);
        }else if(getY() <= p.getY() && getY() >= p.getY() + p.height && p.getX() == getX() + width){
            p.statboost = true;
            this.count += 1;
            reshape(0,0,0,0);
        }
        if(getY() < 0){
            dy *= -1;
        }else if(getY() + height > 800){
            dy *= -1;
        }
    }
    public Color ballClr = Color.green;
    public void draw(Graphics2D brush) {
        brush.setColor(ballClr);
        brush.fill(this);
    }
    public void reset(Player p){
        count = 0;
        p.healboost = false;
        reshape(this.startx,this.starty, height, width);
        isVisible = true;
        reshape(10,250,10,10);
    }
    public boolean retYes(){
        if (count == 1){
            return true;
        }else{
            return false;
        }
    }
}
