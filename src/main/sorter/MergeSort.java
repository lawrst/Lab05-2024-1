package sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] values) {
        if (values.length <= 1) {
            return values;
        }

        int mid = values.length / 2;
        int[] left = new int[mid];
        int[] right = new int[values.length - mid];

        for (int i = 0; i < mid; i++){
            left[i] = values[i];
        }
        for (int i = mid; i < values.length; i++){
            right[i - mid] = values[i];
        }

        return merge(sort(left), sort(right));

    }

    public int[] merge(int[] left, int[] right) {
        int[] temp = new int [left.length + right.length];
        int inicio = 0;
        int fim = 0;
        int k = 0;

        while(inicio < left.length && fim < right.length){
            if (inicio < left.length && fim < right.length){
                if(left[inicio] <= right[fim]){
                    temp[k++] = left[inicio++];
                } else {
                    temp[k++] = right[fim++];
                }
            }

        }
        while(inicio < left.length){
            temp[k++] = left[inicio++];
        }
        while (fim < right.length) {
            temp[k++] = right[fim++];
        }
        return temp;
        }
    }
