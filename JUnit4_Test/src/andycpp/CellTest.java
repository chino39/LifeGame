package andycpp;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellTest {
	
	private static Cell cell = new Cell(20, 10);
	private static int [][]grid = new int[22][12];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testGetGrid() {
		for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 12; j++)
            	grid[i][j] = 0;
        }
		
		grid[20][7] = 1;
		grid[19][8] = 1;
		grid[12][12] = 1;
		
		cell.setGrid(grid);
		grid = cell.getGrid();
		
		assertEquals(1,grid[20][7]);
		assertEquals(1,grid[19][8]);
		assertEquals(0,grid[3][4]);
		
	}

	@Test
	public void testUpdate() {
		for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 12; j++)
            	grid[i][j] = 0;
        }
		
		grid[11][7] = 1;
		grid[10][8] = 1;
		grid[12][8] = 1;
		grid[20][7] = 1;
		grid[20][8] = 1;
		grid[19][8] = 1;
		
		cell.setGrid(grid);
		cell.update();
		grid = cell.getGrid();

		assertEquals(1,grid[11][8]);
		assertEquals(1,grid[19][7]);
		assertEquals(0,grid[20][8]);
		assertEquals(0,grid[2][2]);
	}

	@Test
	public void testGetNeighborCount() {
		for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 18; j++)
            	grid[i][j] = 0;
        }
		
	    grid[10][4] = 1;
	    grid[12][4] = 1;
	    grid[10][6] = 1;	
	    cell.setGrid(grid);
		assertEquals(3,cell.getNeighborCount(11,5));
		
		grid[4][5] = 1;grid[6][6] = 1;
		cell.setGrid(grid);
		assertEquals(2,cell.getNeighborCount(5,6));	
		
	    grid[20][8] = 1;
		grid[20][9] = 1;
		grid[20][10] = 1;
		grid[18][8] = 1;
		grid[18][10] = 1;
		cell.setGrid(grid);
		assertEquals(5,cell.getNeighborCount(19,9));
			
	}

}
