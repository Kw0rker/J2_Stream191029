package main.java.lesson2;

import main.java.lesson3.Point;

public class PointSort {
    public Point[] ParallelMergeSort(Point[] arr){
        Point[] temp =new Point[arr.length];
        try {
            ParallelMergeSort(temp,arr,0,arr.length-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arr;
    }

    private Point[] mergeSort(Point []temp, Point[] arr, int lo, int hi) {
        if (lo<=hi)return arr;
        int mid = lo + (hi - lo) / 2;
        mergeSort(temp,arr,0,mid);
        mergeSort(temp,arr,mid+1,hi);
        merge(temp,arr,lo,mid,hi);
        return arr;
    }
    private Point[] ParallelMergeSort (Point[] temp, Point[] arr, int lo, int hi) throws InterruptedException{
        if (lo<=hi)return arr;
        int mid = lo + (hi - lo) / 2;
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                mergeSort(temp,arr,0,mid);
            }
        });
        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                mergeSort(temp,arr,mid+1,hi);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
       return merge(temp,arr,lo,mid,hi);
    }

    private Point[] merge(Point[] temp, Point[] arr, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            temp[k] = arr[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              arr[k] = temp[j++];
            else if (j > hi)               arr[k] = temp[i++];
            else if (temp[j].compareTo(temp[i])<=-1) arr[k] = temp[j++];
            else                           arr[k] = temp[i++];
        }
        return arr;
    }
}
