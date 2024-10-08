package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * Tutorial : https://www.youtube.com/watch?v=DhFh8Kw7ymk
     * 
     * 
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

        Notice that the solution set must not contain duplicate triplets.

        

        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation: 
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.
        Example 2:

        Input: nums = [0,1,1]
        Output: []
        Explanation: The only possible triplet does not sum up to 0.
        Example 3:

        Input: nums = [0,0,0]
        Output: [[0,0,0]]
        Explanation: The only possible triplet sums up to 0.
     * 
     */
}






// brute force  -- traverse to every possible element, and check the condition, then sort them, then add into set, return the arraylist of the set



// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int n = nums.length;
//         Set<List<Integer>> set = new HashSet<>();
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     if (nums[i] + nums[j] + nums[k] == 0) {
//                         List<Integer> lis = new ArrayList<>();
//                         lis.add(nums[i]);
//                         lis.add(nums[j]);
//                         lis.add(nums[k]);
//                         // Sort the list to avoid duplicates
//                         Collections.sort(lis);              //  lis.sort(Integer::compareTo);
//                         set.add(lis);
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(set);
//     }
// }






// optimized brute force


// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> set = new HashSet<>();

//         for(int i = 0; i < nums.length; i++){
//             Set<Integer> sett = new HashSet<>();
//             for(int j = i + 1; j < nums.length; j++){
//                 int third = -(nums[i] + nums[j]);
//                 if(sett.contains(third)){
//                     // List<Integer> lis = Arrays.asList(nums[i], nums[j], third);
//                     List<Integer> lis = new ArrayList<>(List.of(nums[i], nums[j], third));
//                     Collections.sort(lis);
//                     set.add(lis);
//                 }
//                 sett.add(nums[j]);
//             }
//         }

//         return new ArrayList<>(set);
//     }
// }










// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {

//         Set<List<Integer>> set = new HashSet<>();

//         Arrays.sort(nums);

//         for(int i = 0; i < nums.length-1; i++) {
//             int j = i + 1;
//             int k = nums.length-1;

//             while(j<k) {
//                 int sum = nums[i] + nums[j] + nums[k];
//                 if(sum == 0) {
//                     set.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
//                 }
//                 else if(sum<0) {
//                     j++;
//                 }
//                 else {
//                     k--;
//                 }
//             }
//         }

//         return new ArrayList<>(set);
        
//     }
// }








// most optimized


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
       List<List<Integer>> list = new ArrayList<>();

      for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;         // Skip same element to avoid duplicate triplets
            int j=i+1; 
            int k= n-1;
            while(j<k){
                int sum =nums[i] + nums[j] + nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    list.add(new ArrayList<Integer>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j<k &&  nums[j]==nums[j-1]) j++;              // Skip same element to avoid duplicate triplets
                    while(k>j &&  nums[k]==nums[k+1]) k--;
                }
            }
      }
        return list;

    }
}
