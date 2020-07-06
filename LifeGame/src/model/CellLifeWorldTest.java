package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellLifeWorldTest {
	
	private  CellMes[][] cells;
	private CellLifeWorld world;
	public CellLifeWorldTest() {
		world=new CellLifeWorld(15,15);
		cells=new CellMes[15][15];
		for(int i=0;i<15;i++)
			for(int j=0;j<15;j++)
			{
				cells[i][j]=new CellMes();
			}
	}

	@Before
	public void setUp() throws Exception {
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				cells[i][j].setCellStatus(false);
				cells[i][j].setChangeStatus(false);
			}
		}
	}
	
	
    
	@Test
	public void testRandomCellsStatus() {
		int randomNum=(int) (Math.random()*10);
		if(randomNum>4) {
			cells[1][1].setCellStatus(true);
			assertEquals(true,cells[1][1].isCellStatus());
			}
		else {
			cells[1][1].setCellStatus(false);
			assertEquals(false,cells[1][1].isCellStatus());
		}
		cells[1][1].setChangeStatus(false);
		assertEquals(false,cells[1][1].isChangeStatus());
	}

	@Test
	public void testGetCellStatus() {
		assertEquals(false,world.getCellStatus(-1, 1));
		assertEquals(false,world.getCellStatus(1, -1));
		assertEquals(false,world.getCellStatus(1, 15));
		assertEquals(false,world.getCellStatus(15, 1));
		cells[1][1].setCellStatus(true);
		assertEquals(true,cells[1][1].isCellStatus());
		
	}

	@Test
	public void testChangeCellStatus() {
		assertEquals(false,cells[1][1].isCellStatus());
		boolean beforeStatus=cells[1][1].isCellStatus();
		cells[1][1].setCellStatus(!beforeStatus);
		assertEquals(true,cells[1][1].isCellStatus());
		assertEquals(beforeStatus,world.changeCellStatus(1,1));
	}

	@Test
	public void testGetChangeStatus() {
		assertEquals(false,cells[1][1].isChangeStatus());
		assertEquals(false,world.getChangeStatus(1, 1));
		cells[1][1].setChangeStatus(true);
		assertEquals(true,cells[1][1].isChangeStatus());
		
	}

	@Test
	public void testSetChangeFlag() {
		assertEquals(false,cells[1][1].isChangeStatus());
		cells[1][1].setChangeStatus(true);
		assertEquals(true,cells[1][1].isChangeStatus());
	}

	@Test
	public void testCanelChangeFlag() {
		cells[1][1].setChangeStatus(true);
		assertEquals(true,cells[1][1].isChangeStatus());
		cells[1][1].setChangeStatus(false);
		assertEquals(false,cells[1][1].isChangeStatus());
	}

	

}
