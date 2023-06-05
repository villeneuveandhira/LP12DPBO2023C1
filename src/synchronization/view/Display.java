/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JFrame;

/**
 *
 * @author
 */
public class Display extends Canvas
{
    // JFrame declaration.
    private JFrame frame;
    
    /**
     * Constructor.
     */
    
    // Default constructor.
    public Display()
    {
        this.frame = new JFrame();
    }
    
    // Constructor with Frame data.
    public Display(int width, int height, String title)
    {
        // Initialize frame and its dimension.
        this.frame = new JFrame(title);        
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setMinimumSize(new Dimension(width, height));
        this.frame.setMaximumSize(new Dimension(width, height));
        
        // Pack the frame to ensure it is laid out properly and the insets are calculated
        this.frame.pack();
    
        // We need to consider the insets since we are resizing the whole JFrame
        Insets insets = frame.getInsets();
        int w = width+insets.left+insets.right;
        int h = height+insets.top+insets.bottom;
        
        // Resize the frame
        this.frame.setPreferredSize(new Dimension(w, h));
        this.frame.setMinimumSize(new Dimension(w, h));
        this.frame.setMaximumSize(new Dimension(w, h));
        
        // Initialize additional options.
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        
        this.frame.setResizable(false);
    }
    
    // Open / show game display. 
    public void open(Game game)
    {
        this.frame.add(game);
        this.frame.setVisible(true);
        
        game.start();
    }
    
    // Close game display.
    public void close()
    {
        this.frame.setVisible(false);
        this.frame.dispose();
    }
}
