public class Cell {
	
	private final int armRot;
	private final int rakeRot;  //position that our robots joints will move to
	
	private final boolean neighborLeft;  //These refer to our 5x5 grid,
	private final boolean neighborRight; //if the cell has a neighbor then
	private final boolean neighborUp;    //the variable is true, false otherwise
	private final boolean neighborDown;  

	private int goodness = 0;
	private int rewardLeft = 0;  //these help the robot pick a certain path
	private int rewardRight = 0;
	private int rewardUp = 0;
	private int rewardDown = 0;
	
	public Cell(int armRot, int rakeRot, boolean left, boolean right, boolean up, boolean down){
		
		this.armRot = armRot;
		this.rakeRot = rakeRot;
		this.neighborLeft = left;
		this.neighborRight = right;
		this.neighborUp = up;
		this.neighborDown = down;
	}

	//getters
	public int getGoodness() {
		return goodness;
	}

	public int getRewardLeft() {
		return rewardLeft;
	}

	public int getRewardRight() {
		return rewardRight;
	}
	
	public int getRewardUp() {
		return rewardUp;
	}

	public int getRewardDown() {
		return rewardDown;
	}

	public int getArmRot() {
		return armRot;
	}

	public int getRakeRot() {
		return rakeRot;
	}

	public boolean hasNeighborLeft() {
		return neighborLeft;
	}

	public boolean hasNeighborRight() {
		return neighborRight;
	}

	public boolean hasNeighborUp() {
		return neighborUp;
	}

	public boolean hasNeighborDown() {
		return neighborDown;
	}
	
	//setters
	public void setGoodness(int goodness) {
		this.goodness = goodness;
	}
	
	public void setRewardLeft(int rewardLeft) {
		this.rewardLeft = rewardLeft;
	}
	
	public void setRewardDown(int rewardDown) {
		this.rewardDown = rewardDown;
	}
	
	public void setRewardUp(int rewardUp) {
		this.rewardUp = rewardUp;
	}
	
	public void setRewardRight(int rewardRight) {
		this.rewardRight = rewardRight;
	}
	
	public String toString(){
		return "armRot: " + getArmRot() + "\n" +
			   "rakeRot: " + getRakeRot() + "\n"+
			   "neighborUp: " + hasNeighborUp() + "\n" +
			   "neighborDown: " + hasNeighborDown() + "\n" +
			   "neighborLeft: " + hasNeighborLeft() + "\n" +
			   "neighborRight: " + hasNeighborRight() + "\n" +
			   "rewardUp: " + getRewardUp() + "\n" +
			   "rewardDown: " + getRewardDown() + "\n" +
			   "rewardLeft: " + getRewardLeft() + "\n" +
			   "rewardRight: " + getRewardRight() + "\n" +
			   "goodness: " + getGoodness();
	}
}
