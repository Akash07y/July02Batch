package testPack;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite TestNGClass 1");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test TestNGClass 1");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class TestNGClass 1");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method TestNGClass 1");
	}
	
	@Test () 
	public void test3() {
		System.out.println("test 3 TestNGClass 1");
	
	}
	
	@Test
	public void test4() {
		System.out.println("test 4 TestNGClass 1");
		}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method TestNGClass 1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class TestNGClass 1");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test TestNGClass 1");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite TestNGClass 1");
	}
}
