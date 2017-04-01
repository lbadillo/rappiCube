package rappi.cubeSummation.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import rappi.cubeSummation.controller.OperationTraductor;



import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
 
@Path("/summation")
public class CubeSummation {
 
	
	
	@POST
	@Consumes({MediaType.TEXT_PLAIN})
    @Produces({MediaType.TEXT_PLAIN})
	public String postMessage(String msg) throws Exception{
        
		OperationTraductor op= new OperationTraductor();
		return op.getResult(msg);
    }
	
 
}