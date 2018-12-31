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
public class MergeSort implements ISortingAlgorithm{

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        mergeSort(array,0,array.length-1,v);
    }

     public void mergeSort(toSort[] array, int start, int koniec, Visualiser v) throws InterruptedException {
       
        int srodek = (start + koniec) / 2;

        if (start < srodek - 1) {
            mergeSort(array, start, srodek,v);
        }
        if (srodek < koniec - 1) {
            mergeSort(array, srodek, koniec,v);
        }
        scal(array,start,srodek,koniec,v);
    }

    public static void scal(toSort [] array, int start, int srodek, int koniec, Visualiser v) throws InterruptedException {
        toSort [] tmp = new toSort[koniec - start];
        int i = start;
        int j = srodek;
        int k = 0;
        while (i < srodek || j < koniec) {
            if (j == koniec || (i < srodek && array[i].getValue() <=array[j].getValue())){
                tmp[k] = array[i];
                i++;
            }
            else if(j<koniec){
                tmp[k] = array[j];
                j++;
            }
            
            k++;
        }
        k=0;
        TimeUnit.MILLISECONDS.sleep(1);
            v.repaint();
        for(int p = start; p<koniec; p++){
            array[p] = tmp[k];k++;
        }
         
    }
    @Override
    public void checkSorted(toSort[] array, Visualiser v) throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
