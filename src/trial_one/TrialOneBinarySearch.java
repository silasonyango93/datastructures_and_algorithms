package trial_one;

public class TrialOneBinarySearch {
    public static void binarySearch(int [] searchArray, int searchKey) {
        int searchAttempts = 0;
        int currentLowIndex = 0;
        int currentHighIndex = searchArray.length - 1;
        int currentMiddleIndex = (currentLowIndex + currentHighIndex + 1) / 2;
        int searchKeyIndex = -1;


        do {

            if(searchArray[currentMiddleIndex] == searchKey) {
                searchKeyIndex = currentMiddleIndex;
            } else if (searchArray[currentMiddleIndex] < searchKey) {
                currentHighIndex = currentMiddleIndex - 1;
                currentMiddleIndex = (currentHighIndex + currentLowIndex + 1) / 2;
            } else if (searchArray[currentMiddleIndex] > searchKey) {
                currentLowIndex = currentMiddleIndex + 1;
                currentMiddleIndex = (currentHighIndex + currentLowIndex + 1) / 2;
            }
            searchAttempts ++;

        } while ((currentLowIndex <= currentHighIndex) && searchKeyIndex == -1);

        System.out.println("The search key index is : "+ searchKeyIndex);
        System.out.println("The number of search attempts is : "+ searchAttempts);
    }


}
