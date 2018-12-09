/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualiser;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dawid
 */
public class sortingAlgorithms {

    public void bubbleSort(toSort[] array, Visualiser v) throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {

                if (array[j].getValue() > array[j + 1].getValue()) {
                    int tmp = array[j].getValue();
                    array[j].setinUse();
                    array[j + 1].setinUse();
                    array[j].setValue(array[j + 1].getValue());
                    array[j + 1].setValue(tmp);

                    TimeUnit.MILLISECONDS.sleep(1);
                    array[j].notinUse();
                    array[j + 1].notinUse();
                    v.repaint();
                }

            }
        }
        for (int k = 0; k < array.length - 1; k++) {
            array[k].setSorted();
            TimeUnit.MILLISECONDS.sleep(1);
            array[k].notSorted();
            v.repaint();
        }

        v.bubble = false;
    }

    public void bubbleSortTwo(toSort[] array, Visualiser v) throws InterruptedException {
        boolean nextIter = true;
        int counter = 1;
        do {
            nextIter = false;
            for (int i = 0; i < array.length - counter; i++) {
                if (array[i].getValue() > array[i + 1].getValue()) {
                    int tmp = array[i].getValue();
                    array[i].setinUse();
                    array[i].setValue(array[i + 1].getValue());
                    array[i + 1].setValue(tmp);
                    nextIter = true;

                    TimeUnit.MILLISECONDS.sleep(1);
                    array[i].notinUse();
                    v.repaint();
                }
            }
            counter++;
        } while (nextIter);
        for (int k = 0; k < array.length - 1; k++) {
            array[k].setSorted();
            TimeUnit.MILLISECONDS.sleep(1);
            array[k].notSorted();
            v.repaint();
        }

        v.bubbleTwo = false;
    }

    public void insertionSort(toSort[] array, Visualiser v) throws InterruptedException {
        int n = array.length;
        for (int i = 1; i < n - 1; ++i) {
            int tmp = array[i].getValue();
            int k = i - 1;
            array[i].setinUse();

            while (k > 0 && tmp < array[k].getValue()) {

                array[k + 1].setValue(array[k].getValue());
                k = k - 1;

                array[k + 1].setValue(tmp);
                TimeUnit.MILLISECONDS.sleep(1);

            }
            array[i].notinUse();
            v.repaint();
        }
        v.insertion = false;
    }
}
