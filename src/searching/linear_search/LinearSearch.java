package searching.linear_search;

public class LinearSearch {
    private int [] list = new int[5];

    public LinearSearch() {
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 88;
        }
    }

    public void search(int key) {
        int keyIndex = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                System.out.println("Element found at index " + i);
                keyIndex = i;
            }
        }

        if (keyIndex == -1) {
            System.out.println("Element could not be found");
        }
    }
}
