package stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.core.resource.Resource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.payloadconvertor;

public class stepdefinition {
	RequestSpecification requestspecification;
	public String Loginpayload;
	Response response;
	JsonPath jsonpath;
String BaseURI = "https://ecommerceservice.herokuapp.com";
ObjectMapper objectmapper;
	
	@Given("Login API")
	public void login_api() throws IOException {
	 Loginpayload = payloadconvertor.generatepayloadstring("Login.json");
	 System.out.println(Loginpayload);
	    
	}
	@When("Login executes {string} and provide accesstoken")
	public void login_gets_executed_and_provide_accesstoken(String resourcepath) {
	    requestspecification = RestAssured.given().body(Loginpayload);
	    requestspecification.contentType(ContentType.JSON);
	    response = requestspecification.post(BaseURI + resourcepath);
	    
	}
	@Then("successfully executed with status code {int}")
	public void successfully_executed_with_status_code(int  statuscode) {
	    
	   Assert.assertEquals(statuscode, response.getStatusCode());
	}
	@Then("verify Login message")
	public void verify_login_message() {
	    
	   jsonpath = new JsonPath(response.getBody().asString());
	   String accesstoken = jsonpath.get("accessToken");
	   System.out.println(accesstoken);
	}

}
