class Solution {
        public List<Integer> findGoodIntegers(int n) {
                Map<Integer, Integer> cnts = new HashMap<>();
                for(int a = 1; ; a++){
                long a3 = (long) a* a* a;
                if(a3>n)break;
                for(int b = a; ; b++){
                long sm = a3 + (long) b*b*b;if(sm>n)break;cnts.put((int) sm, cnts.getOrDefault((int) sm, 0) + 1);
                }
               }
                List<Integer> rest = new ArrayList<>();
                for(var enty : cnts.entrySet()){
                if(enty.getValue()>1)rest.add(enty.getKey());
                }
                Collections.sort(rest);
                return rest;
                }
                                                                                                    
}