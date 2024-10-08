package DSA;

public class ValidPalindrome {
    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome, or false otherwise.

        

        Example 1:

        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.


        Example 2:

        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.



        Example 3:

        Input: s = " "
        Output: true
        Explanation: s is an empty string "" after removing non-alphanumeric characters.
        Since an empty string reads the same forward and backward, it is a palindrome.
 
     * 
     */
}


/**
 * here remember the digits are also counted as characters

 * the main crux of this question is to check the character is in between  (a-z) and (0-9) by checking as  :

 * (char)c>='a' &&(char)c<='z' or (char)c>='0' &&(char)c<='9'
 * 
 */





//  useing regular expression

// class Solution {
//     public boolean isPalindrome(String s) {
//         if(s.length()<=1) return true;
//         String words =s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();

//         int l =0;
//         int r =words.length()-1;

//         while(r>l){
//          if (  words.charAt(l)!= words.charAt(r)){
//           System.out.println( words.charAt(l) + " " + words.charAt(r));
//           return false;
//          }
//         r--;
//         l++;
//         } 
//         return true;

//     }
// }



//using stringbuilder


// class Solution {
//     public boolean isPalindrome(String s){
//         var sb = new StringBuilder();
//         for(char c : s.toLowerCase().toCharArray()){

//             if((c>='a' && c<='z') || ((char)c>='0' &&(char)c<='9')) sb.append(c);

//         }
//         System.out.println(sb.toString() +""+sb.reverse().toString());
//         return sb.toString().equals(sb.reverse().toString());
//     }
// }





//by using char array and string builder


// class Solution {
//  public boolean isPalindrome(String s) {
//         StringBuilder sb = new StringBuilder();
//         for(char c : s.toLowerCase().toCharArray()){
            
//             if( (c>='a'&&c<='z')  || (c>='0'&&c<='9')  ){
//                 sb.append(c);
//             }
//         }
//         if(sb.toString().length()<=1) return true;
//         int i = 0, j = sb.length()-1;
//         while(i < j){
//             if(sb.charAt(i) != sb.charAt(j)){
//                 System.out.println(sb);
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         System.out.println(sb);

//         return true;
//     }
// }




//using inbuilt method


// class Solution {
//     public boolean isPalindrome(String s) {
//         if(s.length() <= 1) return true;
//         String words = s.toLowerCase();

//         int l = 0;
//         int r = words.length() - 1;

//         while(r > l) {
//             while(l < r && !Character.isLetterOrDigit(words.charAt(l))) {
//             System.out.println(words.charAt(l));
//                 l++;
//             }
//             while(l < r && !Character.isLetterOrDigit(words.charAt(r))) {
//             System.out.println(words.charAt(r));
//                 r--;
//             }
//             if(words.charAt(l) != words.charAt(r)) return false;
//             r--;
//             l++;
//         }
//         return true;
//     }
// }




//straight manual solution and optimal


class Solution {
   public boolean isPalindrome(String s) {
       if(s.length() <= 1) return true;
       s = s.toLowerCase();

       int l = 0;
       int r = s.length() - 1;

       while(r > l) {
           if(!isAlphanumeric(s.charAt(l))) {
               l++;
           } else if(!isAlphanumeric(s.charAt(r))) {
               r--;
           } else if(s.charAt(l) != s.charAt(r)) {
               return false;
           } else {
               l++;
               r--;
           }
       }
       return true;
   }

   public boolean isAlphanumeric(char c) {
       return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
   }
}