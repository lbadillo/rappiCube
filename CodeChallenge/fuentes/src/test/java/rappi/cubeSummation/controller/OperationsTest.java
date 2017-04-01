package rappi.cubeSummation.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.*;


import java.util.HashMap;

import org.junit.Test;

public class OperationsTest {
	
	private int KEY = 1*2+1*3+1*7;
	private Operations op;
	private HashMap m;
	
	@Before
	public void setUp() throws Exception {
		op= new Operations();
	}

	@Test
	public void testUpdateMatrix() {
		//Operations op= new Operations();
		op.updateMatrix(1, 1, 1, 5, 0);
		m= op.getMatrix();
		assertEquals(true,m.containsKey(""+KEY));
		
	}
	@Test
	public void testUpdateMatrixSize_1() {
		//Operations op= new Operations();
		op.updateMatrix(1, 1, 1, 5, 0);
		op.updateMatrix(1, 1, 1, 5, 1);
		m= op.getMatrix();
		assertEquals(1,m.size());
		
	}
	@Test
	public void testUpdateMatrixSize_2() {
		//Operations op= new Operations();
		op.updateMatrix(1, 1, 1, 5, 0);
		op.updateMatrix(1, 1, 1, 5, 0);
		m= op.getMatrix();
		assertEquals(1,m.size());
		
	}
	
	@Test
	public void testUpdateMatrixSize_3() {
		//Operations op= new Operations();
		op.updateMatrix(1, 1, 1, 5, 1);
		op.updateMatrix(1, 2, 1, 5, 1);
		m= op.getMatrix();
		assertEquals(2,m.size());
		
	}

	@Test
	public void testQueryMatrix_1() {
		op.updateMatrix(1, 1, 1, 5, 1);
		op.updateMatrix(1, 1, 2, 5, 1);
		assertEquals(10,op.queryMatrix(1, 1, 1, 2, 2, 2, 1));
		assertEquals(0,op.queryMatrix(1, 1, 1, 2, 2, 2, 0));
		assertEquals(0,op.queryMatrix(3, 3, 3, 2, 2, 2, 0));
		assertEquals(0,op.queryMatrix(3, 3, 3, 4, 4, 4, 0));
	}

	@Test
	public void testGetMatrix() {
		//Operations op= new Operations();
		assertEquals(op.getMatrix().isEmpty(), true);
		op.updateMatrix(-1, -1, -1, 5, 0);
		assertEquals(op.getMatrix().isEmpty(), true);
		
	}

	@Test
	public void testSetMatrix() {
		//Operations op= new Operations();
		op.updateMatrix(1, 1, 1, 5, 0);
		assertEquals(op.getMatrix().isEmpty(), false);
	}

}
