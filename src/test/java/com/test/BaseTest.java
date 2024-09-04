package com.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
}
