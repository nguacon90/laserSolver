package vn.com.nguacon;

public class Cell {
	private Coordinate coordinate;
	private LaserDirection laserDirection;
	
	/**
	 * 0: khong co guong 
	 * 1: guong dang \ 
	 * 2: guong dang /
	 */
	private int mirror;
	
	public Cell() {
		
	}
	
	public Cell(Coordinate coordinate, LaserDirection laserDirection, int mirror) {
		this.coordinate = coordinate;
		this.laserDirection = laserDirection;
		this.mirror = mirror;
	}
	
	public LaserDirection getLaserDirection() {
		return laserDirection;
	}

	public void setLaserDirection(LaserDirection laserDirection) {
		this.laserDirection = laserDirection;
	}

	public int getMirror() {
		return mirror;
	}

	public void setMirror(int mirror) {
		this.mirror = mirror;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "Cell [coordinate=" + coordinate + ", laserDirection=" + laserDirection + ", mirror=" + mirror + "]";
	}

}
