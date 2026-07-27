class Solution {
    public int largestInteger(int n, int s) {
        if(s ==0)return 0;
        else if(n == 1){
            if(s>9)return -1;
            else return s;
        }
        else if(n == 2){
            if(s>18)return -1;
            else if(s>9){
                int x = s-9;
                int ans = 90+x;
                return ans;
            }
            else{
                return s*10;
            }
        }
        else if(n == 3){
            if(s>27)return -1;
            else if(s>18){
                return 990+s-18;
            }
            else if(s>9){
                return 990 - (18-s)*10;
            }
            else{
                return s*100;
            }
        }
        else if(n == 4){
            if(s>36)return -1;
            else if(s>27)return 9990+s-27;
            else if(s>18)return 9990-(27-s)*10;
            else if(s>9)return 9900-(18-s)*100;
            else return s*1000;
        }
        else if(n == 5){
            if(s>45)return -1;
            else if(s>36)return 99990+s-36;
            else if(s>27)return 99990-(36-s)*10;
            else if(s>18)return 99900-(27-s)*100;
            else if(s>9)return 99000-(18-s)*1000;
            else return s*10000;
        }
        return 6;
    }
}