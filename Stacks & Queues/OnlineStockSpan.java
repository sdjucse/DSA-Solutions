//Approach:
//1. The brute force method involves iterating backward through all previous prices to determine the span for each day's price. For each price, we calculate how many consecutive 	previous days had prices less than or equal to the current price.

import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    private List<Integer> prices; // Stores the daily prices

    // Constructor
    public StockSpanner() {
        prices = new ArrayList<>();
    }

    // Method to compute the span of today's stock price
    public int next(int price) {
        prices.add(price); // Add today's price to the list
        int span = 1; // Span starts at 1 (for today itself)

        // Traverse backward in the list to calculate the span
        for (int i = prices.size() - 2; i >= 0; i--) {
            if (prices.get(i) <= price) {
                span++; // Increment the span if the previous price is <= today's price
            } else {
                break; // Stop when a higher price is found
            }
        }

        return span; // Return the calculated span
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}
//Maintains a history of all stock prices seen so far.
//next(int price):
//Adds the current day's price to the prices list.
//Initializes the span to 1 for the current day.
//Iterates backward in the prices list, incrementing the span for each consecutive price less than or equal to today's price.
//Stops when a previous price is found that is greater than today's price.
//Complexity:
//Time Complexity: 
//𝑂(𝑛^2) in the worst case, where n is the number of days. This is because each call to next may iterate over all previous prices.
//Space Complexity: 
//𝑂(𝑛) where n is the number of prices stored in the prices list.
//This brute force approach works correctly but is inefficient for large inputs. For better performance, we can optimize using a stack-based approach, achieving 
//𝑂(𝑛) overall for all calls to next.




//2. Optimized(using stack)

class StockSpanner {
    private Stack<int[]>st;
    public StockSpanner() {
            st= new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            span+=st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price,span});
        return span;
    }
	  public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}


/*Explanation:
Stack:

Stores pairs [price, index] where price is the stock price, and index is the day index.
Ensures prices in the stack are always in decreasing order from top to bottom.
Logic:

Pop from Stack: Remove all elements from the stack where the price is less than or equal to the current price. These prices do not contribute to the span.
Calculate Span:
If the stack is empty after popping, the span is the entire range from day 0 to the current day: index + 1.
Otherwise, the span is the difference between the current index and the index of the nearest greater price on the left (top of the stack).
Push Current Price: Add the current price and its index to the stack.
Edge Cases:

If the current price is the largest so far, the stack will be empty after popping, and the span will be the entire range.
Complexity:
Time Complexity: 
O(n)n calls to next.
Each price is pushed and popped from the stack at most once.
Space Complexity: 
O(n), where n is the number of prices stored in the stack.*/