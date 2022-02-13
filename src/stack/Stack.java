package stack;

public class Stack {
    int[] stack = new int[10];
    int currentTopIndex = 0;

    public Stack() {
        for (int i = 0; i < stack.length; i++) {
            stack[i] = -1;
        }
    }

    public void push(int data) {
        if (currentTopIndex < 10) {
            stack[currentTopIndex] = data;
            currentTopIndex++;
            System.out.println();
        } else {
            System.out.println("The stack is full");
        }
    }


    public void pop() {
        if (currentTopIndex == 0 && stack[currentTopIndex] == -1) {
            System.out.println("The stack is empty");
        } else {
            int currentTopItem = stack[currentTopIndex];
            stack[currentTopIndex] = -1;
            System.out.println("The removed item is" + currentTopItem);

            if (currentTopIndex != 0) {
                currentTopIndex--;
            }
        }
    }

    public void peek() {
        System.out.println("The top-most element is -> " + stack[currentTopIndex]);
    }


    public void printStack() {
        for (int i = stack.length -1; i > -1; i--) {
            System.out.println(stack[i]);
            System.out.println("ˆ");
            System.out.println("|");
        }
    }
}
