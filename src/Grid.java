/**
 * This Grid will hold a cell and allow it to move to a different position on the grid.
 *
 * @author Michael Arteaga
 * @version Dec 5, 2014
 */
public class Grid {
	private Cell currCell;
	private Cell prevCell;
	
	private int x; //column
	private int y; //row
	
	private final int armA = 10;			//Arm positions (measured by degrees)
	private final int armB = 0;
	private final int armC = -25;
	private final int armD = -45;
	private final int armE = -60;
	
	private final int rakeA = 30;			//rake positions (by degrees)
	private final int rakeB = 20;
	private final int rakeC = 0;
	private final int rakeD = -20;
	private final int rakeE = -40;
	
	private Cell[][] grid = {
			{new Cell(armB,rakeC, false, true, false, true), new Cell(armC,rakeA,true,true,false,true), new Cell(armA,rakeB,true,true,false,true), new Cell(armD,rakeB,true,true,false,true), new Cell(armA,rakeA,true,false,false,true)},																							
			{new Cell(armA, rakeC, false,true,true,true), new Cell(armA,rakeE,true,true,true,true), new Cell(armE,rakeD,true,true,true,true), new Cell(armD,rakeE,true,true,true,true), new Cell(armB,rakeA,true,false,true,true)},
			{new Cell(armD,rakeD,false,true,true,true), new Cell(armD,rakeA,true,true,true,true), new Cell(armE,rakeE,true,true,true,true), new Cell(armC,rakeB,true,true,true,true), new Cell(armB,rakeD,true,false,true,true)},
			{new Cell(armC,rakeE,false,true,true,true), new Cell(armA,rakeD,true,true,true,true), new Cell(armC,rakeC,true,true,true,true), new Cell(armB,rakeE,true,true,true,true), new Cell(armE,rakeC,true,false,true,true)},
			{new Cell(armE,rakeA,false,true,true,false), new Cell(armE,rakeB,true,true,true,false), new Cell(armC,rakeD,true,true,true,false), new Cell(armB,rakeB,true,true,true,false),new Cell(armD,rakeC,true,false,true,false)}
	};
	
	public Grid () {
		x = 0;
		y = 0;
		currCell = grid[x][y];
	}
	
	public Cell getCurrentCell() {
		return currCell;
	}
	
	public Cell getPreviousCell() {
		return prevCell;
	}
	
	public boolean moveRight() {
		if (currCell.hasNeighborRight()) {
			prevCell = currCell;
			currCell = grid[x+1][y];
			return true;
		}
		System.out.println("Can't move Right");
		return false;
	}
	
	public boolean moveLeft() {
		if (currCell.hasNeighborLeft()) {
			prevCell = currCell;
			currCell = grid[x-1][y];
			return true;
		}
		System.out.println("Can't move Left");
		return false;
	}
	
	public boolean moveUp() {
		if (currCell.hasNeighborUp()) {
			prevCell = currCell;
			currCell = grid[x][y-1];
			return true;
		}
		System.out.println("Can't move Up");
		return false;
	}
	
	public boolean moveDown() {
		if (currCell.hasNeighborDown()) {
			prevCell = currCell;
			currCell = grid[x][y+1];
			return true;
		}
		System.out.println("Can't move Down");
		return false;
	}
	

}
