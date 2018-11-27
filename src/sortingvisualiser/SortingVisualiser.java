/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualiser;

import javax.swing.JFrame;

/**
 *
 * @author Dawid
 */
public class SortingVisualiser {

    static JFrame window = new JFrame("Sorting Visualiser");;
    
    public static void main(String[] args) {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        window.setBounds(0,0,1020,600);
        window.setContentPane(new Visualiser());
        window.setVisible(true);
    }
    
    int getWidth()
    {
        return window.getBounds().width;
    }
    int getHeight()
    {
        return window.getBounds().height;
    }
    
}
