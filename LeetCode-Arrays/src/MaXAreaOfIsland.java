
public class MaXAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		MaXAreaOfIsland max = new MaXAreaOfIsland();
		System.out.println(max.maxAreaOfIsland(grid));
	}

	public int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] seen = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				seen[i][j] = false;
			}
		}
		int maxCount = 0;
		for (int i = 0; i < rows; i++) {
			int count = 0;
			for (int j = 0; j < columns; j++) {
				count = countArea(grid, i, j, seen);
				maxCount = Math.max(maxCount, count);
			}
		}
		return maxCount;
	}

	public int countArea(int[][] grid, int r, int c, boolean[][] seen) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0)
			return 0;
		seen[r][c] = true;
		return (1 + countArea(grid, r - 1, c, seen) + countArea(grid, r + 1, c, seen) + countArea(grid, r, c - 1, seen)
				+ countArea(grid, r, c + 1, seen));
	}

}
