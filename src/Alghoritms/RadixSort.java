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
public class RadixSort implements ISortingAlgorithm{

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        
        if(!v.sorted){
            int max = getMaximum(array,array.length);
        
        for(int e =1;max/e >0; e*=10)
            counter(array,array.length,e, v);
         }
         else{
             checkSorted(array, v);
             v.RadixSort = false;
         }
        
    }
    
    private int getMaximum(toSort[] array, int n){
        int max = array[0].getValue();
        for(int i = 1; i< n;i++){
            if(array[i].getValue()>max)
                max = array[i].getValue();
        }
        return max;
    }
    
    private void counter(toSort[] array, int n, int e, Visualiser v) throws InterruptedException{
        int[] out = new int[n];
        int i;
        int [] count = new int[10];
        Arrays.fill(count, 0);
        
        for(i=0;i<n;i++){
            count[(array[i].getValue()/e)%10]++;
        }
        
        for(i=1;i<10;i++){
            count[i] += count[i-1];
        }
        
        for(i=n-1;i>=0;i--){
            out[count[(array[i].getValue()/e)%10]-1]= array[i].getValue();
            count[(array[i].getValue()/e)%10]--;
        }
        for(i=0;i<n;i++){
            array[i].setinUse();
            array[i].setValue(out[i]);
            TimeUnit.MILLISECONDS.sleep(10);
            array[i].notinUse();
            v.repaint();
        }
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
