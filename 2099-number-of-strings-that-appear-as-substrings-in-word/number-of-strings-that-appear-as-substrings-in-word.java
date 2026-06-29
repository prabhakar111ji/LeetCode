class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for(String s: patterns){
            int m = s.length(), n = word.length();
            boolean found = false;
            for(int start = 0;start <= n-m && !found;start++){
                int i = 0;
                while(i<m && s.charAt(i) == word.charAt(start+i))i++;
                if(i == m){
                    ans++;
                    found = true;
                }
            }
        }
        return ans;
    }
}  