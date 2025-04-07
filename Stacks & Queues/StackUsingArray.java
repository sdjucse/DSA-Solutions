import java.util.*;
class StackUsingArray {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt(); // Size of the stack
    int arr[] = new int[size];
    int top = -1;
    void push(int x) {
        top++;
        arr[top] = x;
    }
    int pop() {
        int x = arr[top];
        top--;
        return x;
    }
    int top() {
        return arr[top];
    }
    int size() {
        return top + 1;
    }
}