package queue;

public class Queue {
    private int[] queue = new int[5];
    private int front = -1;
    private int rear = -1;

    public Queue() {
        for (int i = 0; i < queue.length; i++) {
            queue[i] = -1;
        }
    }

    public void enqueue(int data) {
        if (isQueueFull()) {
            System.out.println("The queue is full");
        } else {
            queue[rear + 1] = data;
            if (rear < queue.length - 1) {
                rear++;
            }
        }
    }

    public boolean isQueueFull() {
        return rear == queue.length - 1;
    }

    public boolean isQueueEmpty() {
        return front == -1 && rear == -1;
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("The queue is empty");
        } else {
            System.out.println("The element to be removed is ->" + queue[0]);
            boolean queueWasNotFull = !isQueueFull();

            for (int i = 0; i < queue.length; i++) {
                if (rear != 4) {
                    queue[i] = queue[i + 1];
                    queue[i + 1] = -1;
                } else {
                    queue[queue.length - 1] = -1;
                }
            }
            rear--;
        }
    }

    public void printQueue() {
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i] + " -> ");
        }
    }
}
