package Demos;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Actionbox
{
    int ActionMax, ActionCount;
    String Action1, Action2, Action3;
    final String fontStyle = "Trebuchet MS";
    int PlayerHealth, EnemyHealth, count, count2;
    public Actionbox(Player p, Enemy e, StatBall ball, Healball heal)
    {
        PlayerHealth = p.health;
        EnemyHealth = e.health;
        count = ball.count;
        count2 = heal.count;
    }
    public void drawDisplay(Graphics2D brush){
        brush.setColor(Color.red);
        brush.drawRect(60,150, 60, 30);
        brush.drawRect(60,180, 60, 30);
        brush.drawRect(60,210, 60, 30);
        brush.drawString("ATTACK", 70, 165);
        brush.drawString("HEAL", 70, 195);
        brush.drawString("ARMOR", 70, 225);
        brush.drawString("Goal: ESCAPE", 160, 20);
        brush.drawString("Kill the Jailer", 165, 35);
    }
    public void drawHealth(Graphics2D brush){
        String PHEALTH = String.valueOf(PlayerHealth);
        String EHEALTH = String.valueOf(EnemyHealth);
        brush.drawString(PHEALTH, 10, 50);
        brush.drawString(EHEALTH, 370, 50);
        brush.drawString("Boost ATTK: ", 10, 10);
        brush.drawString("Boost HEAL: ", 300, 10);
        if(count == 0){
            brush.drawString("No", 80, 10);
        }else{
            brush.drawString("Yes", 80, 10);
        }
        if(count2 == 0){
            brush.drawString("No", 370, 10);
        }else{
            brush.drawString("Yes", 370, 10);
        }
    }
    public void update(Player p, Enemy e, StatBall ball, Healball heal){
        PlayerHealth = p.health;
        EnemyHealth = e.health;
        count = ball.count;
        count2 = heal.count;
    }
    public void reset(){
        count = 0;
        count2 = 0;
    }
}
