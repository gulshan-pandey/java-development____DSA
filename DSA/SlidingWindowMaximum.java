package DSA;

import java.util.ArrayDeque;
import java.util.Stack;


// Use a deque to efficiently keep track of the maximum element within each sliding window by removing elements that are no longer useful or outside the window's range


public class SlidingWindowMaximum {
    /*
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

        Return the max sliding window.


        Example 1:

        Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
        Output: [3,3,5,5,6,7]
        Explanation: 
        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7


        Example 2:

        Input: nums = [1], k = 1
        Output: [1]


     */

}




// //    Company Tags                     : Media.Net (Directi, 2023 repeated), Google, Zenefits, Microsoft, Zoho, Flipkart, Amazon, Directi, SAP Labs
// //     Leetcode Link                   : https://leetcode.com/problems/sliding-window-maximum/



// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length; int index=0;
//         int []ans= new int[n-k+1];
//         ArrayDeque<Integer> q= new ArrayDeque<>();

//         int i =0;
//         int j =0;

//         while(j<n){

//             while(!q.isEmpty() && q.peekLast()<nums[j]){
//                 q.pollLast();
//             }
//             q.add(nums[j]);

//             if(j-i+1<k){
//                 j++;
//             }
//             else if(j-i+1==k){
//                 ans[index++]=q.peek();

//                 if(nums[i]==q.peek()){
//                     q.pollFirst();
//                 }

//             i++;
//             j++;
//             }


//         }
//         return ans;
//     }
// }






class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n =nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        stack.push(n-1);
        arr[n-1]=n;

        for(int i=n-2; i>=0;i--){               //here finding the next maximum numbers array of the nums array
           
                while(stack.size()>0 && nums[stack.peek()]<=nums[i]){
                    stack.pop();
                }
                if(stack.isEmpty()) arr[i] =n;
                else arr[i] = stack.peek();

                stack.push(i);
        } 

        int[] result = new int[n - k + 1];
        int j=0;
        for(int i =0; i<=n -k ; i++){
       // enter the loop to find the maximum number in the window starting at i
            if(j<i){
                j=i;
            }
            while(arr[j]<i+k){
                j=arr[j];
            }

            result[i] = nums[j];
        }


        return result;
    }
}








//Arraylist approach

//  class Solution {
//     public int[] maxSlidingWindow(int[] A, int B) {
//         int n = A.length;
//         int[] result = new int[n - B + 1];
//         ArrayList<Integer> list = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             // Remove indices that are out of the current window
//             if (!list.isEmpty() && list.get(0) < i - B + 1) {
//                 list.remove(0);
//             }

//             // Remove elements that are smaller than the current element
//             // since they are not useful anymore
//             while (!list.isEmpty() && A[list.get(list.size() - 1)] <= A[i]) {
//                 list.remove(list.size() - 1);
//             }

//             // Add the current element's index to the list
//             list.add(i);

//             // The first element in the list is the largest in the current window
//             if (i >= B - 1) {
//                 result[i - B + 1] = A[list.get(0)];
//             }
//         }

//         return result;
//     }
// }