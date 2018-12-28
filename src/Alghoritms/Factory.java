/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alghoritms;

/**
 *
 * @author Dawid
 */
public class Factory {

    public static ISortingAlgorithm getAlgorithm(int i) {

        if (i == 0) {
            return new FisherYates();
        } else if (i == 1) {
            return new BubbleSort();
        } else if (i==2){
            return new QuickSort();
        }
        else {
            return null;
        }
    }
}
