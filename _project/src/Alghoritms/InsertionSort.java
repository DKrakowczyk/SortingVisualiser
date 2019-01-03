package Alghoritms;

import java.util.concurrent.TimeUnit;
import sortingvisualiser.Visualiser;
import sortingvisualiser.toSort;

/**
 *
 * @author DKrakowczyk
 */
public class InsertionSort implements ISortingAlgorithm {

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int tmp = array[i].getValue();
            int k = i - 1;

            while (k >= 0 && array[k].getValue() > tmp) {
                array[k + 1].setinUse();
                array[k + 1].setValue(array[k].getValue());
                TimeUnit.MILLISECONDS.sleep(1);
                v.repaint();
                array[k + 1].notinUse();
                k = k - 1;
            }
            array[k + 1].setValue(tmp);
        }
        checkSorted(array, v);
        v.InsertionSort = false;
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
