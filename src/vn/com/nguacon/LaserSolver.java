package vn.com.nguacon;

import java.util.List;

public interface LaserSolver {
	/**
	 * 
	 * @param n kích thước của ma trận 
	 * @param laserInfo thông tin về vị trí đèn và hướng 
	 * @param mirrors thông tin vị trí gương
	 * @return
	 */
	int solveCountMirror(int n, Cell laserInfo, List<Cell> mirrors);
}
