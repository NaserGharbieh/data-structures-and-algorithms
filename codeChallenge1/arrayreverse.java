public class arrayreverse {
    public static int[] reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            reversedArray[arr.length - 1 - i] = arr[i];
        }
        
        return reversedArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] reversedArray = reverseArray(originalArray);
        
        System.out.print("Original array: ");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }
        
        System.out.print("\nReversed array: ");
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
    }
}