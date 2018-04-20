package abook.service;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import abook.pojo.Friend;
import abook.pojo.User;

public class ABServiceTest {
	
	private ABService aBService;
	
	@Before
	public void init(){
		aBService= new ABService();
	}
	
	@Test
	public void test_case_for_authanticateUser_method_if_correct_Return_User_object() throws Exception {
		User user=aBService.authanticateUser("a", "a");
		assertEquals(user.getClass(), User.class);
	}
	
	@Test(expected=Exception.class)
	public void test_case_for_authanticateUser_method_if_incorrect_throw_Exception() throws Exception {
		User user=aBService.authanticateUser("ab", "a");
		assertEquals(user.getClass(), User.class);
	}
	
	@Test(expected=Exception.class)
	public void test_case_for_registerUser_method_if_register_Failed_throw_exception(){
		User user=null;
		aBService.registerUser(user);
	}
	
	@Test
	public void test_case_for_getAllFriends_method_if_any_return_vector_object() throws Exception{
		Vector<Vector> data=aBService.getAllFriends(1);
		assertEquals(data.getClass(), new Vector<Vector>().getClass());
	}
	

	@Test(expected=Exception.class)
	public void test_case_for_saveNewFriend_method_if_Failed_throw_exception(){
		Friend friend=null;
		aBService.saveNewFriend(friend);
	}
	
	@Test
	public void test_case_for_getFriendById_method_if_found_return_friend_object() throws Exception{
		
	}
	
	@Test
	public void test_case_for_getFriendById_method_if_found_return_null() throws Exception{
		Friend friend=aBService.getFriendById(2);
		assertEquals(friend, null);
	}
}
