package cmpe281.billing;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

@Path("/getDetails")
public class GetUserDetails {

	@GET
	@Path("/{endpoint}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnBrand(@PathParam("endpoint") String endpoint) throws Exception {

		JSONObject jsonObject = new JSONObject();
		
		String returnString = null;
		String userId = "";
		String sensorId = "";
		String instanceId = "";	
		String start_date = "";
		String end_date = "";
		int rate = 2;
		long amount = 0;
		long diffHours = 0;

		JSONArray json = new JSONArray();

		try {
			if (endpoint.equals("user1")) {
				userId = "user1";
				sensorId = "sensor_101";
				instanceId = "instance_11";
				start_date = "11/15/2015 09:29:58";
				end_date = "11/16/2015 10:31:48";
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = format.parse(start_date);
					d2 = format.parse(end_date);

					// in milliseconds
					long diff = d2.getTime() - d1.getTime();
					diffHours = diff / 3600000;

					System.out.print(diffHours + " hours, ");
					
					amount = (rate * diff)/3600000;

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (endpoint.equals("user2")) {
				
				userId = "user2";
				sensorId = "sensor_101";
				instanceId = "instance_22";
				start_date = "11/16/2015 09:29:58";
				end_date = "11/16/2015 11:31:48";
				rate = 2;
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = format.parse(start_date);
					d2 = format.parse(end_date);

					long diff = d2.getTime() - d1.getTime();
					diffHours = diff / 3600000;

					System.out.print(diffHours + " hours, ");
					
					amount = (rate * diff)/3600000;

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				returnString = "User Not found.";
				return Response.ok(returnString).build();	
			}
			
			jsonObject.put("user_id", userId);
			jsonObject.put("sensor_id", sensorId);
			jsonObject.put("instance_id", instanceId);
			jsonObject.put("start_date", start_date);
			jsonObject.put("end_date", end_date);
			jsonObject.put("hours_used", diffHours);
			jsonObject.put("rate", rate);
			jsonObject.put("amount", amount);
			
			json.put(jsonObject);
			returnString = json.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		return Response.ok(returnString).build();
	}

}
