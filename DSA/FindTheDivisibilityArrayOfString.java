package DSA;

import java.util.Arrays;

public class FindTheDivisibilityArrayOfString {
    /**
     * FindTheDivisibilityArrayOfString
     * 
     * You are given a 0-indexed string word of length n consisting of digits, and a positive integer m.
     * The divisibility array div of word is an integer array of length n such that:
     * div[i] = 1 if the numeric value of word[0,...,i] is divisible by m, or
     * div[i] = 0 otherwise.
     * 
     * Return the divisibility array of word.
     * 
     * 
     * 
     * Example
     * Input: word = "998244353", m = 3
     * Output: [1,1,0,0,0,1,1,0,0]
       Explanation: There are only 4 prefixes that are divisible by 3: "9", "99", "998244", and "9982443".]
     *
     *
     * Example 2
     * 
     * Input: word = "1010", m = 10
       Output: [0,1,0,1]
       Explanation: There are only 2 prefixes that are divisible by 10: "10", and "1010". 

     */



    
}


//both optimal approaches





// class Solution {             //concise way
//     public int[] divisibilityArray(String word, int m) {
//         int[] arr = new int[word.length()];
//         long number = word.charAt(0) - '0'; // Convert first digit to int directly by substracting the ASCII value of 'O' from the character gives the numerical value of the number
//         arr[0] = (number % m == 0) ? 1 : 0;

//         for (int i = 1; i < word.length(); i++) {
//             number = (number * 10 + (word.charAt(i) - '0')) % m; 
//             arr[i] = (number == 0) ? 1 : 0;
//         }
//         return arr;
//     }
// }




//class Solution {
//    public int[] divisibilityArray(String word, int m) {
//        int n = word.length();
//        int[] div = new int[n];
//        long currentNumber = 0;
//
//        for (int i = 0; i < n; i++) {
//            currentNumber = currentNumber * 10 + (word.charAt(i) - '0');    // Convert first digit to int directly by substracting the ASCII value of 'O' from the character gives the numerical value of the number
//            if (currentNumber % m == 0) {
//                div[i] = 1;
//            } else {
//                div[i] = 0;
//            }
//            currentNumber %= m; // To avoid overflow, keep currentNumber as a remainder
//        }
//
//        return div;
//    }
//}
