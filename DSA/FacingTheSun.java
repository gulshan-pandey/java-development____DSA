package DSA;

import java.util.Stack;

public class FacingTheSun {
    
    /**
     * Given an array height representing the heights of buildings. You have to count the buildings that will see the sunrise (Assume the sun rises on the side of the array starting point).
        Note: The height of the building should be strictly greater than the height of the buildings left in order to see the sun.


        Examples :

        Input: height = [7, 4, 8, 2, 9]
        Output: 3
        Explanation: As 7 is the first element, it can see the sunrise. 4 can't see the sunrise as 7 is hiding it. 8 can see. 2 can't see the sunrise. 9 also can see
        the sunrise.
        Input: height = [2, 3, 4, 5]
        Output: 4
        Explanation: As 2 is the first element, it can see the sunrise.  3 can see the sunrise as 2 is not hiding it. Same for 4 and 5, they also can see the sunrise.
     */
}





class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int ans =0;
        for(int i=height.length-1;i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=height[i]){
                stack.pop();
            }
            
            stack.push(height[i]);
        }
        
        while(!stack.isEmpty()){
            ans++;
            stack.pop();
        }
        
        return ans;
    }
}





//optimize



// class Solution {
//     // Returns count buildings that can see sunlight
//     public int countBuildings(int[] height) {
//         int ans=0;
//         int max = Integer.MIN_VALUE;
//         for(int i: height){
//             if(i>max){
//                 ans++;
//                 max = i;
//             }
//         }
//         return ans;
//     }
// }