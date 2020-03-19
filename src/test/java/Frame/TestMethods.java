package Frame;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;

import org.junit.Test;

public class TestMethods {

	public void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	@Test
	public String getEmployee() {

		Response resp = RestAssured.given().get();

		// Assert.assertEquals(409,resp.statusCode());
		// assertEquals(resp.statusCode(),400);
		return resp.prettyPrint();

	}



	@Test
	public void executionFile(TestData Obj) {
		
		int code,expected;
		switch(Obj.getAccion().toLowerCase()) {
			
		case "post":
			Response resp = RestAssured.given().header("content-type", "application/json").body(Obj.getBody()).post();
			validationCode(Obj.getExpected(),resp.statusCode());
			
			break;
		case "get":
			Response resp2 = RestAssured.given().header("content-type", "application/json").get();
			validationCode(Obj.getExpected(),resp2.statusCode());
			
			break;
		
		}

	}
	
	public void validationCode(int expected, int code) {
		if(expected==code) {
			System.out.println("Test Case Pass");
			System.out.println("Status code expected is "+expected);
			System.out.println("Status code is "+code);
		}else {
			System.out.println("Test Case Fail");
			System.out.println("Status code expected is "+expected);
			System.out.println("Status code is "+code);
		}
		
	}

	public String testCases(TestData Obj){
		ArrayList<String> sheets = new ArrayList<String>();
	
		String sheet="";
		
		sheet = Obj.getNameTC();
		
		
		
		return sheet;
	}
	
}
