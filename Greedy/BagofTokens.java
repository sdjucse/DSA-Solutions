package Greedy;

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int score=0;
        int maxScore=0;
        int l=0,r=n-1;
        while(l<=r){
            if(power>=tokens[l]){
                power-=tokens[l];
                score++;
                maxScore=Math.max(maxScore,score);
                l++;
            }
            else if(score>=1){
                score--;
                power+=tokens[r];
                r--;
            }
            else{
                return maxScore;
            }
        }
        return maxScore;
    }
}



/*Spending power to gain a score (playing a token face-up).
Spending a score to regain power (playing a token face-down).
Parameters
tokens (int[]): An array of integers representing token values.
power (int): The initial power available.
Returns
int: The maximum score that can be achieved.
Implementation Steps
Sort Tokens

Arrays.sort(tokens);
The tokens are sorted in ascending order to facilitate efficient usage of power for smaller tokens first and regaining power from larger tokens later.
Initialize Variables

int n = tokens.length;
int score = 0;
int maxScore = 0;
int l = 0, r = n - 1;
n: Length of the tokens array.
score: Tracks the current score.
maxScore: Tracks the maximum score achieved.
l and r: Two pointers, initially at the start and end of the tokens array.
Two-Pointer Approach

Condition: The loop runs while l <= r (as long as there are unplayed tokens).

If Power is Sufficient to Play a Token Face-Up:

java
Copy code
if (power >= tokens[l]) {
    power -= tokens[l];
    score++;
    maxScore = Math.max(maxScore, score);
    l++;
}
Deduct the power required for the token at the leftmost position.
Increase the score.
Update maxScore to ensure it reflects the highest score achieved so far.
Move the left pointer (l) forward.
If Power is Insufficient but There is at Least One Score:

java
Copy code
else if (score >= 1) {
    score--;
    power += tokens[r];
    r--;
}
Deduct one score to regain power equal to the value of the token at the rightmost position.
Move the right pointer (r) backward.
Otherwise, Terminate the Loop:

else {
    return maxScore;
}
If neither power is sufficient to gain a score nor score is sufficient to regain power, return maxScore.
Return Maximum Score

return maxScore;
Return the highest score achieved during the process.
Time Complexity
Sorting: 
𝑂(𝑛 log 𝑛)
O(nlogn), where n is the number of tokens.
Two-Pointer Loop: 
𝑂(𝑛)
Overall: 
O(nlogn).
Space Complexity
𝑂(1)
O(1): No additional data structures are used except for a few integer variables.
Example Usage
java
Copy code
Solution solution = new Solution();
int[] tokens = {100, 200, 300, 400};
int power = 200;
int result = solution.bagOfTokensScore(tokens, power);
System.out.println(result); // Output: 2
This code efficiently calculates the maximum score by utilizing a greedy two-pointer strategy, balancing power and score in an optimal way.*/