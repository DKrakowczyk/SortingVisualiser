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
public class CombSort implements ISortingAlgorithm{

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        int gap = array.length;
        boolean swapped = true;
        
        while(gap != 1 || swapped){
            gap = findGap(gap);
            swapped = false;
            
            for(int i=0;i<array.length-gap;i++){
                if(array[i].getValue() > array[i+gap].getValue()){
                    int tmp = array[i].getValue();
                    array[i].setinUse();
                    array[i+gap].setinUse();
                    array[i].setValue(array[i+gap].getValue());
                    array[i+gap].setValue(tmp);
                    TimeUnit.MILLISECONDS.sleep(5);
                    v.repaint();
                    array[i].notinUse();
                    array[i+gap].notinUse();
                    swapped = true;
                }
            }
        }
        
        checkSorted(array,v);
        v.CombSort = false;
    }
    private int findGap(int gap){
        gap = (gap*8)/12;
        if(gap<1)
            return 1;
        return gap;
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
