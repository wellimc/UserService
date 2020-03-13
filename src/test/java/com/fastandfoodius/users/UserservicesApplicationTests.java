package com.fastandfoodius.users;

import com.fastandfoodius.users.model.UserBean;
import com.fastandfoodius.users.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserservicesApplicationTests {

	@Autowired
	UserRepository userRepository;


	@Test
	public void testFind() throws Exception {
		UserBean user = userRepository.findById(1).orElse(null);
		assertEquals("Fabiane", user.getFirstName());
	}

	@Test
	public void testFindAll() throws Exception {
		List<UserBean> users = userRepository.findAll();
		assertNotNull(users);
	}

	@Test
	public void testFinByEmail() throws Exception {
		UserBean user = userRepository.findByEmailAddress("admin@fastfood.com");
		assertNotNull(user);
		assertEquals("admin@fastfood.com",user.getEmail());
	}

	@Test
	public void testCreate() throws Exception {
		UserBean user = createUser();
		userRepository.saveAndFlush(user);
		UserBean userCreated =  userRepository.findById(user.getId()).orElse(null);
		assertEquals("Wellington",userCreated.getFirstName());

	}

	@Test
	public void testUpdate() throws Exception {
		UserBean user = userRepository.findById(1).orElse(null);
		user.setFirstName("Fabiane");
		userRepository.saveAndFlush(user);

		UserBean userCreated =  userRepository.findById(user.getId()).orElse(null);
		assertEquals("Fabiane",userCreated.getFirstName());

	}

	@Test
	public void testDelete() throws Exception {
		UserBean user = userRepository.findByEmailAddress("wellimc@gmail.com");
		userRepository.delete(user);

		UserBean userDeleted =  userRepository.findById(user.getId()).orElse(null);
		assertNull(userDeleted);

	}

	private UserBean createUser(){
		UserBean user = new UserBean();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = "1981-04-27";
		Date date = null;
		try {
			date = dt.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setFirstName("Wellington");
		user.setLastName("Cavalcanti");
		user.setDateOfBirth(date);
		user.setGender("M");
		user.setTitle("customer");
		user.setPhone("1111111");
		user.setAddress("17 Cloghanboy");
		user.setCity("Athlone");
		user.setPostalCode("04417-110");
		user.setEmail("wellimc@gmail.com");
		return user;
	}
}
