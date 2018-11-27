/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualiser;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import javax.swing.JPanel;
import java.time.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dawid
 */
public class toSort {
    int x, height;
    boolean inUse,sorted;
    SortingVisualiser sv = new SortingVisualiser();
    int W_HEIGHT = sv.getHeight()-40;
    public toSort(int x, int height){
        this.x = x;
        this.height = height;
        inUse = false;
    }
    public void draw(Graphics g){
         g.setColor(new Color(50, 50, 50));
        if(inUse)
        g.setColor(Color.red);
        
        if(sorted)
        g.setColor(Color.green);
        g.fillRect(x,W_HEIGHT-height, 2, height);
    }
    public void setSorted(){
        sorted = true;
    }
    public void notSorted(){
        sorted = false;
    }
    public void setinUse(){
        inUse=true;
    }
    public void notinUse(){
        inUse= false;
    }
    public int getValue(){
        return this.height;
    }
    public void setValue(int value){
        this.height = value;
    }
 
}
