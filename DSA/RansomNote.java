package DSA;
public class RansomNote {
    /**
     * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

        Each letter in magazine can only be used once in ransomNote.

        

        Example 1:

        Input: ransomNote = "a", magazine = "b"
        Output: false

        Example 2:

        Input: ransomNote = "aa", magazine = "ab"
        Output: false

        Example 3:

        Input: ransomNote = "aa", magazine = "aab"
        Output: true

     */
}





// class Solution {         // hashmap approach
//     public boolean canConstruct(String ransomNote, String magazine) {
//         var map = new HashMap<Character,Integer>();
//         for(char ch : magazine.toCharArray()){
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }
//         for(char ch : ransomNote.toCharArray()){
//             if(map.containsKey(ch)){
//                 map.put(ch,map.get(ch)-1);
//                 if(map.get(ch)==0){
//                     map.remove(ch);
//                 }
//             } else return false;
//         }
//         return true;
//     }
// }




//optimized  :   by using fixed size array for storing characters of magazine

class Solution {
    public boolean canConstruct(String r, String m) {
        int letters[] = new int[26];

        
        char arr1[] = m.toCharArray();
        char arr2[] = r.toCharArray();
        for(char ch: arr1){
            letters[ch -'a']++;
        }

        for(char ch: arr2){

            letters[ch -'a']--;
            if(letters[ch-'a']<0) return false;
        }
        return true;
    }
}

