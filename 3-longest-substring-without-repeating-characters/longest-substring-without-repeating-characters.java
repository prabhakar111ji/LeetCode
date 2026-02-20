// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int[] lastSeen = new int[128]; // ASCII
//         Arrays.fill(lastSeen, -1);
        
//         int left = 0, maxLen = 0;
        
//         for (int right = 0; right < s.length(); right++) {
//             char c = s.charAt(right);
            
//             if (lastSeen[c] >= left) {
//                 left = lastSeen[c] + 1; // move left past duplicate
//             }
            
//             lastSeen[c] = right;
//             maxLen = Math.max(maxLen, right - left + 1);
//         }
        
//         return maxLen;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        HashSet<Character> set = new HashSet<>();
        int left = 0,right = 0,ans = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}

















