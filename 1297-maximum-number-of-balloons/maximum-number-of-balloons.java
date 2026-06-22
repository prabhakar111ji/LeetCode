class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] f= new char[26];
        for(char c: text.toCharArray()){
            f[c-'a']++;
        }
        return Math.min(Math.min(f['b'-'a'], f['a' - 'a']), Math.min(Math.min(f['l'-'a']/2,f['o'-'a']/2), f['n'-'a']));
    }
}