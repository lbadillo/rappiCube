package rappi.cubeSummation.model;


public class Cube {
	private int xCoordinate=0;
	private int yCoordinate=0;
	private int zCoordinate=0;
	private int value;
	
	
	private int XKEY=2;
	private int YKEY=3;
	private int ZKEY=7;
	
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public int getzCoordinate() {
		return zCoordinate;
	}
	public void setzCoordinate(int zCoordinate) {
		this.zCoordinate = zCoordinate;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getKey() {
		return xCoordinate*XKEY+yCoordinate*YKEY+zCoordinate*ZKEY;
	}
	
	public int getPublicKey(int x, int y, int z){
		return x*XKEY+y*YKEY+z*ZKEY;
	}
	
	
	

}
