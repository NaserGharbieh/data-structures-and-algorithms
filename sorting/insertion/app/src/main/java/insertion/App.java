/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package insertion;

public class App {


    public static void main(String[] args) {
        int [] arr ={2,3,5,7,13,11};
        insertionSort(arr);

        for (int n: arr) {
            System.out.print(n +" ");
        }


    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp =arr[i];
            int j = i-1;
            while (j>=0 &&  arr[j] >temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }


    }
}
