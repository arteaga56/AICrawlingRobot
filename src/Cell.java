/**
 * Cell class holds information such as if it has neighbor cell that a cell
 * can possibly move to, the goodness value, and the rewards the cell obtained 
 * when moving to a different cell.
 *
 * @author Michael Arteaga, Jeffrey Creighton, and Josh Levine 
 * @version Dec 5, 2014
 */

public class Cell {
	
	private final int armRot;
	private final int rakeRot;  //position that our robots joints will move to
	
	private final boolean neighborLeft;  //These refer to our 5x5 grid,
	private final boolean neighborRight; //if the cell has a neighbor then
	private final boolean neighborUp;    //the variable is true, false otherwise
	private final boolean neighborDown;  

	private int goodness = 0;
	private int rewardLeft = 0;  //keeps track of how far the robot moves if takes an action.
	private int rewardRight = 0;
	private int rewardUp = 0;
	private int rewardDown = 0;
	
	private int policyLeft = 0;  //tells the robot where it should go
	private int policyRight = 0;
	private int policyUp = 0;
	private int policyDown = 0;
	
	public Cell(int armRot, int rakeRot, boolean left, boolean right, boolean up, boolean down){
		
		this.armRot = armRot;
		this.rakeRot = rakeRot;
		this.neighborLeft = left;
		this.neighborRight = right;
		this.neighborUp = up;
		this.neighborDown = down;
	}

	public int getGoodness() {		//Accessor methods
		return goodness;
	}

	public int getPolicyLeft(){
		return policyLeft;
	}
	
	public int getPolicyRight(){
		return policyRight;
	}
	
	public int getPolicyUp(){
		return policyUp;
	}
	
	public int getPolicyDown(){
		return policyDown;
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
	
	public void setGoodness(int goodness) {		//Mutator methods
		this.goodness = goodness;
	}
	
	public void setPolicyLeft(int policyLeft){
		this.policyLeft = policyLeft;
	}
	
	public void setPolicyRight(int policyRight){
		this.policyRight = policyRight;
	}
	
	public void setPolicyUp(int policyUp){
		this.policyUp = policyUp;
	}
	
	public void setPolicyDown(int policyDown){
		this.policyDown = policyDown;
	}
	
	public void setRewardLeft(int rewardLeft) {//the reward mutators also update the policy
		policyLeft += rewardLeft;			   //because the policy is the accumulation
		this.rewardLeft = rewardLeft;		   //of all the rewards
	}
	
	public void setRewardDown(int rewardDown) {
		policyDown += rewardDown;
		this.rewardDown = rewardDown;
	}
	
	public void setRewardUp(int rewardUp) {
		policyUp += rewardUp;
		this.rewardUp = rewardUp;
	}
	
	public void setRewardRight(int rewardRight) {
		policyRight += rewardRight;
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
