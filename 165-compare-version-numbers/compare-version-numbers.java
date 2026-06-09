class Solution {
    public int compareVersion(String version1, String version2) {
        int n= version1.length();
        int m= version2.length();
        int i= 0, j = 0;
        while(i<n && j<m){
            int k = i;
            while(k<n && version1.charAt(k) != '.'){
                k++;
            }
            int x = Integer.parseInt(version1.substring(i,k));
            int l = j;
            while(l<m && version2.charAt(l) != '.'){
                l++;
            }
            int y = Integer.parseInt(version2.substring(j,l));
            if(x<y)return -1;
            else if(x>y)return 1;
            else {
                i=k+1;
                j=l+1;
            }
        }
        while(i<n){
            int k = i;
            while(k<n && version1.charAt(k) != '.'){
                k++;
            }
            int x = Integer.parseInt(version1.substring(i,k));
            int y = 0;
            if(x<y)return -1;
            else if(x>y)return 1;
            else {
                i=k+1;
            }
        }
        while(j<m){
            int l = j;
            while(l<m && version2.charAt(l) != '.'){
                l++;
            }
            int y = Integer.parseInt(version2.substring(j,l));
            int x = 0;
            if(x<y)return -1;
            else if(x>y)return 1;
            else {
                j=l+1;
            }
        }
        return 0;
        
    }
}