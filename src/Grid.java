/**
 * This Grid will hold a cell and allow it to move to a different position on the grid.
 *
 * @author Michael Arteaga, Jeffrey Creighton, and Josh Levine 
 * @version Dec 5, 2014
 */
public class Grid {
	private Cell currCell;//current cell
	private Cell prevCell;//previous cell

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

	private final Cell dummy = new Cell(1000,1000,false,false,false,false);

	private Cell[][] grid = {
			{new Cell(armB,rakeC, false, true, false, true), new Cell(armC,rakeA,true,true,false,true), new Cell(armA,rakeB,true,true,false,true), new Cell(armD,rakeB,true,true,false,true), new Cell(armA,rakeA,true,false,false,true)},																							
			{new Cell(armA, rakeC, false,true,true,true), new Cell(armA,rakeE,true,true,true,true), new Cell(armE,rakeD,true,true,true,true), new Cell(armD,rakeE,true,true,true,true), new Cell(armB,rakeA,true,false,true,true)},
			{new Cell(armD,rakeD,false,true,true,true), new Cell(armD,rakeA,true,true,true,true), new Cell(armE,rakeE,true,true,true,true), new Cell(armC,rakeB,true,true,true,true), new Cell(armB,rakeD,true,false,true,true)},
			{new Cell(armC,rakeE,false,true,true,true), new Cell(armA,rakeD,true,true,true,true), new Cell(armC,rakeC,true,true,true,true), new Cell(armB,rakeE,true,true,true,true), new Cell(armE,rakeC,true,false,true,true)},
			{new Cell(armE,rakeA,false,true,true,false), new Cell(armE,rakeB,true,true,true,false), new Cell(armC,rakeD,true,true,true,false), new Cell(armB,rakeB,true,true,true,false),new Cell(armD,rakeC,true,false,true,false)}
	}; //create 5x5 grid with 25 cells

	public Grid () {		//constructor
		x = 0;
		y = 0;
		currCell = grid[x][y];
	}

	public Cell getCurrentCell() {		//Accessor methods
		return currCell;
	}

	public Cell getPreviousCell() {
		return prevCell;
	}

	public Cell getDummy(){
		return dummy;
	}

	/**
	 * Moves currCell to the right
	 * stores the previous cell
	 * @return true if it can move right, false otherwise
	 */
	public boolean moveRight() {
		if (currCell.hasNeighborRight()) {
			prevCell = currCell;
			currCell = grid[x+1][y];
			return true;
		}
		System.out.println("Can't move Right");
		return false;
	}

	/**
	 * Moves currCell to the left
	 * stores the previous cell
	 * @return true if it can move left, false otherwise
	 */
	public boolean moveLeft() {
		if (currCell.hasNeighborLeft()) {
			prevCell = currCell;
			currCell = grid[x-1][y];
			return true;
		}
		System.out.println("Can't move Left");
		return false;
	}

	/**
	 * Moves currCell to up
	 * stores the previous cell
	 * @return true if it can move up, false otherwise
	 */
	public boolean moveUp() {
		if (currCell.hasNeighborUp()) {
			prevCell = currCell;
			currCell = grid[x][y-1];
			return true;
		}
		System.out.println("Can't move Up");
		return false;
	}

	/**
	 * Moves currCell to down
	 * stores the previous cell
	 * @return true if it can move down, false otherwise
	 */
	public boolean moveDown() {
		if (currCell.hasNeighborDown()) {
			prevCell = currCell;
			currCell = grid[x][y+1];
			return true;
		}
		System.out.println("Can't move Down");
		return false;
	}

	/**
	 * Checks if a cell has an up neighbor then gives us that neighbor
	 * @return Cell above currCell, or dummy cell
	 */
	public Cell getCellUp(){
		Cell temp;

		if(currCell.hasNeighborUp()){
			temp = grid[x][y-1];
		}
		else{
			temp = dummy;
		}
		return temp;
	}

	/**
	 * Checks if a cell has a down neighbor then gives us that neighbor
	 * @return Cell below currCell, or dummy cell
	 */
	public Cell getCellDown(){
		Cell temp;

		if(currCell.hasNeighborUp()){
			temp = grid[x][y+1];
		}
		else{
			temp = dummy;
		}
		return temp;
	}

	/**
	 * Checks if a cell has a left neighbor then gives us that neighbor
	 * @return Cell left of currCell, or dummy cell
	 */
	public Cell getCellLeft(){
		Cell temp;

		if(currCell.hasNeighborUp()){
			temp = grid[x-1][y];
		}
		else{
			temp = dummy;
		}
		return temp;
	}

	/**
	 * Checks if a cell has a right neighbor then gives us that neighbor
	 * @return Cell right of currCell, or dummy cell
	 */
	public Cell getCellRight(){
		Cell temp;

		if(currCell.hasNeighborUp()){
			temp = grid[x+1][y];
		}
		else{
			temp = dummy;
		}
		return temp;
	}
}//class
