/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.model;

import java.awt.Color;
import java.awt.Graphics;
import synchronization.view.Game;

/**
 *
 * @author
 */
public class Player extends GameObject
{
    /**
     * Attribute declaration.
     */
    
    private int prevDir;    //1=up; 2=right; 3=down; 4=left;
    
    /**
     * Constructor.
     */
    
    // Default constructor.
    public Player()
    {
        super(0, 0, "Player");
        super.setHeight(30);
        super.setWidth(30);
        
    }
    
    // Constructor with player position.
    public Player(int x, int y)
    {
        super(x, y, "Player");
        super.setHeight(30);
        super.setWidth(30);
    }
    
    /**
     * Getter and Setter.
     */

    public int getPrevDir() {
        return prevDir;
    }
    
    public void setPrevDir(int prevDir) {
        this.prevDir = prevDir;
    }
    
    /**
     * Override interface.
     */
    
    @Override
    public void render(Graphics object)
    {
        // Set player shape.
        object.setColor(Color.decode("#87CEEB"));
        object.fillOval(x, y, width, height);
    }
    
    @Override
    public void loop()
    {
        // Initialize velocity, so object can move.
        this.x += this.velX;
        this.y += this.velY;
        
        // Initialize player bound, so it won't get offset the display.
        x = Game.clamp(x, 0, (Game.width - width));
        y = Game.clamp(y, 0, (Game.height - height));
//        System.out.println(x+", "+y);
    }
}
