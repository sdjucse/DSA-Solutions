
import java.util.Scanner;

public class QueueUsingArray {
    int Q[];
    Scanner sc = new Scanner(System.in);
    int capacity = sc.nextInt(); // Size of the queue
    int size = sc.nextInt(); // Size of the queue
    int front, rear;
    public QueueUsingArray() {
        Q = new int[capacity];
        front = -1;
        rear = -1;
        size=0;
    }

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        Q = new int[capacity];
        front = -1;
        rear = -1;
        size=0;
    }
    public void enqueue(int x) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
            rear=0;
        }
        rear = (rear + 1) % capacity;
        Q[rear] = x;
        System.out.println("Inserted " + x);
        size++;
    }

    public int dequeue() {
        if (front==-1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int x = Q[front];
        if(size==1){
            front=-1;
            rear=-1;
        }
        else{
            front = (front + 1) % capacity;
        }
        size--;
        return x;
    }
    public int front() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return Q[front];
    }
    public int rear() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return Q[rear];
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
}
