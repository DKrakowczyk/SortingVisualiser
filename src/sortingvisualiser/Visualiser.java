package sortingvisualiser;

import Alghoritms.*;
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
    public boolean running, shuffling, sorting, BubbleSort,BubbleSortI, BubbleSortD, QuickSort, InsertionSort, MergeSort;
    private Thread thread;
    private int ticks = 0;
    toSort[] array;
    private movementHandler key;
    int BAR_X = 0;
    public Visualiser() {
        setBackground(Color.GRAY);
        array = new toSort[500];
        key = new movementHandler();
        setFocusable(true);
        addKeyListener(key);
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
        shuffling = false;
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
            if (shuffling) {
                randomize();
            }
            if (BubbleSort) {
                Factory.getAlgorithm(1).sort(array, this);
            }
            if(BubbleSortI){
                
            }
            if(BubbleSortD){
                
            }
            if (QuickSort){
                Factory.getAlgorithm(2).sort(array, this);
                Factory.getAlgorithm(0).checkSorted(array, this);
            }
            if(InsertionSort){
                
            }
            if(MergeSort){
                
            }
            
            ticks = 0;
        }
    }

    private class movementHandler implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_0:
                    shuffling = true;
                    break;
                case KeyEvent.VK_1:
                    BubbleSort = true;
                    break;
                case KeyEvent.VK_2:
                    BubbleSortI = true;
                    break;
                case KeyEvent.VK_3:
                    BubbleSortD = true;
                    break;
                case KeyEvent.VK_4:
                    QuickSort = true;
                    break;
                case KeyEvent.VK_5:
                    InsertionSort = true;
                    break;
                case KeyEvent.VK_6:
                    MergeSort = true;
                    break;
                case KeyEvent.VK_S:
                    BubbleSort = false;
                    BubbleSortI = false;
                    BubbleSortD = false;
                    QuickSort = false;
                    InsertionSort = false;
                    MergeSort = false;
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
