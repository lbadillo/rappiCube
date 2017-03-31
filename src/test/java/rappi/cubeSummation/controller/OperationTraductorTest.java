package rappi.cubeSummation.controller;

import static org.junit.Assert.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;



public class OperationTraductorTest {
	private OperationTraductor op;

	@Before
	public void setUp() throws Exception {
		op = new OperationTraductor();
	}

	@Test
	public void getIntValue() {
		assertEquals(24, op.getIntValue("24"));
		assertEquals(0, op.getIntValue(""));
		assertNotSame(0, op.getIntValue("pedro"));
	}

	@Test
	public void getResult() {
		
		
		String line = new String();
		String line2 = new String();
		try {
			File f = new File("src/test/resources/data.txt");
			FileInputStream fstream = new FileInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				line = line + strLine + System.getProperty("line.separator");
			}
			br.close();
			f = new File("src/test/resources/res.txt");
			fstream = new FileInputStream(f);
			br = new BufferedReader(new InputStreamReader(fstream));
			strLine = new String();
			while ((strLine = br.readLine()) != null) {
				line2 = line2 + strLine + System.getProperty("line.separator");
			}
			br.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		assertEquals(op.getResult(line), line2);
		
		
		

	}

}
