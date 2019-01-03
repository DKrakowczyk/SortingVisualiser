package sortingvisualiser;

import Alghoritms.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
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
    public boolean running, shuffling, sorted, BubbleSort,CoctailSort, CombSort, QuickSort, InsertionSort, RadixSort, menu;
    private Thread thread;
    private int ticks = 0;
    toSort[] array;
    toSort[] arrayCompare;
    private movementHandler key;
    int BAR_X = 0;
    public Visualiser() {
        setBackground(Color.GRAY);
        array = new toSort[500];
        arrayCompare = new toSort[500];
        key = new movementHandler();
        setFocusable(true);
        addKeyListener(key);
        fillArray();
        start();
        sorted = true;
    }

    public void fillArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new toSort(BAR_X, i);
            arrayCompare[i] = new toSort(BAR_X, i);
            BAR_X += 2;
        }
        sorted = true;
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
            TimeUnit.MILLISECONDS.sleep(3);
            array[i].notinUse();
            array[rand].notinUse();
            repaint();
        }
        shuffling = false;
    }

    private void checkSorted(){
        int [] array1 = new int[500];
        int [] array2 = new int [500];
         for (int i = 0; i < array.length-1; i++) {
          array1[i] = i;
        }
        for(int i =0; i<array.length-1;i++){
            array2[i] = array[i].getValue();
        }
        sorted = Arrays.equals(array1, array2);
        
        
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
        if(menu){
        g.setColor(Color.gray);
        g.draw3DRect(10, 10, 600, 60, true);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.setColor(Color.black);
        if (shuffling) {
            g.setColor(new Color(2781744));
        }
        g.drawString("0 - Shuffle", 15, 30);
        g.setColor(Color.black);
        if (BubbleSort) {
            g.setColor(new Color(2781744));
        }
        g.drawString("1 - Bubble sort", 15, 45);
        g.setColor(Color.black);
        if (CoctailSort) {
            g.setColor(new Color(2781744));
        }
        g.drawString("2 - Coctail sort", 15, 60);
        g.setColor(Color.black);
        
        if (CombSort) {
            g.setColor(new Color(2781744));
        }
        g.drawString("3 - Comb sort", 140, 30);
        g.setColor(Color.black);
        if (QuickSort) {
            g.setColor(new Color(2781744));
        }
        g.drawString("4 - Quick sort", 140, 45);
        g.setColor(Color.black);
        if (InsertionSort) {
            g.setColor(new Color(2781744));
        }
        g.drawString("5 - Insertion sort", 140, 60);
        g.setColor(Color.black);
        if (RadixSort) {
            g.setColor(new Color(2781744));
        }
        g.drawString("6 - Radix sort", 265, 30);
        g.setColor(Color.black);
        }
        else
        {
        g.setColor(Color.gray);
        g.draw3DRect(10, 10, 70, 30, true);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.setColor(Color.black);
        g.drawString("M - Menu", 15, 30);
   
        }
        // Displaying the array
        for (int i = 0; i < array.length; i++)
            array[i].draw(g);
        
        
        
    }

    private void loop() throws InterruptedException {
        ticks++;
        if (ticks > 200000) {
            checkSorted();
            System.out.println(sorted);
            if (shuffling) {
                randomize();
            }
            if (BubbleSort) {
                Factory.getAlgorithm(1).sort(array, this);
            }
            if(CoctailSort){
                Factory.getAlgorithm(2).sort(array, this);
            }
            if(CombSort){
                Factory.getAlgorithm(3).sort(array, this);
            }
            if (QuickSort){
                Factory.getAlgorithm(4).sort(array, this);
            }
            if(InsertionSort){
                Factory.getAlgorithm(5).sort(array, this);
            }
            if(RadixSort){
                Factory.getAlgorithm(6).sort(array, this);
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
                    BubbleSort = false;
                    CoctailSort = false;
                    CombSort = false;
                    QuickSort = false;
                    InsertionSort = false;
                    RadixSort = false;
                    break;
                case KeyEvent.VK_1:
                    shuffling = false;
                    BubbleSort = true;
                    CoctailSort = false;
                    CombSort = false;
                    QuickSort = false;
                    InsertionSort = false;
                    RadixSort = false;
                    break;
                case KeyEvent.VK_2:
                    shuffling = false;
                    BubbleSort = false;
                    CoctailSort = true;
                    CombSort = false;
                    QuickSort = false;
                    InsertionSort = false;
                    RadixSort = false;
                    break;
                case KeyEvent.VK_3:
                    shuffling = false;
                    BubbleSort = false;
                    CoctailSort = false;
                    CombSort = true;
                    QuickSort = false;
                    InsertionSort = false;
                    RadixSort = false;
                    break;
                case KeyEvent.VK_4:
                    shuffling = false;
                    BubbleSort = false;
                    CoctailSort = false;
                    CombSort = false;
                    QuickSort = true;
                    InsertionSort = false;
                    RadixSort = false;
                    break;
                case KeyEvent.VK_5:
                    shuffling = false;
                    BubbleSort = false;
                    CoctailSort = false;
                    CombSort = false;
                    QuickSort = false;
                    InsertionSort = true;
                    RadixSort = false;
                    break;
                case KeyEvent.VK_6:
                    shuffling = false;
                    BubbleSort = false;
                    CoctailSort = false;
                    CombSort = false;
                    QuickSort = false;
                    InsertionSort = false;
                    RadixSort = true;
                    break;
                case KeyEvent.VK_S:
                    BubbleSort = false;
                    CoctailSort = false;
                    CombSort = false;
                    QuickSort = false;
                    InsertionSort = false;
                    RadixSort = false;
                    break;
                case KeyEvent.VK_M:
                    menu = !menu;
                    repaint();
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
