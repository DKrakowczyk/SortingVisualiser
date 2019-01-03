/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alghoritms;

import java.util.concurrent.TimeUnit;
import sortingvisualiser.Visualiser;
import sortingvisualiser.toSort;

/**
 *
 * @author Dawid
 */
public class ShellSort implements ISortingAlgorithm {

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        int n = array.length; 
  
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 

            for (int i = gap; i < n; i += 1) 
            { 
     
                int temp = array[i].getValue(); 
  
                int j; 
                for (j = i; j >= gap && array[j - gap].getValue() > temp; j -= gap){
                    array[j].setinUse();
                    array[j].setValue(array[j - gap].getValue()); 
                    TimeUnit.MILLISECONDS.sleep(10);
                    array[j].notinUse();
                    v.repaint();
                }
                
                array[j].setValue(temp);
            } 
        } 
        checkSorted(array,v);
        v.ShellSort = false;    
    }

    @Override
    public void checkSorted(toSort[] array, Visualiser v) throws InterruptedException {
     for (int k = 0; k < array.length - 1; k++) {
            array[k].setSorted();
            TimeUnit.NANOSECONDS.sleep(500);
            array[k].notSorted();
            v.repaint();
        }
    }
    
}
