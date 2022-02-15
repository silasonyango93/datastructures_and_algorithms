import doubly_linked_list.DoublyLinkedList;
import linear_search.LinearSearch;
import queue.Queue;
import stack.Stack;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        runLinearSearch();

    }

    public static void runLinearSearch() {
        LinearSearch linearSearch = new LinearSearch();
        linearSearch.search(89);
    }


    public static void runQueue() {
        Queue queue = new Queue();
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }


    public static void runStack() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }


    public static void runDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtBeginningOfList(8);
        doublyLinkedList.insertAtBeginningOfList(6);
        doublyLinkedList.insertAtBeginningOfList(3);
        doublyLinkedList.insertAtBeginningOfList(4);
        doublyLinkedList.insertAtEndOfList(5);
        doublyLinkedList.insertAtEndOfList(0);
        doublyLinkedList.insertAtEndOfList(1);
        doublyLinkedList.findNodeWithParticularValue(5);
    }

    public static int iterateString(String compressionString) {
        char currentMode = compressionString.charAt(0);

        ArrayList<CharModePair> database = new ArrayList<>();

        ArrayList<CharModePair> alreadyIteratedCharacters = new ArrayList<>();


        for (int i = 0; i < compressionString.length(); i++) {

            alreadyIteratedCharacters.add(new CharModePair(compressionString.charAt(i)));
            if (compressionString.charAt(i) == currentMode) {


                if (!isCharAlreadyIteratedThrough(compressionString.charAt(i), alreadyIteratedCharacters)) {
                    database.add(new CharModePair(compressionString.charAt(i)));
                }


            } else {

                if (compressionString.length() > 3 && compressionString.charAt(i + 1) != currentMode || compressionString.charAt(i + 2) != currentMode || compressionString.charAt(i + 3) != currentMode) {
                    currentMode = compressionString.charAt(i);
                    if (!isCharAlreadyIteratedThrough(compressionString.charAt(i), alreadyIteratedCharacters)) {
                        database.add(new CharModePair(compressionString.charAt(i)));
                    }
                }


            }

        }

        System.out.println("The string size is : " + String.valueOf(database.size()));

        return database.size();
    }


    public static boolean isCharAlreadyIteratedThrough(char currentCharacter, ArrayList<CharModePair> alreadyIteratedCharacters) {
        boolean isCharAlreadyIteratedThrough = false;
        for (int j = 0; j < alreadyIteratedCharacters.size(); j++) {
            if (alreadyIteratedCharacters.get(j).getCharacter() == currentCharacter) {
                isCharAlreadyIteratedThrough = true;
            }
        }

        return isCharAlreadyIteratedThrough;
    }

    private static class CharModePair {
        char character;

        public CharModePair(char character) {
            this.character = character;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

    }
}
