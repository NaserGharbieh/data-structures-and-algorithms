package codeChallenge3;

public class BinarySearch {

    public static int binarySearch(int[] sortedArray, int searchKey) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (sortedArray[middle] == searchKey) {
                return middle;
            }

            if (sortedArray[middle] < searchKey) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {};
        int searchKey = 10;

        int index = binarySearch(sortedArray, searchKey);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
