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
public interface ISortingAlgorithm {
    public void sort(toSort[] array, Visualiser v ) throws InterruptedException;
    public void checkSorted(toSort[] array, Visualiser v) throws InterruptedException;
}
