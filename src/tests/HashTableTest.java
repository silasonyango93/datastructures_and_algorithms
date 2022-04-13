package tests;

import hashtable.HashTable;
import org.junit.Test;

public class HashTableTest {

    @Test
    public void is_prime_test() {
        HashTable hashTable = new HashTable(90);
        assert hashTable.isPrimeNumber(19);
    }

    @Test
    public void insert_test() {
        HashTable hashTable = new HashTable(90);
        hashTable.insert("Silas");
        hashTable.insert("Scarlet");
        hashTable.insert("Zain");
        hashTable.insert("Sheshe");
        hashTable.insert("Kalunde");
        hashTable.insert("Mary");
        hashTable.insert("Trezer");
        hashTable.insert("Mum");
        hashTable.insert("Dad");

        assert hashTable.find("Dad") != -1;
        hashTable.delete("Dad");
        assert hashTable.find("Dad") != -1;
    }
}
