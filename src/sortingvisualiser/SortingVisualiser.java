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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Sorting Visualiser");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              
        window.setContentPane(new Visualiser());
  
        window.setVisible(true);
    }
    
}
