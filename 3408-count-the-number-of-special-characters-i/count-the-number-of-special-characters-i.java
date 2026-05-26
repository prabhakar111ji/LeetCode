class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] l = new boolean[26];
        boolean[] u = new boolean[26];
        for(char c: word.toCharArray()){
            if(c>='a')l[c-'a'] = true;
            else u[c-'A'] = true;
        }
        int ans = 0;
        for(int i = 0;i<26;i++){
            if(l[i] && u[i])ans++;
        }
        return ans;
    }
}