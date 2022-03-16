package com.smallgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.smallgroup.user.bo.UserBO;
import com.smallgroup.user.model.User;

@SpringBootTest
public class BookingTest {

	@Autowired
	//BookingBO bookingBO;
	
	// @Test
	void test1() {
		assertEquals(3 * 5, 15); // 파라미터 둘이 같으냐? // 수행은 디버스 모드로 수행(junit test)
		
		int a = 10;
		assertTrue(a < 100); 
	}
	
	@Test
	void test2() {
		//List<User> userList = bookingBO.getBookingList();
		//assertNotNull(userList);
	}
	@Transactional
	@Test
	void test3() {
	//int rowCount = 	bookingBO.addBooking("신보람0315","2022-03-15",5,3,"010-1111-3355");
	//assertEquals(1,rowCount);
	
	}
}
