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
public class BubbleSortI implements ISortingAlgorithm{

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        boolean nextIter = true;
        do {
            nextIter = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].getValue() > array[i + 1].getValue()) {
                    int tmp = array[i].getValue();
                    array[i].setinUse();
                    array[i+1].setinUse();
                    array[i].setValue(array[i+1].getValue());
                    array[i + 1].setValue(tmp);
                    TimeUnit.MILLISECONDS.sleep(1);
                    v.repaint();
                    array[i].notinUse();
                    array[i+1].notinUse();
                    nextIter = true;
                }
            }
        } while (nextIter);

        checkSorted(array,v);
        v.BubbleSortI = false;
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
