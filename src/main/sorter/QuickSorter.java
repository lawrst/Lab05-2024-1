package sorter;

public class QuickSorter implements Sorter {
    public int[] sort(int[] values) {
        // quicksort implementation
        quickSort(values, 0, values.length -1);
        return values;
    }
    private void quickSort(int[] values, int low, int high){
        if(low < high){
            int pivot = partition(values, low, high);

            quickSort(values, low, pivot - 1);
            quickSort(values, pivot + 1, high);
        }
    }

    public int partition(int[] values, int low, int high) {
        int pivo = values[low];
        int left = low + 1;
        int right = high;

        while (left <= right){
            while (left <= right && values[left] <= pivo){
                left++;
            }
            while (left <= right && values[right] > pivo){
                right--;
            }
            if (left < right){
                int temp = values[left];
                values[left] = values[right];
                values[right] = temp;
            }
        }
        values[low] = values[right];
        values[right] = pivo;

        return right;
    }
}