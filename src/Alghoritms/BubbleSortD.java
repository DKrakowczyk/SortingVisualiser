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
public class BubbleSortD implements ISortingAlgorithm{

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        boolean nextIter = true;
        int i = 1;
        int k = 0;
        while (true) {
            nextIter = true;
            for (int j = k; j < array.length - i; j++) {
                if (array[j].getValue() > array[j + 1].getValue()) {
                    int tmp = array[j].getValue();
                    array[j].setinUse();
                    array[j+1].setinUse();
                    array[j].setValue(array[j+1].getValue());
                    array[j + 1].setValue(tmp);
                    TimeUnit.MILLISECONDS.sleep(1);
                    v.repaint();
                    array[j].notinUse();
                    array[j+1].notinUse();
                    nextIter = false;
                }
            }
            if (nextIter) {
                break;
            }
            i++;
            nextIter = true;
            for (int l = array.length - i; l < k; l++) {
                if (array[l].getValue() > array[l + 1].getValue()) {
                    int tmp = array[l].getValue();
                    array[l].setinUse();
                    array[l+1].setinUse();
                    array[l].setValue(array[l+1].getValue());
                    array[l + 1].setValue(tmp);
                    nextIter = false;
                    TimeUnit.MILLISECONDS.sleep(1);
                    v.repaint();
                    array[l].notinUse();
                    array[l+1].notinUse();
                }
                if (nextIter) {
                    break;
                }
                k++;

            }

        }
        
        checkSorted(array,v);
        v.BubbleSortD = false;
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
