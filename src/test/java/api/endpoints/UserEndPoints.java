package api.endpoints;


import static io.restassured.RestAssured.given;

import  io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import api.payload.User;

import io.restassured.response.Response;




import io.restassured.response.Response;
//userendpoints.java
//Created to perform CRUD OPERATIONS

public class UserEndPoints {
	
	public static Response createUser(User payload) {//userpayload(user.java) not been develeoped yet (getters and setters)
		
		Response response = given()
		 
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);
		return response;
		
	}
	
public static Response readUser(String userName) {
		
		Response response = given()
				.pathParam("username", userName)//userName must get from testcase as a path parametr value
	
		
		.when()
		.get(Routes.get_url);
		return response;
		
	}
public static Response updateUser(String userName,User payload) {
	
	Response response = given()
	
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
	
	.when()
	.put(Routes.put_url);
	return response;
	
}

public static Response deleteeUser(String userName) {
	
	Response response = given()
			.pathParam("userName", userName)
	
	
	
	.when()
	.delete(Routes.delete_url);
	return response;
	
}


	
	
	
		
		
		
		
		
		
	
	
 
}
  