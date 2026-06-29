package api.test;
import static io.restassured.RestAssured.given;

import  io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import api.endpoints.UserEndPoints;
import api.payload.User;

import io.restassured.response.Response;
import api.utilities.DataProviders;


public class DataDrivenTests {
	//creating multiple users
	@Test(priority=1,dataProvider="UserData",dataProviderClass=DataProviders.class)
	
	public void testPostUser(String UserID,StringuserName,Stringfname,Stringlname,Stringuseremail,Stringpwd,Stringph) 
	{
		 User userPayload=new User();
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUserName(username); 
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		 
		 Response response=UserEndPoints.createUser(userPayload);
		 Assert.assertEquals(response.getStatusCode(),200); 
		
		
	}
@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName) {
	
	//deleting users which got created
	
	Response response = UserEndPoints.deleteeUser(userName);
	Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
