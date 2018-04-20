package abook.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import abook.pojo.User;

public class ABServiceTest {
	
	private ABService aBService;
	
	@Before
	public void init(){
		aBService= new ABService();
	}
	
	@Test
	public void test_case_for_authanticateUser_method_if_correct_Return_User_object() {
		
		assertArrayEquals(aBService.authanticateUser("ab", "a"), User.class);
	}

}
