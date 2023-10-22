/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package merge;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int sampleArray[]={8,4,23,42,16,15};
        System.out.println("Array before sort: "+ Arrays.toString(sampleArray));
        mergeSort(sampleArray);
        System.out.println("Array after sort: "+ Arrays.toString(sampleArray));

    }


    public static void mergeSort(int [] arr){
       int n = arr.length;
       if(n <2){
           return;
       }

       int mid = n /2;
       int [] left = new int[mid];
       int [] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i]= arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i-mid]= arr[i];
        }

       mergeSort(left);
       mergeSort(right);
       merge(left,right, arr);

    }

    public static void merge(int [] left,int [] right,int [] arr){
        int i =0, j=0, k=0;
        while (i < left.length && j< right.length) {
            if(left[i]<=right[j]) {
                arr[k]=left[i];
                i++;
            } else {
                arr[k]=right[j];
                j++;
            }

            k++;
        }

        while (i< left.length){
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j< right.length){
            arr[k]=right[j];
            j++;
            k++;
        }

    }
}
