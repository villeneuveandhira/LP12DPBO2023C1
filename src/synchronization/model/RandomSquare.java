/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import synchronization.view.Game;

/**
 *
 * @author
 */
public class RandomSquare extends GameObject {
    /**
     * Constructor.
     */
    
    // Default constructor.
    public RandomSquare()
    {
        super(0, 0, "Square");
        super.setHeight(30);
        super.setWidth(30);
    }
    
    // Constructor with position.
    public RandomSquare(int x, int y)
    {
        super(x, y, "Square");
        super.setHeight(30);
        super.setWidth(30);
    }
    
    // Respawn
    public void respawn() {
        Random rand = new Random();
        setX(rand.nextInt(Game.width-width));
        setY(rand.nextInt(Game.height-height));
        System.out.println("New coordinate: "+x+", "+y);
    }
    
    /**
     * Override interface.
     */
    
    @Override
    public void render(Graphics object)
    {
        // Set player shape.
        object.setColor(Color.GREEN);
        object.fillRect(x, y, width, height);
    }
    
    @Override
    public void loop()
    {
//        // Initialize velocity, so object can move.
//        this.x += this.velX;
//        this.y += this.velY;
//        
        // Initialize object bound, so it won't spawn outside the screen.
        x = Game.clamp(x, 0, (Game.width - width));
        y = Game.clamp(y, 0, (Game.height - height));
    }
}
