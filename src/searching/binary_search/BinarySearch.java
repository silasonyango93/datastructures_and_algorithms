package searching.binary_search;

public class BinarySearch {

    public BinarySearch() {
    }


    public void search(int key, int[] dataSet) {
        int left;
        int right;
        int middle;
        boolean keyHasBeenFound = false;
        left = 0;
        right = dataSet.length - 1;

        while (left <= right) {
            middle = (left + right) / 2;

            if (key > dataSet[middle]) {
                left = middle + 1;
            } else if (key < dataSet[middle]) {
                right = middle - 1;
            } else {
                keyHasBeenFound = true;
                System.out.println("Element has been found at index -> " + middle);
                left = 0;
                right = 0;
            }
        }

        if (!keyHasBeenFound) {
            System.out.println("Key has not been found");
        }
    }
}
