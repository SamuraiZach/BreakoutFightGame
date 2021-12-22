package Demos;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Brick2 extends Rectangle
{
    static Color col = Color.red;
    boolean isVisible;
    public Brick2(int x, int y)
    {
        super(x, y, 50, 25);
        this.x = x;
        this.y = y;
        isVisible = true;
    }
    public static void drawBricks(Graphics2D brush, Brick2 bricks2[]){
        for(Brick2 b: bricks2){
            brush.setColor(col);
            brush.fill(b);
        }
    }
    public void ballBrickCollision(Ball b){
        //bottomside
        if((b.getX() + b.width >= getX())&&(b.getX() <= getX() + 50)&&(b.getY() == getY()+25)){
            isVisible = false;
            b.dy *= -1;
            b.points += 100;
        }
        //topside
        else if((b.getX() + b.width >= getX())&&(b.getX() <= getX() + 50)&&(b.getY() + b.height == getY())){
            isVisible = false;
            b.dy *=-1;
            b.points += 100;
        //rightside
        }else if((getX()+width == b.getX())&&(getY() <= b.getY() + b.height)&&(getY() + height >= b.getY())){
            isVisible = false;
            b.dx *= -1;
            b.points += 100;
        //leftside
        }else if((getX() == b.getX() + b.width)&&(getY() <= b.getY() + b.height)&&(getY()+ height >= b.getY())){
            isVisible = false;
            b.dx *= -1;
            b.points += 100;
        }
    }
    public void update(){
        if(!isVisible){
            reshape(0,0,0,0);
        }else{
            ;
        }
    }
}