/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alghoritms;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import sortingvisualiser.Visualiser;
import sortingvisualiser.toSort;

/**
 *
 * @author Dawid
 */
public class PigeonHole implements ISortingAlgorithm{

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        int min = array[0].getValue();
        int max = array[0].getValue();
        for(int i = 1; i< array.length;i++){
            if(array[i].getValue() > max)
                max = array[i].getValue();
            if(array[i].getValue() < min)
                min = array[i].getValue();
        }
        
        int r = max-min+1;
        int[] hole = new int[r];
        Arrays.fill(hole,0);
        
        for(int j=0;j<array.length;j++){
            array[j].setinUse();
            hole[array[j].getValue()-min]++;
            TimeUnit.MILLISECONDS.sleep(10);
                array[j].notinUse();
                v.repaint();
        }
        int index = 0;
        
        for(int k=0;k<r;k++){
            while(hole[k]-->0){
                ++index;
                if(index<500){
                array[index].setinUse();
                array[index].setValue(k+min);
                TimeUnit.MILLISECONDS.sleep(10);
                array[index].notinUse();
                v.repaint();
                }
            }
        }
        checkSorted(array,v);
        v.PigeonHole = false;
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
