package Alghoritms;

/**
 *
 * @author DKrakowczyk
 */
public class Factory {

    public static ISortingAlgorithm getAlgorithm(int i) {

        switch (i) {
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
            case 7:
                return new ShellSort();
            case 8:
                return new PigeonHole();
        }
        return null;

    }
}
