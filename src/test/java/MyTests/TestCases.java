package MyTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases {
	
	//Soft Assert vs Hard Assert in TestNG:
	//Hard assertion : Hard validation : if a hard assertion is getting failed --> immediately test case will be marked as failed and test case will be terminated
	//soft assertion : soft validation : if a soft assertion is getting failed --> immediately test case will  be marked as passed as well as next lines will be executed
	//asserAll() : to mark the test case as failed, if any softAssertion is getting failed
	
	
	
	@Test
	public void test1(){
		
		SoftAssert softAssert1 = new SoftAssert();
		System.out.println("Open Browser");
		
		Assert.assertEquals(true, true); 
		//Hard assertions: if any particular assertion is getting failed
		//immediately after that all the corresponding lines in that particular test cases
		// will not be executed . immediately test case will be terminated
		// and the test case will be marked as failed
		 
		System.out.println("Enter username");
		System.out.println("Enter password");
		System.out.println("Click on sign in button");
		
		Assert.assertEquals(true, true); 
		
		
		System.out.println("Validate Home page");
		//if home title is missinh then it is fine .so this is not right place for hard asserion
		softAssert1.assertEquals(true, false, "Home page title is missing"); //1 if it is getting failed also it will execute next lines 
		//and mark the test case as true. To solve this we shd use softAssert.assertAll();
		
		System.out.println("go to deals page");
		System.out.println("Create a deal");
		softAssert1.assertEquals(true, false, "Not able to create a deal"); //2
		
		System.out.println("go to contacts page");
		System.out.println("Create a contact");
		softAssert1.assertEquals(true, false, "Not able to create a deal"); // 3
		// 1, 2 , 3 will be stored in softaseert object
		
		softAssert1.assertAll();
		//it will check(aseert) the softassert object and then it will check how many errors are there
		// then it mark the test case as failed
		//if you have 100 test cases better to write softAssert.assertAll(); immediately after that
		// dont write in @afterClass then tear
		
	}
	
	@Test
	public void test2() {
		SoftAssert softAssert2 = new SoftAssert();
		System.out.println("logout");
		softAssert2.assertEquals(true, false);
		// without assertAll() it will mark thetest case as pass
		
		softAssert2.assertAll();
		//if you declare softassert as global var. then in test2 also we will all the errors of test1
	}
	
	@AfterClass
	
	public void tearDown() {
		
	}
	

}
