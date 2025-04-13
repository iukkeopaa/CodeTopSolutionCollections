package QuickSort;

import java.util.Stack;


public class RecursiveQuickSort4 {
    public static void quickSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);


        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();


            int pi = partition(arr, low, high);


            if (pi - 1 > low) {
                stack.push(low);
                stack.push(pi - 1);
            }


            if (pi + 1 < high) {
                stack.push(pi + 1);
                stack.push(high);
            }
        }
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;


        while (true) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, low, right);
        return right;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}    
