class Solution {
    public int mirrorFrequency(String s) {
    int[] fqn = new int[123];
    for(char c : s.toCharArray())fqn[c]++;
    int sum = 0;
    boolean[] vstd = new boolean[123];
    for(int i = 0;i<123;i++){
    if(fqn[i]>0 && !vstd[i]){
    int m = (i>= 'a') ? 'a' + 'z' - i: '0' + '9' -i;
    sum += Math.abs(fqn[i] - fqn[m]);
    vstd[i] = vstd[m] = true;
    }
    }
    return sum;
    }
}