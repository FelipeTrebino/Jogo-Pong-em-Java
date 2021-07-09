
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
public class Player {
    
    public boolean right,left;
    
    public int x,y;
    public int widht,height;
    
    public Player(int x,int y){
        this.x=x;
        this.y=y;
        this.height=10;
        this.widht=40;
    }
    
    public void tick(){
        if(right){
            x++;
        }
        else if(left){
            x--;
        }
        
        if(x+widht>Game.WIDTH){
            x = Game.WIDTH - widht;
        }
        else if(x<0){
            x=0;
        }
    }
    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, widht, height);
    }
}
