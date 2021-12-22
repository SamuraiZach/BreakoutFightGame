package Demos;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Sprite extends Rectangle
{
    int x, y;
    public Sprite()
    {
        super(0,0,0,0);
    }
    public void Spawn(Ball b){
        reshape(b.get, b.getY(), 5.0,5.0);
    }
}
