package QuickSort;

public class RecursiveQuickSort5 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = medianOfThree(arr, low, mid, high);
        int pivotIndex;
        if (pivot == arr[low]) {
            pivotIndex = low;
        } else if (pivot == arr[mid]) {
            pivotIndex = mid;
        } else {
            pivotIndex = high;
        }
        swap(arr, pivotIndex, low); 
        pivot = arr[low];


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


    private static int medianOfThree(int[] arr, int low, int mid, int high) {
        if ((arr[low] <= arr[mid] && arr[mid] <= arr[high]) || (arr[high] <= arr[mid] && arr[mid] <= arr[low])) {
            return arr[mid];
        } else if ((arr[mid] <= arr[low] && arr[low] <= arr[high]) || (arr[high] <= arr[low] && arr[low] <= arr[mid])) {
            return arr[low];
        } else {
            return arr[high];
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}    
