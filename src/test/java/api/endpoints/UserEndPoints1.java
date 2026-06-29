package api.endpoints;
import static io.restassured.RestAssured.given;

import  io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import api.payload.User;

import io.restassured.response.Response;




import io.restassured.response.Response;
//we must perfor crud operations
public class UserEndPoints1 {
	
	public static Response createUser(User payload) {
	Response response = given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
	.post(Routes1.post_url);
	
	return response;
		
	}
	
	public static Response readUser(String userName) {
		Response response = given()
				.pathParam("username", "userName")
		.when()
		.get(Routes1.get_url);
		
		
	return response;
	
		
	}
	
	public static Response updateUser(String userName,User payload) {
		
	Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.put(Routes1.post_url);
		
		return response;
		
	}
	
	public static Response deleteUser(String userName) {
		
		Response response = given()
		.pathParam("username", "userName")
		
		.when()
		.get(Routes1.delete_url);
		return response;
		
		
	}
	
	
	

}
