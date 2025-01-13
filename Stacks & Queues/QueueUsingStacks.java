import java.util.Stack;

class MyQueue {
    /**
     * This class implements a queue using two stacks (`input` and `output`).
     * It supports standard queue operations: push, pop, peek, and empty.
     * The design ensures that all operations have an amortized O(1) time complexity for the most part.
     */

    private Stack<Integer> input; // Stack used for enqueue operations
    private Stack<Integer> output; // Stack used for dequeue operations
    private int peekEl; // Tracks the front element for efficient `peek`

    /**
     * Constructor to initialize the queue.
     * Creates empty stacks for `input` and `output`.
     * Initializes `peekEl` with -1, indicating the queue is initially empty.
     */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
        peekEl = -1;
    }

    /**
     * Pushes an element to the back of the queue.
     *
     * @param x The element to be added to the queue.
     *          If `input` is empty, `peekEl` is updated to this new element to track the front of the queue.
     */
    public void push(int x) {
        if (input.empty()) {
            peekEl = x; // Update `peekEl` to track the front of the queue
        }
        input.push(x); // Push the element to the `input` stack
    }

    /**
     * Removes and returns the element at the front of the queue.
     * Amortized O(1) time complexity due to the transfer of elements between stacks.
     *
     * @return The element at the front of the queue.
     */
    public int pop() {
        if (output.empty()) {
            // If `output` is empty, transfer all elements from `input` to `output`
            while (!input.empty()) {
                output.push(input.pop());
            }
        }

        int val = output.pop(); // Remove and return the top element from `output`
        return val;
    }

    /**
     * Retrieves, but does not remove, the element at the front of the queue.
     * Amortized O(1) time complexity.
     *
     * @return The front element of the queue.
     */
    public int peek() {
        if (output.empty()) {
            // If `output` is empty, return the front element tracked in `peekEl`
            return peekEl;
        }

        return output.peek(); // Otherwise, return the top element of the `output` stack
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return `true` if the queue is empty, otherwise `false`.
     */
    public boolean empty() {
        // The queue is empty if both `input` and `output` stacks are empty
        return input.empty() && output.empty();
    }
}
/*Explanation of the Code:
Two Stacks:

input: Used for enqueue operations.
output: Used for dequeue operations.
Elements are moved from input to output only when output is empty, ensuring amortized O(1) time complexity for operations.
Peek Element:

The peekEl variable tracks the front of the queue. It is updated during the push operation when input is empty.
Queue Operations:

Push:
Push the element to input.
Update peekEl if input is empty.
Pop:
Transfer elements from input to output if output is empty.
Pop the top element from output.
Peek:
If output is empty, return peekEl.
Otherwise, return the top element of output.
Empty:
Check if both input and output are empty.
Key Points:
Amortized Time Complexity:
Push: O(1).
Pop: Amortized O(1) due to the occasional transfer of elements from input to output.
Peek: O(1).
Empty: O(1).
Space Complexity:
O(n), where n is the number of elements in the queue.
Example Execution:
Input:
java
Copy code
MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);
queue.push(3);
System.out.println(queue.peek());  // Output: 1
System.out.println(queue.pop());   // Output: 1
System.out.println(queue.empty()); // Output: false
Execution Steps:
Push 1, 2, 3:
input: [1, 2, 3]
peekEl: 1
Peek:
output is empty, so return peekEl = 1.
Pop:
Transfer input to output: output: [3, 2, 1]
Pop top of output: Return 1.
Empty:
Both stacks are not empty, so return false.
This implementation efficiently simulates a queue using stacks while maintaining optimal performance.*/












