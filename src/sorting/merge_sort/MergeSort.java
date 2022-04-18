package sorting.merge_sort;

import org.junit.Test;

public class MergeSort {

    public int [] mergeSort(int [] originalArray) {
        int arraySize = originalArray.length;
        if (originalArray.length == 1) {
            return originalArray;
        }

        int midIndex = arraySize / 2;

        int [] leftArray = new int[midIndex];
        int [] rightArray = new int[arraySize - midIndex];

        System.arraycopy(originalArray, 0, leftArray, 0, midIndex);
        System.arraycopy(originalArray, midIndex, rightArray, 0, arraySize - midIndex);

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        return merge(leftArray,rightArray,originalArray.length);
    }


    public int [] merge(int [] leftArray, int [] rightArray, int originalArrayLength) {

        int i = 0, j = 0, k = 0;
        int [] resultArray = new int[originalArrayLength];
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                resultArray[k] = leftArray[i];
                i++;
            } else {
                resultArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            resultArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            resultArray[k] = rightArray[j];
            j++;
            k++;
        }

        return resultArray;
    }


    @Test
    public void mergeSort_works_properly() {
        int [] array = {13,12,11,10,9,8,7,6,5,4,3,2,1};
        array = mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ->");
        }
    }
}
