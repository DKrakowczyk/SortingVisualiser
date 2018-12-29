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
public class QuickSort implements ISortingAlgorithm{

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        
         if(!v.sorted){
         
        quickSort(array,v,0,array.length-1);
         }
         else{
             checkSorted(array, v);
             v.QuickSort = false;
         }
        
    }

    @Override
    public void checkSorted(toSort[] array, Visualiser v) throws InterruptedException {
        for (int k = 0; k < array.length - 1; k++) {
            array[k].setSorted();
            TimeUnit.MILLISECONDS.sleep(1);
            array[k].notSorted();
            v.repaint();
        }
       
    }
    
    public void quickSort(toSort[] array,Visualiser v, int start, int stop) throws InterruptedException{
        
        int i, j, tmp;
        toSort a = array[(start+stop)/2];
        i = start;
        j = stop;
        
        do{
            while(array[i].getValue()<a.getValue()){
                i++;
            }
            while(a.getValue()<array[j].getValue()){
                j--;
            }
            if(i<=j){
                tmp = array[i].getValue();
                array[i].setinUse();
                array[i].setValue(array[j].getValue());
                
                array[i].setinUse();
                array[j].setValue(tmp);
                
                TimeUnit.MILLISECONDS.sleep(10);
                array[i].notinUse();
                array[j].notinUse();
                i++;
                j--;
                v.repaint();
               
            }
        }while(i<=j);
        
        if(start<j)
            quickSort(array,v,start,j);
        if(i<stop)
            quickSort(array,v,i,stop);
      
    }
} 
