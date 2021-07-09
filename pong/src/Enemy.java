
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe Trebino
 */
public class Enemy {
    
    public double x,y;
    public int height,widht;

    
    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.height=5;
        this.widht=40;
    }
    
    public void tick(){
        x+= (Game.ball.x - x - 6)*0.15; 
        
        if(x+widht>Game.WIDTH){
            x = Game.WIDTH - widht;
        }
        else if(x<0){
            x=0;
        }
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x,(int) y, widht, height);
    }
}
