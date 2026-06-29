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

import api.endpoints.UserEndPointViaPropertiesFile;
import api.endpoints.UserEndPoints;
import api.payload.User;

import java.util.Map;

import io.restassured.response.Response;

public class UserTestViaProperties {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setUpData() {
		
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUserName(faker.name().username());
		userpayload.setPhone(faker.name().username());	
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		}
		
	
	@Test(priority=1)
public void testPostUser() {
	
	Response response = UserEndPointViaPropertiesFile.createUser(userpayload);
	
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
	}
@Test(priority=2)
	public void getUserByName() {
		Response response = UserEndPointViaPropertiesFile.readUser(this.userpayload.getUserName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
@Test(priority=3)
public void updateUserByName() {
	
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	userpayload.setEmail(faker.internet().safeEmailAddress());
Response response = UserEndPoints.updateUser(this.userpayload.getUserName(), userpayload);
response.then().log().all();
Assert.assertEquals(response.getStatusCode(), 200);

//checking data after response

Response responseafterupdate = UserEndPointViaPropertiesFile.updateUser(this.userpayload.getUserName(), userpayload);
response.then().log().all();
Assert.assertEquals(response.getStatusCode(),200);


}
@Test(priority=4)
public void  deleteUserByName() {
	
	
Response response = UserEndPointViaPropertiesFile.deleteeUser(this.userpayload.getUserName());
response.then().log().all();
Assert.assertEquals(response.getStatusCode(), 200);
}











}