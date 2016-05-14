package vn.com.nguacon;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LaserSolverTest {
	private LaserSolver laserSolver;
	List<Cell> mirrors;
	Cell laserInfo;
	int n;
	
	@Before
	public void setUp() {
		mirrors = new ArrayList<>();
		laserSolver = new LaserSolverImpl();
	}
	
	/*
	 * n = 3, laser: 0 0 RIGHT, mirror 0 0 1
	 * \ - - 
	 * - - -
	 * - - -
	 * return 1
	 */
	@Test
	public void testCase1() {
		laserInfo = new Cell(new Coordinate(0, 0), LaserDirection.RIGHT, 0);
		Cell mirror = new Cell(new Coordinate(0, 0), null, 1);
		mirrors.add(mirror);
		n = 3;
		int solveCountMirror = laserSolver.solveCountMirror(n, laserInfo, mirrors);
		assertEquals(1, solveCountMirror);
	}
	
	/*
	 * n = 3, laser: 0 0 RIGHT, mirror 0 0 1
	 * \ - - 
	 * \ - -
	 * \ - -
	 * return 2
	 */
	@Test
	public void testCase1_return2() {
		laserInfo = new Cell(new Coordinate(0, 0), LaserDirection.RIGHT, 0);
		mirrors.add(new Cell(new Coordinate(0, 0), null, 1));
		mirrors.add(new Cell(new Coordinate(1, 0), null, 1));
		mirrors.add(new Cell(new Coordinate(2, 0), null, 1));
		n = 3;
		int solveCountMirror = laserSolver.solveCountMirror(n, laserInfo, mirrors);
		assertEquals(2, solveCountMirror);
	}
	
	/*
	 * n = 3, laser: 0 0 RIGHT, mirror 0 2 1, 2 0 1, 2 2 2
	 * - - \ 
	 * - - -
	 * \ - /
	 * return 3
	 */
	@Test
	public void testCase2() {
		laserInfo = new Cell(new Coordinate(0, 0), LaserDirection.RIGHT, 0);
		Cell mirror = new Cell(new Coordinate(0, 2), null, 1);
		Cell mirror2 = new Cell(new Coordinate(2, 0), null, 1);
		Cell mirror3 = new Cell(new Coordinate(2, 2), null, 2);
		mirrors.add(mirror);
		mirrors.add(mirror2);
		mirrors.add(mirror3);
		n = 3;
		
		int solveCountMirror = laserSolver.solveCountMirror(n, laserInfo, mirrors);
		assertEquals(3, solveCountMirror);
	}
	
	/*
	 * n = 10, laser: 0 0 RIGHT, toa do nhu hinh
	 *   0 1 2 3 4 5 6 7 8 9
	 * 0 - - - - - - - - - \ 
	 * 1 / - - - - - - - \ -
	 * 2 - / - - - - - \ - -
	 * 3 - - / - - - \ - - -
	 * 4 - - - / - \ - - - -
	 * 5 - - - - \ / - - - -
	 * 6 - - - \ - - / - - -
	 * 7 - - \ - - - - / - -
	 * 8 - \ - - - - - - / -
	 * 9 \ - - - - - - - - /
	 * return 19
	 */
	@Test
	public void testCase3() {
		laserInfo = new Cell(new Coordinate(0, 0), LaserDirection.RIGHT, 0);
		mirrors.add(new Cell(new Coordinate(0, 9), null, 1));

		mirrors.add(new Cell(new Coordinate(1, 8), null, 1));
		mirrors.add(new Cell(new Coordinate(2, 7), null, 1));
		mirrors.add(new Cell(new Coordinate(3, 6), null, 1));
		mirrors.add(new Cell(new Coordinate(4, 5), null, 1));
		mirrors.add(new Cell(new Coordinate(5, 4), null, 1));
		mirrors.add(new Cell(new Coordinate(6, 3), null, 1));
		mirrors.add(new Cell(new Coordinate(7, 2), null, 1));
		mirrors.add(new Cell(new Coordinate(8, 1), null, 1));
		mirrors.add(new Cell(new Coordinate(9, 0), null, 1));
		mirrors.add(new Cell(new Coordinate(1, 0), null, 2));
		mirrors.add(new Cell(new Coordinate(2, 1), null, 2));
		mirrors.add(new Cell(new Coordinate(3, 2), null, 2));
		mirrors.add(new Cell(new Coordinate(4, 3), null, 2));
		mirrors.add(new Cell(new Coordinate(5, 5), null, 2));
		mirrors.add(new Cell(new Coordinate(6, 6), null, 2));
		mirrors.add(new Cell(new Coordinate(7, 7), null, 2));
		mirrors.add(new Cell(new Coordinate(8, 8), null, 2));
		mirrors.add(new Cell(new Coordinate(9, 9), null, 2));
		n = 10;
		
		int solveCountMirror = laserSolver.solveCountMirror(n, laserInfo, mirrors);
		assertEquals(19, solveCountMirror);
	}
	
}
