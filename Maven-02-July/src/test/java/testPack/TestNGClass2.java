package testPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass2 {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite TestNGClass 2");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test TestNGClass 2");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class TestNGClass 2");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method TestNGClass 2");
	}
	
	@Test () 
	public void testA() {
		System.out.println("test A TestNGClass 2");
	}
	
	@Test
	public void testB() {
		System.out.println("test B TestNGClass 2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method TestNGClass 2");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class TestNGClass 2");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test TestNGClass 2");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite TestNGClass 2");
	}
}
