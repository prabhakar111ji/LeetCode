import java.util.*;

class Solution {

    int n, timer = 0;
    List<Integer>[] tree;
    int[] parent, depth, heavy, head, pos, size, nodeAtPos;
    int[] seg;
    char[] ch;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        ch = s.toCharArray();

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        size = new int[n];
        nodeAtPos = new int[n];
        Arrays.fill(heavy, -1);

        dfs(0, -1);
        decompose(0, 0);

        seg = new int[4 * n];
        build(1, 0, n - 1);

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                ch[u] = p[2].charAt(0);
                update(1, 0, n - 1, pos[u], 1 << (ch[u] - 'a'));
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int mask = queryPath(u, v);
                ans.add((mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }

    int dfs(int u, int p) {
        parent[u] = p;
        size[u] = 1;
        int max = 0;
        for (int v : tree[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            int sub = dfs(v, u);
            size[u] += sub;
            if (sub > max) {
                max = sub;
                heavy[u] = v;
            }
        }
        return size[u];
    }

    void decompose(int u, int h) {
        head[u] = h;
        pos[u] = timer;
        nodeAtPos[timer] = u;
        timer++;

        if (heavy[u] != -1)
            decompose(heavy[u], h);

        for (int v : tree[u])
            if (v != parent[u] && v != heavy[u])
                decompose(v, v);
    }

    void build(int node, int l, int r) {
        if (l == r) {
            int u = nodeAtPos[l];
            seg[node] = 1 << (ch[u] - 'a');
        } else {
            int m = (l + r) / 2;
            build(node * 2, l, m);
            build(node * 2 + 1, m + 1, r);
            seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
        }
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
        } else {
            int m = (l + r) / 2;
            if (idx <= m)
                update(node * 2, l, m, idx, val);
            else
                update(node * 2 + 1, m + 1, r, idx, val);
            seg[node] = seg[node * 2] ^ seg[node * 2 + 1];
        }
    }

    int query(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return seg[node];
        int m = (l + r) / 2;
        return query(node * 2, l, m, ql, qr) ^
               query(node * 2 + 1, m + 1, r, ql, qr);
    }

    int queryPath(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int t = u; u = v; v = t;
            }
            res ^= query(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int t = u; u = v; v = t;
        }
        res ^= query(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}
