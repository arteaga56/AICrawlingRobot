
/**
 * This Grid will 
 *
 * @author Michael Arteaga
 * @version Dec 5, 2014
 */
public class Grid {
	private Cell[][] grid;
	private Cell currCell;
	private Cell prevCell;
	
	private int x; //column
	private int y; //row
	
	public Grid (int x, int y){
		this.x = x;
		this.y = y;
		grid = new Cell[5][5];
		currCell = grid[x][y];
	}
	
	public Grid () {
		
		grid = new Cell[5][5];
		currCell = grid[0][0];
	}
	
	public Cell getCurrentCell() {
		return currCell;
	}
	
	public boolean moveRight() {
		if (currCell.hasNeighborRight()) {
			currCell = grid[x+1][y];
			return true;
		}
		return false;
	}
	
	public boolean moveLeft() {
		if (currCell.hasNeighborLeft()) {
			currCell = grid[x-1][y];
			return true;
		}
		return false;
	}
	
	public boolean moveUp() {
		if (currCell.hasNeighborUp()) {
			currCell = grid[x][y-1];
			return true;
		}
		return false;
	}
	
	public boolean moveDown() {
		if (currCell.hasNeighborDown()) {
			currCell = grid[x][y+1];
			return true;
		}
		return false;
	}
	
	

}
