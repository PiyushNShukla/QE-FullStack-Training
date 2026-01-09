package com.ibm.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.containsString;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PetTests {
  @Test
  public void getPetsByStatus() {
	  RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
	  .header("Content-Type","application/json")
	  .queryParam("status","available")
	  .when().get("/findByStatus")
	  .then().statusCode(200)
	  .body("status",everyItem(equalTo("available")));
  }
  
  @Test(dependsOnMethods = "addPetInfo")
  public void getPetById() {
	  RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
	  .pathParam("petId",101)
	  .when().get("/{petId}")
	  .then().log().all().statusCode(200).body("id", equalTo(101));
  }
  
  @Test
  public void addPetInfo() {
	  File petInfo=new File("src/test/resources/pet.json");
	  
	  RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
	  .header("Content-Type","application/json")
	  .body(petInfo)
	  .log().all()
	  .when().post()
	  .then().log().all().statusCode(200)
	  .body("id",equalTo(101));
  }
  
  @Test(dependsOnMethods = "addPetInfo")
  public void updatePetInfo() {
	  Map<String, Object> category = new HashMap<>();
	  category.put("id", 1);
	  category.put("name", "dog");

	  Map<String, Object> body = new HashMap<>();
	  body.put("id", 101);
	  body.put("category", category);
	  body.put("name", "Bruno");
	  body.put("photoUrls", List.of("Bruno"));
	  body.put("status", "available");
	  
	  RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
	  .header("Content-Type","application/json")
	  .body(body).log().all()
	  
	  .when().put()
	  .then().statusCode(200).body("category.name", equalTo("dog"))
	  .body("name",equalTo("Bruno"));
  }
  
  @Test(dependsOnMethods = "addPetInfo")
  public void updatePetByFormData() {
	  RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
	  .header("Content-Type","application/x-www-form-urlencoded")
	  .pathParam("petId", 101)
	  .formParam("name", "Charlie")
	  .formParam("status", "sold")
	  .log().all()
	  .when().post("/{petId}")
	  .then().statusCode(200).body("message", equalTo("101"));
	  
  }
  
  @Test(dependsOnMethods = "addPetInfo")
  public void uploadPetImage() {
	  File image=new File("src/test/resources/cat_img.jpg");
	  RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
	  .header("Content-Type"," multipart/form-data")
	  .pathParam("petId",101)
	  .formParam("additionalMetadata","This is a Cat image")
	  .multiPart("file",image,"image/jpeg")
	  
	  .when().post("/{petId}/uploadImage")
	  .then().statusCode(200)
	  .body("message", containsString("File uploaded"));
  }
  
  @Test(dependsOnMethods = "getPetById")
  public void deletePetInfo() {
	  RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
	  .header("api_key","12345")
	  .pathParam("petId", 101)
	  .when().delete("/{petId}")
	  .then().statusCode(200)
	  .body("message",equalTo("101"));
  }
  
 
}



