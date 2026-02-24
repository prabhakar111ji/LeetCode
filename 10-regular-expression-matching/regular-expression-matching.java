class Solution {
    private Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return matchHelper(0,0,s,p);
    }
    private boolean matchHelper(int i, int j, String s, String p){
        if(j == p.length())return i == s.length();
        if(memo[i][j]!=null)return memo[i][j];
        boolean currentMatch = (i<s.length() && (s.charAt(i) == p.charAt(j)|| p.charAt(j) == '.'));
        boolean result;
        if(j+1<p.length() && p.charAt(j+1) == '*'){
            boolean skipPattern = matchHelper(i,j+2,s,p);
            boolean userStar = currentMatch && matchHelper(i+1, j, s, p);
            result = skipPattern || userStar;
        }else{
            result = currentMatch && matchHelper(i+1, j+1, s, p);
        }
        memo[i][j] = result;
        return result;
    }
}