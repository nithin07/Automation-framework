package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class FetchJsonData {

	public String fetchData(String file_path, String param_name) throws ParseException, FileNotFoundException, IOException	{
//	public static void main(String[] args) throws Exception 	{	
		Object obj = new JSONParser().parse(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"/resources/TestData.json")));
		JSONObject jsonObj = (JSONObject) obj;
		
		return jsonObj.get(param_name).toString();

	}
}
