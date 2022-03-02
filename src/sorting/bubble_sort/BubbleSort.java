package sorting.bubble_sort;

public class BubbleSort {

    public void sort(int[] items) {

        boolean isSorted = true;

        for (int i = 0; i < items.length - i; i++) {
            for (int j = 1; j < items.length; j++) {
                if (items[j] < items[j - 1]) {
                    int temp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }

        printList(items);

    }


    public void printList(int[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " -> ");
        }
    }
}
