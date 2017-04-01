package rappi.cubeSummation.controller;
import java.util.List;


public class OperationTraductor {
	public String getResult (String input){
		String[] in=input.split("\\n+");
		Operations op= new Operations();
		String result= new String();
		int testCases=0;
		int dimension=0;
		int operations=0;
		int siga=0;
		for (String p: in){
			if (p.startsWith("UPDATE")){
				String[] in3=p.split("\\s+");
				op.updateMatrix(
						getIntValue(in3[1]),
						getIntValue(in3[2]), 
						getIntValue(in3[3]),
						getIntValue(in3[4]), 
						siga);
				siga=1;
				
			}
			else if(p.startsWith("QUERY")){
				String[] in3=p.split("\\s+");
				int res=op.queryMatrix(
						getIntValue(in3[1]), 
						getIntValue(in3[2]), 
						getIntValue(in3[3]),
						getIntValue(in3[4]),
						getIntValue(in3[5]),
						getIntValue(in3[6]),
						siga);
				siga=1;
				result=result+res+System.getProperty("line.separator");
			}
			else if (p.contains(" ")){
				String[] in2=p.split("\\s+");
				dimension=getIntValue(in2[0]);
				operations=getIntValue(in2[1]);
				siga=0;
			}
			else {
				testCases=getIntValue(p.trim());
			    
			}
		}
		
		return result; 
		
	}
	
	public int getIntValue (String value){
		int ret=0;
		char[] charArray = value.toCharArray();
	    for (char c: charArray){
	       ret=ret*10+Character.getNumericValue(c);
	       
	     }
	    return ret;
		
	}

}
