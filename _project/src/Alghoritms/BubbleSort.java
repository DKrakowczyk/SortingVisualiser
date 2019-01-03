package Alghoritms;

import Alghoritms.ISortingAlgorithm;
import java.util.concurrent.TimeUnit;
import sortingvisualiser.Visualiser;
import sortingvisualiser.toSort;

/**
 *
 * @author DKrakowczyk
 */
public class BubbleSort implements ISortingAlgorithm {

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
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
        checkSorted(array, v);

        v.BubbleSort = false;
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
