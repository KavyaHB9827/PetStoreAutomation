package api.test;
import static io.restassured.RestAssured.given;

import  io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.endpoints.UserEndPoints;
import api.payload.User;

import java.util.Map;

import io.restassured.response.Response;
public class UserTest {
	
	Faker faker;
	User userPayload;
	@BeforeClass
	public void setupData() {
		
		faker= new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUserName(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	
	
	@Test(priority=1)
		public void testPostUser() {
		
		Response response = UserEndPoints.createUser(userPayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(),200);
		} 
	@Test(priority=2)
	public void testGetUserByName() {
		Response response = UserEndPoints.readUser(this.userPayload.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=3)
	public void testUpdateUserByName() {
		//update data using payload
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUserName(), userPayload);
		
		response.then().log().body();// chai assertion
		
		Assert.assertEquals(response.getStatusCode(), 200);//testng assertion both are same
		
		//checking data after update
		Response responseafterupate = UserEndPoints.readUser(this.userPayload.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200); 
		
	}
	@Test(priority=4)
	public void deleteUser() {
		
		Response response = UserEndPoints.deleteeUser(this.userPayload.getUserName());
		Assert.assertEquals(response.getStatusCode(), 200);
 	}
	
	
		
		
	}


