/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualiser;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Dawid
 */
public class Visualiser extends JPanel implements Runnable {

    SortingVisualiser sv = new SortingVisualiser();
    public boolean running, randomizing, sorting, bubble, bubbleTwo,insertion;
    private Thread thread;
    private int ticks = 0;
    toSort[] array;
    private movementHandler key;
    int BAR_X = 0;
    sortingAlgorithms sA;

    public Visualiser() {
        setBackground(Color.GRAY);
        array = new toSort[500];
        key = new movementHandler();
        bubble = false;bubbleTwo=false;insertion=false;
        randomizing = false;
        setFocusable(true);
        addKeyListener(key);
        sA = new sortingAlgorithms();
        fillArray();
        start();
    }

    public void fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new toSort(BAR_X, i);
            BAR_X += 2;
        }
    }

    public void randomize() throws InterruptedException {
        for (int i = 0; i < array.length - 2; i++) {
            Random r = new Random();
            int rand = r.nextInt(array.length);
            int tmp = array[i].getValue();
            array[i].setinUse();
            array[rand].setinUse();
            array[i].setValue(array[rand].getValue());
            array[rand].setValue(tmp);
            TimeUnit.MILLISECONDS.sleep(5);
            array[i].notinUse();
            array[rand].notinUse();
            repaint();
        }
        randomizing = false;
    }

    public void start() {
        running = true;
        thread = new Thread(this, "Visualiser");
        thread.start();
    }

    @Override
    public void run() {
        while (running) {
            try {
                loop();
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Visualiser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < array.length; i++)
            array[i].draw(g);
        
    }

    private void loop() throws InterruptedException {
        ticks++;
        if (ticks > 200000) {
            if (randomizing) {
                randomize();
            }

            if (bubble) {
                sA.bubbleSort(array, this);
            }
            
            if(bubbleTwo){
                sA.bubbleSortTwo(array, this);
            }
            
            if(insertion){
                sA.insertionSort(array, this);
            }
            ticks = 0;
        }
    }

    private class movementHandler implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_R:
                    randomizing = true;
                    System.out.println(randomizing);
                    break;
                case KeyEvent.VK_B:
                    bubble = true;
                    System.out.println(randomizing);
                    break;
                case KeyEvent.VK_N:
                    bubbleTwo = true;
                    System.out.println(randomizing);
                    break;
                case KeyEvent.VK_L:
                    insertion = true;
                    System.out.println(randomizing);
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

}
