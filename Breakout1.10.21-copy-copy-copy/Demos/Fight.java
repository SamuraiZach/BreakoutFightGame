package Demos;


public class Fight
{
    int ActionMax, ActionCount, DamageCount;
    boolean invincible = false;
    int[] DamageGuess = {1,2,3,4,5,6};
    int playerhealth, enemyhealth;
    boolean statboooost = false;
    int statboost = 7;
    int healboost = 30;
    int count, count2;
    int shootcount = 0;
    public Fight(Player p, Enemy e)
    {
        invincible = false;
        playerhealth = p.health;
        enemyhealth = e.health;
        statboooost = p.statboost;
    }
    public void heal(Player p){
        int difference = 60 - playerhealth;
        if(p.health + getDamage() >= 60){
            if(count2 == 0){
                playerhealth += difference;
            }else{
                playerhealth += healboost;
                count2 = 0;
            }
            if(invincible == true){
                invincible = false;
            }else{
                playerhealth -= 2;
            }
        }else{
            if(count2 == 0){
                playerhealth += getDamage();
            }else{
                playerhealth += healboost;
                count2 = 0;
            }
            if(invincible == true){
                invincible = false;
            }else{
                playerhealth -= 2;
            }
        }
    }
    public void attack(Player p, Enemy e){
        if(e.getY() + (e.height / 2) >= p.getY() && e.getY() + (e.height / 2) <= p.getY() + p.height){
            if(count == 0){
                enemyhealth -= getDamage();
            }else{
                enemyhealth -= (getDamage() + statboost);
            }
            if(invincible == true){
                invincible = false;
            }else{
                playerhealth -= 2;
            }
        }
        else{
            playerhealth -= 2;
        }
    }
    public void armor(){
        invincible = true;
    }
    public int getDamage(){
        if((int)(Math.random() * 3) == 3){
            shootcount += 1;
            return (DamageGuess[(int)(Math.random() * 5)]);
        }else if(shootcount % 5 == 0){
            return 10;
        }
        else{
            shootcount += 1;
            return 3;
        }
    }
    public int returnHealthp(){
        return playerhealth;
    }
    public int returnHealthe(){
        return enemyhealth;
    }
    public void update(Player p, Enemy e, StatBall ball, Healball heal){
        p.health = playerhealth;
        e.health = enemyhealth;
        count = ball.count;
        count2 = heal.count;
    }
    public boolean WinCon(boolean x){
        if(enemyhealth <= 0){
            x = true;
            return x;
        }
        return x;
    }
    public boolean LoseCon(boolean x){
        if(playerhealth <= 0){
            x = true;
            return x;
        }
        return x;
    }
    public void resethealth(Player p, Enemy e){
        playerhealth = p.starthealth;
        enemyhealth = e.starthealth;
        count = 0;
        count2 = 0;
    }
    
}
