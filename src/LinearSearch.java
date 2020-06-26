public class LinearSearch {
    public static int linearSearch(int data [], int searchKey) {
        for (int i = 0;i < data.length;i++)
            if(data[i] == searchKey)
                return i;


     return -1;
    }
}
