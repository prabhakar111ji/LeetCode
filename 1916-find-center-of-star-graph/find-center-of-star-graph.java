class Solution {
    public int findCenter(int[][] edges) {
        int m= edges.length, n = edges[0].length, k = 0;
        Map<Integer, Integer> mp = new HashMap<>();
       for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            mp.put(edges[i][j], mp.getOrDefault(edges[i][j],0)+1);
        }
       }
       for(int x: mp.keySet()){
        if(mp.get(x)==m)return x;
       }
       return -1;
    }
}