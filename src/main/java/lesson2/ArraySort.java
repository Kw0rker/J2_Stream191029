package main.java.lesson2;

public class ArraySort<T> {
   public static int[] bubbleSort(int []arr){
        for (int i=arr.length-1;i>0;i--) {
            for (int j=0;j<i;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
    public static int[] selectSort(int []arr){
        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[min])min=arr[j];
            }
            swap(arr,i,min);
        }
        return arr;
    }

    static void swap(int arr[] ,int i,int j){
        int a=arr[i];
        arr[i]=arr[j];
        arr[j]=a;

    }
    public static int[] insertSort(int[]arr){
        for (int i = 1; i < arr.length; i++) {
            int temp=arr[i];
            int j=i;
            while (j>0&&arr[j-1]>temp){
                arr[j]=arr[j-1];
            }
            arr[j]=temp;

        }
        return arr;
    }
   /* public static int[]mergeSort(int []arr){
       int []temp =new int[arr.length];
       mergeSort(temp,arr,0,arr.length-1);
       return arr;
    }*/
   /* public T[] ParallelMergeSort(T[] arr){
        T []temp = (T[]) new Object[arr.length];
        try {
            ParallelMergeSort(temp,arr,0,arr.length-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arr;
    }

    private T[] mergeSort(T []temp, T[] arr, int lo, int hi) {
        if (lo<=hi)return arr;
        int mid = lo + (hi - lo) / 2;
        mergeSort(temp,arr,0,mid);
        mergeSort(temp,arr,mid+1,hi);
        merge(temp,arr,lo,mid,hi);
        return arr;
    }*/
   /* private T[] ParallelMergeSort (T[] temp, T[] arr, int lo, int hi) throws InterruptedException{
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

    private int[] merge(T[] temp, T[] arr, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            temp[k] = arr[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              arr[k] = temp[j++];
            else if (j > hi)               arr[k] = temp[i++];
            else if (temp[j] < temp[i]) arr[k] = temp[j++];
            else                           arr[k] = temp[i++];
        }
        return arr;
    }*/
}
