/**
 * 
 * @author Jeffrey Creighton
 *
 */
import java.util.Random;
public class Algo {
	private Grid plane;
	private Random random;
	private int modeCheck;
	private Cell cell;
	private double discounting_factor;
	private int r = 0;

	public Algo(){
		plane = new Grid();
		random = new Random();
		modeCheck = 100;
		discounting_factor = 0.9;
	}

	/**
	 * Decide on a cell to move to 
	 * @return cell
	 */
	public Cell step() {
		cell = plane.getCurrentCell();
		if(r < modeCheck){
			explore();
		}else{
			exploit();
		}
		r = random.nextInt(500)+1;
		return cell;
	}

	/**
	 * Make a random cell selection of up, down, left, or right
	 */
	private void explore(){
		System.out.println("Exploring!");
		int direction;
		boolean moving = true;
		while(moving){ //start loop
			direction = random.nextInt(4);
			if(direction == 0){ //try to move up
				if(cell.hasNeighborUp()){
					cell.setPolicy(0);
					moving = false;
				}
			}else if(direction == 1){ //try to move down
				if(cell.hasNeighborDown()) {
					cell.setPolicy(1);
					moving = false;
				}
			}else if(direction == 2){ //try to move left
				if(cell.hasNeighborLeft()){
					cell.setPolicy(2);
					moving = false;
				}
			}else if(direction == 3){ //try to move right
				if(cell.hasNeighborRight()){
					cell.setPolicy(3);
					moving = false;
				}
			}
		}// end loop
	}

	/**
	 * Make a calculated cell selection of up, down, left, or right
	 */
	private void exploit() {
		System.out.println("Exploiting!");
		int[] list = new int[4];
		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;

		if(cell.hasNeighborUp()) {
			up = (int) (cell.getRewardUp() + (discounting_factor * plane.getCellUp().getGoodness()));
		}
		if(cell.hasNeighborDown()) {
			down = (int) (cell.getRewardDown() + (discounting_factor * plane.getCellDown().getGoodness()));
		}
		if(cell.hasNeighborLeft()) {
			left = (int) (cell.getRewardLeft() + (discounting_factor * plane.getCellLeft().getGoodness()));
		}
		if(cell.hasNeighborRight()) {
			right = (int) (cell.getRewardRight() + (discounting_factor * plane.getCellRight().getGoodness()));
		}
		list[0] = up;
		list[1] = down;
		list[2] = left;
		list[3] = right;

		int largest = list[0];
		int direction = 0;
		for(int i = 0; i<=3; i++) {
			if(list[i] > largest) {
				largest = list[i];
				direction = i;
			}
		}

		cell.setGoodness(largest);
		cell.setPolicy(direction);
	}
}// end class
