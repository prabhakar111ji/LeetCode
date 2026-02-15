class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] f = new int[101];
        List<Integer> ans = new ArrayList<>();
        for( int b:bulbs){
            f[b]++;
        }
        for(int i = 0;i<101;i++){
            if(f[i]%2==1)ans.add(i);
        }
        return ans;
    }
}