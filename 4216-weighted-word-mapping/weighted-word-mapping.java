class Solution {
    char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length, m = weights.length;
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<n;i++){
            String s = words[i];
            int sum = 0;
            for(int j = 0;j<s.length();j++){
                sum += weights[s.charAt(j) - 97];
            }
            sum%=26;
            System.out.println(sum);
            sb.append(ch[26-sum-1]);
        }
        return sb.toString();
    }
}