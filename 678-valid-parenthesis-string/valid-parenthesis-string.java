class Solution {
    public boolean checkValidString(String s) {
        int max = 0, min = 0;
        for(char c:s.toCharArray()){
            if(c=='('){
                max++;min++;
            }
            else if(c==')'){
                max--;min--;
            }
            else{
                max++;
                min--;
            }
            if(max<0)return false;
            min=Math.max(min,0);
        }
        return min==0;
    }
}