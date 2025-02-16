import java.util.*;
public class EatPizzas{
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length;
        int m = n / 4;
        int oddCount = (m + 1) / 2;
        int evenCount = m - oddCount;
        
        long total = 0;
        int left = n - 1;
        int right = 0;
        
        for (int i = 0; i < oddCount; i++) {
            total += pizzas[left];
            left--;
            right += 3;
        }
        for (int i = 0; i < evenCount; i++) {
            int first = pizzas[left];
            left--;
            int second = pizzas[left];
            left--;
            total += second;
            right += 2;
        }
        return total;
    }
}