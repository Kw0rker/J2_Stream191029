package lesson2;

import java.util.Arrays;
import java.util.Random;

public class main {
    static int[] arrayToSort =new  int[100000];
    static Random random=new Random();
    public static void main(String[] args) {
        DynamicArray<Integer>array =new DynamicArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(4);
        System.out.println(array);
        array.remove(2);
        System.out.println(array);
        array.remove(new Integer(4));
        System.out.println(array);
        //System.out.println(array.get(20));
        fillRandom(arrayToSort);

        bubbleSortCheck();
        selectionSortCheck();
        insertSortCheck();
        mergeSortCheck();
        ParallelMergeSortCheck();

    }

    private static void ParallelMergeSortCheck() {
        long time =System.nanoTime();
        System.out.println("Parallel MergeSort  Method");
        ArraySort.ParallelMergeSort(arrayToSort);
        System.out.println("time:"+(System.nanoTime()-time)/1e-6);
    }

    private static void mergeSortCheck() {
        long time =System.nanoTime();
        System.out.println("MergeSort Method");
        ArraySort.mergeSort(arrayToSort);
        System.out.println("time:"+(System.nanoTime()-time)/1e-6);
    }

    private static void insertSortCheck() {
        long time =System.nanoTime();
        System.out.println("Insert Method");
        ArraySort.insertSort(arrayToSort);
        System.out.println("time:"+(System.nanoTime()-time)/1e-6);
    }

    private static void selectionSortCheck() {
        long time =System.nanoTime();
        System.out.println("Selection Method");
        ArraySort.selectSort(arrayToSort);
        System.out.println("time:"+(System.nanoTime()-time)/1e-6);
    }

    private static void bubbleSortCheck() {
        long time =System.nanoTime();
        System.out.println("Bubble Method");
        ArraySort.bubbleSort(arrayToSort);
        System.out.println("time:"+(System.nanoTime()-time)/1e-6);
    }
    static int [] fillRandom(int[]arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
