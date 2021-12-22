package Demos;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Color;
import Utilities.GDV5;
import Utilities.SoundDriverHo;
public class Breakout extends GDV5
{
    boolean isTitleScreen = true, BreakoutGame = false, isHelpScreen = false, isWinScreen, BreakoutGame2 = false;
    public int WindowWidth = 400, WindowHeight = 800;
    public int STARTBALLX = 200, STARTBALLY = 350, BALLHEIGHT = 25, BALLWIDTH = 25;
    public int STARTPADX = 200, STARTPADY = 700, PADDHEIGHT = 10, PADDWIDTH = 100;
    Ball ball = new Ball(STARTBALLX, STARTBALLY, BALLHEIGHT, BALLWIDTH, 1, 1);
    Paddle paddle = new Paddle(STARTPADX, STARTPADY, PADDHEIGHT,PADDWIDTH, 0,0);
    TitleScreen title = new TitleScreen();
    ScoreBoard scoreboard = new ScoreBoard(ball);
    int j = 0;
    public static int WidthBricks = 40, HeightBricks = 10;
    WinScreen winscreen  = new WinScreen();
    Arrow arrow = new Arrow(50,400,10,5,0);
    Player player = new Player(55, 100, 25, 25, 0);
    Enemy enemy = new Enemy(350, 100, 25, 25, 1);
    StatBall statball = new StatBall(10, 250, 10,10, -1);
    Healball healball = new Healball(25, 350, 10,10,1);
    Actionbox actionbox = new Actionbox(player, enemy, statball, healball);
    Fight fight = new Fight(player, enemy);
    int[] DamageGuess = {1,2,3,4,5,6};
    static Brick bricks[];
    static Brick2 bricks2[];
    FightWinScreen fightscreen = new FightWinScreen();
    boolean fightwin = false;
    boolean fightloss = false;
    SoundDriverHo s1;
    String[] filenames = new String[7];
    int BRICK_Y_OFFSET= 70, BRICK_HEIGHT= 8, BRICK_SEP_V= 4, BRICK_SEP_H= 5, BRICKS_IN_ROW= 10, BRICK_ROWS= 3, BRICK_WIDTH= WindowWidth / BRICKS_IN_ROW - BRICK_SEP_H;
    int BRICK_NUMBER_LEFT= BRICKS_IN_ROW * BRICK_ROWS;
    public Breakout(){
        filenames[0] = "spell_hu_blunderbuss_weaponfire_01.wav";
        filenames[1] = "MUS_52_Zandalari_1_A_01wave.wav";
        filenames[2] = "mixkit-arcade-game-complete-or-approved-mission-205.wav";
        filenames[3] = "igQuestFailedwave.wav";
        filenames[4] = "FX_Holy_Magic_Cast_Small_04wav.wav";
        filenames[5] = "DivineShieldwave";
        filenames[6] = "PVPVictoryHordeMonowav.wav";
        s1 = new SoundDriverHo(filenames, this);
    }
    public void escapeToMenu(Graphics2D brush) {
        if (KeysPressed[KeyEvent.VK_ESCAPE]){ 
            isTitleScreen = true;
            isHelpScreen = false;
            isWinScreen = false;
            BreakoutGame = false;
            BreakoutGame2 = false;
            fightloss = false;
            fightwin = false;
            ball.ballReset(this);
            statball.reset(player);
            player.reset();
            fight.resethealth(player, enemy);
            for(int i = 0; i < 31; i++){
                bricks[i].reset();
            }
        }
    }
    public void reset(Graphics2D brush){
        isTitleScreen = true;
        isHelpScreen = false;
        isWinScreen = false;
        BreakoutGame = false;
        BreakoutGame2 = false;
        fightloss = false;
        fightwin = false;
        ball.ballReset(this);
        statball.reset(player);
        player.reset();
        fight.resethealth(player, enemy);
        for(int i = 0; i < 31; i++){
            bricks[i].reset();
        }
    }
    public boolean showHelp() {
        if (isTitleScreen) {
            if (KeysPressed[KeyEvent.VK_H]) {
                return true;
            }
        }
        return false;
    }
    private static void makeBricks(){
        bricks = new Brick[31];
        int x = 5;
        int y = 5;
        
        for(int i = 0; i < 31; i++){
            if(i == 0 || i == 11 || i == 21){
                x = 5;
            }
            if(i >= 0 && i < 11){
                y = 5;
                bricks[i] = new Brick(x,y);
            }else if(i >= 11 && i < 21){
                y = 40;
                bricks[i] = new Brick(x,y);
            }else{
                y = 75;
                bricks[i] = new Brick(x,y);
            }
            
            x += 70;
        }
    }
    private static void makeBricks2(){
        bricks2 = new Brick2[31];
        int x = 5;
        int y = 5;
        
        for(int i = 0; i < 31; i++){
            if(i == 0 || i == 11 || i == 21){
                x = 5;
            }
            if(i >= 0 && i < 11){
                y = 5;
                bricks[i] = new Brick(x,y);
            }else if(i >= 11 && i < 21){
                y = 40;
                bricks[i] = new Brick(x,y);
            }else{
                y = 75;
                bricks[i] = new Brick(x,y);
            }
            
            x += 70;
        }
    }
    public void paddleMove() {
        if (BreakoutGame) {
            if (KeysPressed[KeyEvent.VK_D] || KeysPressed[KeyEvent.VK_RIGHT]) {
                paddle.dx = 10;
            }else if (KeysPressed[KeyEvent.VK_A] || KeysPressed[KeyEvent.VK_LEFT]) {
                paddle.dx = -10;
            } else if (KeysTyped[KeyEvent.VK_D] || KeysTyped[KeyEvent.VK_RIGHT]) {
                paddle.dx = 0;
            } else if (KeysTyped[KeyEvent.VK_A] || KeysTyped[KeyEvent.VK_LEFT]) {
                paddle.dx = 0;
            }
        }
    }
    public void playerMove(){
        if (BreakoutGame2) {
            if (KeysPressed[KeyEvent.VK_D] || KeysPressed[KeyEvent.VK_RIGHT]) {
                player.dx = 10;
            }else if (KeysPressed[KeyEvent.VK_A] || KeysPressed[KeyEvent.VK_LEFT]) {
                player.dx = -10;
            } else if (KeysTyped[KeyEvent.VK_D] || KeysTyped[KeyEvent.VK_RIGHT]) {
                player.dx = 0;
            } else if (KeysTyped[KeyEvent.VK_A] || KeysTyped[KeyEvent.VK_LEFT]) {
                player.dx = 0;
            }
        }
    }
    public void arrowSelect(Arrow a){
         if(a.getY() >= 150 && a.getY() + a.height <= 180){
            if(KeysPressed[KeyEvent.VK_1]){
                fight.attack(player, enemy); 
                s1.play(0);
            }
            else{
                ;
            }
        }else if(a.getY() >= 180 && a.getY() + a.height <= 210){
            if(KeysPressed[KeyEvent.VK_1]){
                fight.heal(player);
            }
        }else if(a.getY() >= 210 && a.getY() + a.height <= 240){
            if(KeysPressed[KeyEvent.VK_1]){
                fight.armor();
            }
        }
    }
    public void arrowMove(){
        if (BreakoutGame2) {
            if (KeysPressed[KeyEvent.VK_S] || KeysPressed[KeyEvent.VK_DOWN]) {
                arrow.dy = 10;
                
            }else if (KeysPressed[KeyEvent.VK_W] || KeysPressed[KeyEvent.VK_UP]) {
                arrow.dy = -10;
                
            } else if (KeysTyped[KeyEvent.VK_S] || KeysTyped[KeyEvent.VK_DOWN]) {
                arrow.dy = 0;
                
            } else if (KeysTyped[KeyEvent.VK_W] || KeysTyped[KeyEvent.VK_UP]) {
                arrow.dy = 0;
                
            }
        }
    }
    public void draw(Graphics2D brush) {
        if (showHelp()) {
            isHelpScreen = true;
        }
        this.escapeToMenu(brush);
        if (isTitleScreen) {
            if (!isHelpScreen && !BreakoutGame) {
                title.drawTitle(brush);
            }else if (isHelpScreen && !BreakoutGame) {
                title.displayControls(brush);
            }
        } else if(BreakoutGame){
            title.canvasClean(brush);
            scoreboard.drawScores(brush);
            paddle.draw(brush);
            ball.draw(brush);
            Brick.drawBricks(brush,bricks);
            if(scoreboard.wincon(isWinScreen)){
                brush.clearRect(0,0,400,800);
                winscreen.drawWinScreen(brush);
                if (KeysPressed[KeyEvent.VK_X]){
                    reset(brush);
                    winscreen.canvasClean(brush);
                    loop(brush);
                }
            }                    
        }else if(BreakoutGame2){
            title.canvasClean(brush);
            player.draw(brush);
            arrow.draw(brush);
            enemy.draw(brush);
            statball.draw(brush);
            healball.draw(brush);
            actionbox.drawHealth(brush);
            actionbox.drawDisplay(brush);
            if(fight.WinCon(fightwin) == true){
                s1.play(6);
                j = 0;
                brush.clearRect(0,0,400,800);
                fightscreen.drawWin(brush);
                if (KeysPressed[KeyEvent.VK_X]){
                    reset(brush);
                    fightscreen.canvasClean(brush);
                    loop(brush);
                }
            }else if(fight.LoseCon(fightloss) == true){
                s1.play(3);
                brush.clearRect(0,0,400,800);
                fightscreen.drawLoss(brush);
                if (KeysPressed[KeyEvent.VK_X]){
                    reset(brush);
                    fightscreen.canvasClean(brush);
                    loop(brush);
                }
            }
        }
    }
    public void update(){
        
        paddle.BallpaddleCollision(ball);
        for(int i = 0; i < 31; i++){
            bricks[i].ballBrickCollision(ball);
            bricks[i].update();
        }
        
        if (isTitleScreen && !isHelpScreen) {
            if (KeysPressed[KeyEvent.VK_1]) {
                isTitleScreen = false;
                BreakoutGame = true;
            }else if (KeysPressed[KeyEvent.VK_2]) {
                isTitleScreen = false;
                BreakoutGame2 = true;
            }
        }
        if(BreakoutGame == true){
            paddleMove();
            
            ball.update(this);
            
            paddle.update();
            scoreboard.update(ball);
            
        }
        else if(BreakoutGame2 = true){
            playerMove();
            player.update(fight);
            playerMove();
            arrow.update();
            arrowMove();
            healball.update(player);
            enemy.update(fight);
            actionbox.update(player, enemy, statball, healball);
            statball.update(player);
            fight.update(player, enemy, statball, healball);
            arrowSelect(arrow);
        }
    }
    public static void main(String[] args) {
        makeBricks();
        Breakout BreakoutGame = new Breakout();
        BreakoutGame.start();
    }
    public void loop(Graphics2D brush){
        if (showHelp()) {
            isHelpScreen = true;
        }
        this.escapeToMenu(brush);
        if (isTitleScreen) {
            if (!isHelpScreen && !BreakoutGame) {
                title.drawTitle(brush);
            }else if (isHelpScreen && !BreakoutGame) {
                title.displayControls(brush);
            }
        } else if(BreakoutGame){
            title.canvasClean(brush);
            scoreboard.drawScores(brush);
            paddle.draw(brush);
            ball.draw(brush);
            Brick.drawBricks(brush,bricks);
            if(scoreboard.wincon(isWinScreen)){
                brush.clearRect(0,0,400,800);
                winscreen.drawWinScreen(brush);
                if (KeysPressed[KeyEvent.VK_X]){
                    reset(brush);
                    winscreen.canvasClean(brush);
                    loop(brush);
                }
            }                    
        }else if(BreakoutGame2){
            title.canvasClean(brush);
            player.draw(brush);
            arrow.draw(brush);
            enemy.draw(brush);
            statball.draw(brush);
            actionbox.drawHealth(brush);
            actionbox.drawDisplay(brush);
            if(fight.WinCon(fightwin) == true){
                brush.clearRect(0,0,400,800);
                fightscreen.drawWin(brush);
                if (KeysPressed[KeyEvent.VK_X]){
                    reset(brush);
                    fightscreen.canvasClean(brush);
                    loop(brush);
                }
            }else if(fight.LoseCon(fightloss) == true){
                brush.clearRect(0,0,400,800);
                fightscreen.drawLoss(brush);
                if (KeysPressed[KeyEvent.VK_X]){
                    reset(brush);
                    fightscreen.canvasClean(brush);
                    loop(brush);
                }
            }
        }
    }
}