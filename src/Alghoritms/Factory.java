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

        switch(i){
            case 0:
            return new FisherYates();
            case 1:
                return new BubbleSort();
            case 2:
                return new CoctailSort();
            case 3:
                return new CombSort();
            case 4:
                return new QuickSort();
            case 5:
                return new InsertionSort();
            case 6:
                return new RadixSort();
        }
        return null;
//        if (i == 0) {
//            return new FisherYates();
//        } else if (i == 1) {
//            return new BubbleSort();
//        } else if (i==2){
//            return new QuickSort();
//        }
//        else {
//            return null;
//        }
    }
}
