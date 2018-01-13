package com.guitar.endpoint;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.guitar.Main;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public class ManufacturesEndpointTest {

	private static final String ENDPOINT = "/mfgs";

	@BeforeClass
	public static void before() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/api";
	}

	@Test
	public void testListAllManufacturers() {
		RestAssured.given().get(ENDPOINT).then().statusCode(200).and().contentType(ContentType.JSON);
	}

	@Test
	public void testGetManufacturer() {
		RestAssured.given().get(ENDPOINT + "/1").then().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("name", Matchers.is("Fender Musical Instruments Corporation"));
	}
}
