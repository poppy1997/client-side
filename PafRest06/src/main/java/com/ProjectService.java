package com;
import model.Project;


//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Project")
public class ProjectService {
	Project itemObj = new Project();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems()
	{
		return itemObj.readItems();
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("projectName") String itemCode,
						@FormParam("projectType") String itemName,
						@FormParam("projectPrice") String itemPrice,
						@FormParam("projectDescription") String itemDesc)
	{
			String output = itemObj.insertItem(itemCode, itemName, itemPrice, itemDesc);
			return output;
	}

	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData)
	{
		//Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		//Read the values from the JSON object
		String itemID = itemObject.get("projectID").getAsString();
		String itemCode = itemObject.get("projectName").getAsString();
		String itemName = itemObject.get("projectType").getAsString();
		String itemPrice = itemObject.get("projectPrice").getAsString();
		String itemDesc = itemObject.get("projectDescription").getAsString();
		String output = itemObj.updateItem(itemID, itemCode, itemName, itemPrice, itemDesc);
		return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String itemID = doc.select("projectID").text();
	 String output = itemObj.deleteItem(itemID);
	return output;
	}
}
