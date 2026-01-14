class Solution {
    static class E {
        long y,x1,x2; int t;
        E(long y,long a,long b,int t){this.y=y;x1=a;x2=b;this.t=t;}
    }
    static class ST {
        int n; long[] xs,len; int[] c;
        ST(long[] xs){this.xs=xs;n=xs.length-1;len=new long[4*n];c=new int[4*n];}
        void u(int i,int l,int r,int ql,int qr,int v){
            if(ql>=r||qr<=l)return;
            if(ql<=l&&r<=qr)c[i]+=v;
            else{
                int m=(l+r)/2;
                u(i*2,l,m,ql,qr,v);
                u(i*2+1,m,r,ql,qr,v);
            }
            len[i]=c[i]>0?xs[r]-xs[l]:(l+1==r?0:len[i*2]+len[i*2+1]);
        }
    }

    public double separateSquares(int[][] sq) {
        List<E> ev=new ArrayList<>();
        TreeSet<Long> set=new TreeSet<>();
        for(int[] s:sq){
            long x=s[0],y=s[1],l=s[2];
            ev.add(new E(y,x,x+l,1));
            ev.add(new E(y+l,x,x+l,-1));
            set.add(x); set.add(x+l);
        }
        long[] xs=set.stream().mapToLong(Long::longValue).toArray();
        ev.sort(Comparator.comparingLong(e->e.y));
        ST st=new ST(xs);

        double total=0;
        long py=ev.get(0).y;
        for(E e:ev){
            total+=st.len[1]*(e.y-py);
            int l=Arrays.binarySearch(xs,e.x1), r=Arrays.binarySearch(xs,e.x2);
            st.u(1,0,st.n,l,r,e.t);
            py=e.y;
        }

        double half=total/2, cur=0;
        Arrays.fill(st.c,0); Arrays.fill(st.len,0);
        py=ev.get(0).y;

        for(E e:ev){
            double strip=st.len[1]*(e.y-py);
            if(cur+strip>=half)
                return py+(half-cur)/st.len[1];
            cur+=strip;
            int l=Arrays.binarySearch(xs,e.x1), r=Arrays.binarySearch(xs,e.x2);
            st.u(1,0,st.n,l,r,e.t);
            py=e.y;
        }
        return py;
    }
}
