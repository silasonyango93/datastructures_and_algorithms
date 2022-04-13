package hashtable;

public class HashTable {
    String [] hashArray;
    int arraySize;
    int used = 0;


    public HashTable(int capacity) {
        this.arraySize = returnNextPrime(capacity);
        this.hashArray = new String[arraySize];
    }

    //Return preferred index
    public int hashFunc1(String word) {
        int hashVal = word.hashCode();
        hashVal = hashVal % arraySize;

        if (hashVal < 0) {
            hashVal = hashVal + arraySize;
        }
        return hashVal;
    }


    public boolean isPrimeNumber(int number) {

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= number; i+=2) {
            if (number  % i == 0) {
                return false;
            }
        }

        return true;
    }


    public int returnNextPrime(int number) {
        for (int i = number; true ; i++) {
            if (isPrimeNumber(i)) {
                System.out.println("The next prime number is ->" + i);
                return i;
            }
        }
    }


    public int hashFunc2(int hashVal) {
        return 3 - hashVal % 3;
    }

    public void insert(String word) {
        int hashValue = hashFunc1(word);
        int stepSize = hashFunc2(hashValue);

        while (hashArray[hashValue] != null) {
            hashValue = hashValue + stepSize;
            hashValue = hashValue % arraySize;
        }

        hashArray[hashValue] = word;
        used++;
        System.out.println("Word has been inserted at index ->" + hashValue);
    }


    public int find(String word) {
        int hashValue = word.hashCode();
        hashValue = hashValue % arraySize;
        int stepSize = hashFunc2(hashValue);

        while (hashArray[hashValue] != null && !hashArray[hashValue].equals(word)) {
            hashValue = hashValue + stepSize;
            hashValue = hashValue % arraySize;
        }

        if (hashArray[hashValue] != null && hashArray[hashValue].equals(word)) {
            System.out.println("Word was found at index ->" + hashValue);
            return hashValue;
        }
        System.out.println("Word was not found");
        return -1;
    }


    public int delete(String word) {
        if (find(word) == -1 ) {
            System.out.println("Word to be deleted was not found");
            return -1;
        }
        hashArray[find(word)] = null;
        return find(word);
    }
}
