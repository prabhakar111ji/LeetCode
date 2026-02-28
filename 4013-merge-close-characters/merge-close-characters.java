class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while(true){
            int n = sb.length(), l = -1, r =-1;
            for(int i = 0;i<n;i++){
                for(int j = i+1;j<n && j-i<=k;j++){
                    if(sb.charAt(i) == sb.charAt(j)){
                        l = i;
                        r = j;
                        break;
                    }
                }
                if(l!=-1)break;
            }
            if(l == -1)break;
            sb.deleteCharAt(r);
        }
        return sb.toString();
    }
}