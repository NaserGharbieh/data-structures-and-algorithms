# Code Challenge: Class 01
#### Write a function called insertShiftArray which takes in an array and a value to be added. Without utilizing any of the built-in methods available to your language, return an array with the new value added at the middle index. 
## Whiteboard Process


## Approach & Efficiency


### Time Complexity:
The time complexity of the insertShiftArray function is O(n).

### Space Complexity:
The space complexity of the insertShiftArray function is also O(n). 

### Considerations:


## Solution 
``` java 
public class insertShiftArray {

   
        public static int[] insertShiftArr(int[] arr, int value) {
            int length = arr.length;
            int[] newArray = new int[length + 1];
            int middleIndex = length / 2;
    
            for (int i = 0; i < middleIndex; i++) {
                newArray[i] = arr[i];
            }
    
            newArray[middleIndex] = value;
    
            for (int i = middleIndex; i < length; i++) {
                newArray[i + 1] = arr[i];
            }
    
            return newArray;
        }
    
        public static void main(String[] args) {
            int[] originalArray = {1, 2, 4, 5, 6,7,8};
            int newValue = 6;
    
            int[] newArray = insertShiftArr(originalArray, newValue);
    
            System.out.print("Original array: ");
            for (int num : originalArray) {
                System.out.print(num + " ");
            }
    
            System.out.println();
    
            System.out.print("New array with inserted value: ");
            for (int num : newArray) {
                System.out.print(num + " ");
            }
        }
    }
    
```
