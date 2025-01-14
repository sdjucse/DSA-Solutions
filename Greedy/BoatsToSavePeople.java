import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int l=0,r=n-1;
        int cnt=0;
        while(l<=r){
            if(people[r]+people[l]<=limit){
                l++;
                r--;
            }
            else{
                r--;
            }
            cnt++;
        }
        return cnt;
    }
}



/*Time Complexity
Sorting: 
O(nlogn), where n is the number of people.
Two-Pointer Loop: 
O(n).
Overall: 
O(nlogn).
Space Complexity
O(1): The solution uses constant extra space apart from input variables.
Example Usage


Solution solution = new Solution();
int[] people = {3, 2, 2, 1};
int limit = 3;
int result = solution.numRescueBoats(people, limit);
System.out.println(result); // Output: 3
Explanation of Example
Sorted weights: 
[
1
,
2
,
2
,
3
]
[1,2,2,3].
Pairing strategy:
Pair 
1
1 and 
2
2: Total weight 
=3 (1 boat).
Pair 
2
2: Total weight 
=2 (1 boat).
Pair 
3
3: Total weight 
=3 (1 boat).
Total boats required: 
3
This code efficiently calculates the minimum number of boats by leveraging a greedy two-pointer approach to pair people in an optimal way.
*/










