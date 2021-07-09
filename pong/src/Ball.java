
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe Trebino
 */
public class Ball {
    public double x,y;
    public int height,widht;
    
    public double dx,dy;
    public double speed=1.7;

    
    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.height=4;
        this.widht=4;
        
        int angle = new Random().nextInt(120-45) + 45 + 1;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
        
    }
    
    public void tick(){
        
        if(x+(dx*speed)+widht >=Game.WIDTH){
            dx*=-1;
            
        }
        if(x+(dx*speed)+widht < 0){
            dx*=-1;
            
        }
        
        if(y>=Game.HEIGHT){
            Game.pontosPlayer++;
            new Game();
            return ;
        }
        else if(y<0){
            Game.pontosEnemy++;
            new Game();
            return ;
        }
        
        Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),widht,height); 
        Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.widht,Game.player.height);
        Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.widht,Game.enemy.height);
        
        if(bounds.intersects(boundsPlayer)){
            int angle = new Random().nextInt(120-45) + 45 + 1;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if(dy >0){
                dy*=-1;
            }
        }
        if(bounds.intersects(boundsEnemy)){
            int angl = new Random().nextInt(120-45) + 45 + 1;
            dx = Math.cos(Math.toRadians(angl));
            dy = Math.sin(Math.toRadians(angl));
            if(dy <0){
                dy*=-1;
            }
        }
        x+=dx*speed;
        y+=dy*speed;
    
    }
    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect((int)x,(int) y, widht, height);
    }
}
