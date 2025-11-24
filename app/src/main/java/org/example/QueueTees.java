package org.example;

public class QueueTees {

    private Cutie[] data;  
    private int front;      
    private int rear;     
    private int size;     

    private static final int DEFAULT_CAPACITY = 10;

    public QueueTees() {
        this(DEFAULT_CAPACITY);
    }

    public QueueTees(int capacity) {
        data = new Cutie[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(Cutie cutie) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue new Cutie.");
            return;
        }
        data[rear] = cutie;
        rear = (rear + 1) % data.length;
        size++;
    }

    public Cutie dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Nothing to dequeue.");
            return null;
        }
        Cutie result = data[front];
        data[front] = null; 
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
