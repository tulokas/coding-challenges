/** The Problem 
* A - array of bulbs. A[i] its position in row.
* return number of moments where all turned on bulbs are shined
* start from 0 to length-1, switch on bulbs ( A[i] represents a bulb's position)
* A[i] bulb shined if: 1) A[i] is switched 2) 1..A[i]-1 all are shined
* examples:
* input: {1,2,3,4,5} output: 5
* input: {1} output: 1
* input: {2,3,4,1,5} output: 2
* input: {2,1,3,5,4} output: 3
**/

import static java.lang.Math.max;
public class ShiningBulbs {
    public static void main(String[] args) {
        int s = solution(new int[]{2, 3, 4, 1, 5});
        System.out.println("solution: " + s);
    }

    // shining bulbs problem
    public static int solution(int[] A) {
        int result = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total = max(A[i], total);
            if (total == i + 1) {
                result++;
            }
        }
    return result;
    }
}
