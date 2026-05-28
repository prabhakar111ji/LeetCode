class Solution {
    class Pair{
        int val, idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] twoSum(int[] nums, int t) {
        // n^2
        // int n = nums.length;
        // for(int i = 0;i<n;i++){
        //     for(int j = i+1;j<n;j++){
        //         if(nums[i] + nums[j] == t)return new int[]{i,j};
        //     }
        // }
        // return new int[]{-1,-1};

        // nlogn, n
        int n= nums.length;
        Pair[] arr = new Pair[n];
        for(int i = 0;i<n;i++){
            arr[i] = new Pair(nums[i],i);
        }
        Arrays.sort(arr, (a,b)->Integer.compare(a.val, b.val));
        int l = 0, r = n-1;
        while(l<r){
            if(arr[l].val + arr[r].val == t)return new int[]{arr[l].idx, arr[r].idx};
            if(arr[l].val + arr[r].val<t)l++;
            else r--;
        }
        return new int[]{-1,-1};

        // n, n
        // int n = nums.length;
        // Map<Integer, Integer> mp = new HashMap<>();
        // for(int i = 0;i<n;i++){
        //     if(mp.containsKey(t - nums[i]))return new int[]{mp.get(t-nums[i]), i};
        //     else mp.put(nums[i], i);
        // }
        // return new int[]{-1,-1};
    }
}