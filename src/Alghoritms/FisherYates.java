package Alghoritms;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import sortingvisualiser.*;

/**
 *
 * @author Dawid
 */
public class FisherYates implements ISortingAlgorithm{
 
    @Override
    public void sort(toSort[] array, Visualiser v) throws InterruptedException {
         for (int i = 0; i < array.length - 2; i++) {
            Random r = new Random();
            int rand = r.nextInt(array.length);
            int tmp = array[i].getValue();
            array[i].setinUse();
            array[rand].setinUse();
            array[i].setValue(array[rand].getValue());
            array[rand].setValue(tmp);
            TimeUnit.MILLISECONDS.sleep(5);
            array[i].notinUse();
            array[rand].notinUse();
            v.repaint();
            System.out.println("sortuje");
        }
        v.shuffling = false;
    }

    @Override
    public void checkSorted(toSort[] array, Visualiser v) throws InterruptedException {
        toSort[] array2 = new toSort[500]; int BAR_X = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = new toSort(BAR_X, i);
            BAR_X += 2;
        }
        if(array.equals(array2))
            v.QuickSort = false;
    }
}
