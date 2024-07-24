package DSA;

public class SortCharactersByFrequency {
    
    /*
     * Example 1:

        Input: s = "tree"
        Output: "eert"
        Explanation: 'e' appears twice while 'r' and 't' both appear once.
        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


        Example 2:

        Input: s = "cccaaa"
        Output: "aaaccc"
        Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
        Note that "cacaca" is incorrect, as the same characters must be together.


        Example 3:

        Input: s = "Aabb"
        Output: "bbAa"
        Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
        Note that 'A' and 'a' are treated as two different characters.
     */
}








// the idea is to store the characters with its frequency in map and then create the  array of the list of characters of size gerater than 1 of the string(so that is can store the optimum frequency of the characters into that array) ,then iterate into the keyset of the map using streams and then add the characters into the Array of the list at the index of the frequency of the character from the map, then add the characters into the stringbuilder in reverse order so that we dont have to sort the string by the frequency of the characters 

// class Solution {                                   //Most optimized solution
//     public String frequencySort(String s) {
//         StringBuilder sb = new StringBuilder();
//         List<Character>[] arr = new ArrayList[s.length()+1];
//         Map<Character,Integer> map = new HashMap<>();
//         for(char e : s.toCharArray()){
//             map.put(e,map.getOrDefault(e,0)+1);
//         }
        
//         map.keySet().forEach(
//             c -> {
//                if(arr[map.get(c)]==null){
//                 arr[map.get(c)]= new ArrayList();
//                } 
//                arr[map.get(c)].add(c);
//             }
//         );

//         for(int i= arr.length-1; i>0; i--){
//             if(arr[i]!=null){
//                 for(char j : arr[i]){
//                     for(int k=0; k<i ;k++){
//                         sb.append(j);

//                     }

//                 }
//             }
//         }

//         return sb.toString();
//     }
// }