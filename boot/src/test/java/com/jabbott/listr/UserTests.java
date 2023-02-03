package com.jabbott.listr;

import java.util.Optional;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jabbott.listr.dto.NewUserDto;
import com.jabbott.listr.model.User;
import com.jabbott.listr.repository.UserRepository;
import com.jabbott.listr.service.UserService;

@ActiveProfiles("test")
@SpringBootTest(classes = {UserService.class, UnitTestConfiguration.class})
public class UserTests extends AbstractTestNGSpringContextTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@BeforeClass
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	// Positive Tests
	
	@Test
	public void retrieveUserInformation() {		
		NewUserDto dto = new NewUserDto();
		dto.setEmail("test");
		dto.setFirstName("John");
		dto.setLastName("Smith");
		dto.setPassword("test");
		
		User newUser = new User();
		newUser.setEmail(dto.getEmail());
		newUser.setFirstName(dto.getFirstName());
		newUser.setLastName(dto.getLastName());
		newUser.setPassword(dto.getPasswordHash());
		
		Optional<User> newUserOptional = Optional.of(newUser);
		
		Mockito.when(userRepository.findByEmail("test")).thenReturn(newUserOptional);
			
		User testUser = userService.getUserByEmail("test");
		
		Assert.assertEquals(testUser.getEmail().compareTo(newUser.getEmail()), 0);
		Assert.assertEquals(testUser.getFirstName().compareTo(newUser.getFirstName()), 0);
		Assert.assertEquals(testUser.getLastName().compareTo(newUser.getLastName()), 0);
		Assert.assertEquals(testUser.getPassword().compareTo(newUser.getPassword()), 0);
	}
	
	
	@Test
	public void createNewUser() {
		
		User newUser = new User();
		newUser.setEmail("test");
		newUser.setFirstName("John");
		newUser.setLastName("Smith");
		newUser.setPassword("test");
		
		NewUserDto newUserDto = new NewUserDto();
		newUserDto.setEmail("test");
		newUserDto.setFirstName("John");
		newUserDto.setLastName("Smith");
		newUserDto.setPassword("test");
		
		Mockito.when(userRepository.save(newUser)).thenReturn(newUser);
		
		User newUserDetails = userService.createUser(newUserDto);
		
		Assert.assertEquals(newUserDetails.getEmail().compareTo(newUser.getEmail()), 0);
		Assert.assertEquals(newUserDetails.getFirstName().compareTo(newUser.getFirstName()), 0);
		Assert.assertEquals(newUserDetails.getLastName().compareTo(newUser.getLastName()), 0);
		Assert.assertEquals(newUserDetails.getPassword().compareTo(newUser.getPassword()), 0);
	}
	
	//Negative Tests
	
	@Test
	public void retrieveUserInformationDoesNotExist() {
		
		Optional<User> nullOptional = Optional.empty();
		
		Mockito.when(userRepository.findByEmail("test")).thenReturn(nullOptional);
		
		User userDetails = userService.getUserByEmail("test");
		
		Assert.assertEquals(userDetails, null);
	}
	
	
}
