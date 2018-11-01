/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualiser;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Dawid
 */
public class Visualiser extends JPanel{
    
    public Visualiser()
    {
        setBackground(Color.GRAY);
    }
    
    public void paintComponent(Graphics g)
    {   
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g);
        
    }
}
