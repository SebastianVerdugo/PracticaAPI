package PracticaAPI;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



import java.util.List;


public class JsonHelper {
	
	 public Personaje[] convertJsonAPersonajes(String json)
	 {
	        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
	        JsonElement results = jsonObject.get("results");
	        return new Gson().fromJson(results, Personaje[].class);
	  }
}
