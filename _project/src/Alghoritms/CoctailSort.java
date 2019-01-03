package Alghoritms;

import java.util.concurrent.TimeUnit;
import sortingvisualiser.Visualiser;
import sortingvisualiser.toSort;

/**
 *
 * @author DKrakowczyk
 */
public class CoctailSort implements ISortingAlgorithm {

    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {

        boolean swapped = true;
        int start = 0;
        int end = array.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; i++) {
                if (array[i].getValue() > array[i + 1].getValue()) {
                    array[i].setinUse();
                    array[i + 1].setinUse();
                    int tmp = array[i].getValue();
                    array[i].setValue(array[i + 1].getValue());
                    array[i + 1].setValue(tmp);
                    TimeUnit.MILLISECONDS.sleep(1);
                    v.repaint();
                    array[i].notinUse();
                    array[i + 1].notinUse();
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

            end -= 1;

            for (int i = end - 1; i >= start; i--) {
                if (array[i].getValue() > array[i + 1].getValue()) {
                    array[i].setinUse();
                    array[i + 1].setinUse();
                    int tmp = array[i].getValue();
                    array[i].setValue(array[i + 1].getValue());
                    array[i + 1].setValue(tmp);
                    TimeUnit.MILLISECONDS.sleep(1);
                    v.repaint();
                    array[i].notinUse();
                    array[i + 1].notinUse();
                    swapped = true;
                }
            }
            start += 1;
        }

        checkSorted(array, v);
        v.CoctailSort = false;
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
