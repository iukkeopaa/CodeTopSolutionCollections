package NumberOfIslands;

class Solution2 {


    int m, n;
    int[] dirs = {0, 1, 0, -1, 0};


    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
            return;
        
        grid[i][j] = '2';
        for (int k = 0; k < 4; ++k) {
            dfs(grid, i + dirs[k], j + dirs[k + 1]);
        }
    }


    public int numIslands(char[][] grid) {
        this.m = grid.length; 
        this.n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
}
