package Alghoritms;

import java.util.concurrent.TimeUnit;
import sortingvisualiser.Visualiser;
import sortingvisualiser.toSort;

/**
 *
 * @author DKrakowczyk
 */
public interface ISortingAlgorithm {

    public void sort(toSort[] array, Visualiser v) throws InterruptedException;

    public void checkSorted(toSort[] array, Visualiser v) throws InterruptedException;
}
