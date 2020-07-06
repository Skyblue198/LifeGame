package control;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CellLifeWorld;
import model.CellMes;

public class GameProcessTest {

	protected CellLifeWorld world;
	private CellMes[][] cells;
	public GameProcessTest()
	{
		cells=new CellMes[15][15];
		for(int i=0;i<15;i++)
			for(int j=0;j<15;j++)
			{
				cells[i][j]=new CellMes();
			}
		world=new CellLifeWorld(15,15);
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
	public void testCellMultiply() {
	
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
			
				int cellNum=world.getPericyteCellNum(i, j);
				if(world.getCellStatus(i, j)!=cellSavePrinciple(world.getCellStatus(i, j),cellNum))
				{
					world.setChangeFlag(i, j);
					assertEquals(true,cells[i][j].isChangeStatus());
				}				
			}
		}
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				if(world.getChangeStatus(i, j))
				{
					boolean beforeStatus=cells[i][j].isCellStatus();
					assertEquals(false,cells[i][j].isCellStatus());
					world.changeCellStatus(i, j);
					assertEquals(true,cells[i][j].isCellStatus());
					assertEquals(false,beforeStatus);
					assertEquals(false,world.changeCellStatus(i,j));
					world.canelChangeFlag(i, j);
					assertEquals(false,cells[i][j].isChangeStatus());
				}
			}
		}
		
					}
		


	@Test
	public void testGetAllCellStatus() {
		int width=15;
		int length=15;
		
		int[][] cellSaveRect=new int[width][length];
		
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<length;j++)
			{
				if(world.getCellStatus(i, j))
				{
					cellSaveRect[i][j]=1;
					assertEquals(1,cellSaveRect[i][j]);
				}
				else
				{   
					cellSaveRect[i][j]=0;
					assertEquals(0,cellSaveRect[i][j]);
				}
			}
		}
		
		
	}
	
	private boolean cellSavePrinciple(boolean curStatus,int surCellNumber)
	{
		if(surCellNumber==3)
		{
			return true;
		}
		else if(surCellNumber==2)
		{
			return curStatus;
		}
		else
		{
			return false;
		}
	}

}
