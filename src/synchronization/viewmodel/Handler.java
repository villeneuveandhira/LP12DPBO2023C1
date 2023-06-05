/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.viewmodel;

import synchronization.model.RandomSquare;
import synchronization.model.GameObject;
import java.awt.Graphics;
import java.util.ArrayList;
//import java.util.Random;

/**
 *
 * @author
 */
public class Handler implements GameInterface
{
    /**
     * Attribute declaration.
     */
    
    private ArrayList<GameObject> object; // Array / List of GameObject.
    private int scoreIncrease;
//    private Random rand;                  // Randomizer.
    
    /**
     * Constructor.
     */
    
    // Default constructor.
    public Handler()
    {
        this.object = new ArrayList<>();
//        this.rand = new Random();
        
        // Create RandomSquare and respawn to random location
        RandomSquare rs = new RandomSquare();
        rs.respawn();
        object.add(rs);
    }
    
    /**
     * Object access and manipulations.
     */
    
    // Add object to list.
    public void add(GameObject object)
    {
        this.object.add(object);
    }
    
    // Access object from list.
    public GameObject get(int i)
    {
        return this.object.get(i);
    }
    
    // Count total object on list.
    public int count()
    {
        return this.object.size();
    }
    
    // Remove object from list based on its index.
    public void remove(int i)
    {
        this.object.remove(i);
    }
    
    // Remove object from list.
    public void remove(GameObject object)
    {
        this.object.remove(object);
    }
    
    public int getScoreIncrease() {
        int temp = scoreIncrease;
        // Reset the score increase in every read
        scoreIncrease = 0;
        return temp;
    }
    
    public void setScoreIncrease(int n) {
        scoreIncrease = n;
    }
    
    // AABB collision detection
    public boolean checkCollision(GameObject a, GameObject b) {
        // Check x axis
        if ((a.getX() < b.getX()+b.getWidth()) && (b.getX() < a.getX()+a.getWidth())) {
            // Check y axis
            if ((a.getY() < b.getY()+b.getHeight()) && (b.getY() < a.getY()+a.getHeight())) {
                // Return true if the object collide
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 
     * Override interface.
     */
    
    @Override
    public void render(Graphics g)
    {
        for(int i = 0; i < object.size(); i++)
        {
            GameObject temp;
            temp = object.get(i);
            
            temp.render(g);
        }
    }
    
    @Override
    public void loop()
    {
        ArrayList<GameObject> tempList = new ArrayList<>();
        for(int i = 0; i < object.size(); i++)
        {
            GameObject temp;
            // Take the object
            temp = object.get(i);
            // Process
            temp.loop();
            // Check for collision
            if (tempList != null) {
                for (GameObject e : tempList) {
                    // If the current square collide
                    if (checkCollision(e, temp) && e.getType().equals("Square")) {
                        System.out.println("Collide");
                        // Respawn the square
                        RandomSquare rs = (RandomSquare) e;
                        rs.respawn();
                        // If the object that hit the square is player
                        if (temp.getType().equals("Player")) {
                            // Add the game score
                            scoreIncrease += 10;
                        }
                    }
                }
            }
            // Add to temporary list
            tempList.add(temp);
        }
        tempList.clear();
    }
}
