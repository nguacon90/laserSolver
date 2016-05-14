package vn.com.nguacon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaserSolverImpl implements LaserSolver {
	private Map<Coordinate, Cell> matrixMap;
	
	@Override
	public int solveCountMirror(int n, Cell laserInfo, List<Cell> mirrors) {
		int count = 0;
		matrixMap = initMatrixMap(n, laserInfo, mirrors);
		
		Cell currentCell = matrixMap.get(laserInfo.getCoordinate());
		
		//Kiem tra vi tri ban dau cua de co guong hay ko
		if(currentCell.getMirror() != 0) {
			currentCell.setLaserDirection(getLaserDirection(currentCell, currentCell.getLaserDirection()));
			count++;
		}
		
		do {
			
			currentCell = getNextCell(currentCell);
			
			if(currentCell !=null && currentCell.getMirror() != 0) {
				count++;
			}
			
		} while(currentCell != null);
		
		return count;
	}

	protected Cell getNextCell(Cell currentCell) {
		Coordinate currentCoordinate = currentCell.getCoordinate();
		Cell nextCell = null;
		Coordinate nextCoordinate = null;
		LaserDirection currentLaserDirection = currentCell.getLaserDirection();
		
		if(LaserDirection.RIGHT.equals(currentLaserDirection)) {
			nextCoordinate = new Coordinate(currentCoordinate.getRow(), currentCoordinate.getCol()+1);
		}
		
		
		if(LaserDirection.LEFT.equals(currentLaserDirection)) {
			nextCoordinate = new Coordinate(currentCoordinate.getRow(), currentCoordinate.getCol()-1);
		}
		
		if(LaserDirection.DOWN.equals(currentLaserDirection)) {
			nextCoordinate = new Coordinate(currentCoordinate.getRow()+1, currentCoordinate.getCol());
		}
		
		if(LaserDirection.UP.equals(currentLaserDirection)) {
			nextCoordinate = new Coordinate(currentCoordinate.getRow()-1, currentCoordinate.getCol());
		}
		
		nextCell = matrixMap.get(nextCoordinate);
		
		if(nextCell != null) {
			nextCell.setLaserDirection(getLaserDirection(nextCell, currentLaserDirection));
		}
		
		return nextCell;
	}
	
	protected LaserDirection getLaserDirection(Cell cell, LaserDirection currentLaserDirection) {
		LaserDirection result = currentLaserDirection;
		switch (cell.getMirror()) {
		//1 : \ ; 2 : /
		case 1: 
			switch (currentLaserDirection) {
			case RIGHT:
				result = LaserDirection.DOWN;
				break;
			case UP:
				result = LaserDirection.LEFT;
				break;
			case LEFT:
				result = LaserDirection.UP;
				break;
			case DOWN:
				result = LaserDirection.RIGHT;
				break;
			}
			break;
		case 2:
			switch (currentLaserDirection) {
			case RIGHT:
				result = LaserDirection.UP;
				break;
			case UP:
				result = LaserDirection.RIGHT;
				break;
			case LEFT:
				result = LaserDirection.DOWN;
				break;
			case DOWN:
				result = LaserDirection.LEFT;
				break;
			}
			break;
		}

		return result;
	}

	protected Map<Coordinate, Cell> initMatrixMap(int n, Cell laserInfo, List<Cell> mirrors) {
		Map<Coordinate, Cell> map = new HashMap<>();
		
		//Init map with blank cell
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				Coordinate coordinate = new Coordinate(row, col);
				Cell cell = new Cell();
				cell.setCoordinate(coordinate);
				map.put(coordinate, cell);
			}
		}
		
		//Set mirrors Cell
		for (Cell cell : mirrors) {
			map.put(cell.getCoordinate(), cell);
		}
		
		//set laser direction 
		Cell cell = map.get(laserInfo.getCoordinate());
		cell.setLaserDirection(laserInfo.getLaserDirection());

		return map;
	}
	
}
