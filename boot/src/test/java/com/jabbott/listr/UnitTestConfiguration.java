package com.jabbott.listr;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.jabbott.listr.repository.CategoryRepository;
import com.jabbott.listr.repository.ItemRepository;
import com.jabbott.listr.repository.ListRepository;
import com.jabbott.listr.repository.UserRepository;
import com.jabbott.listr.service.CategoryService;
import com.jabbott.listr.service.ItemService;
import com.jabbott.listr.service.ListService;
import com.jabbott.listr.service.UserService;

@Profile("test")
@TestConfiguration
public class UnitTestConfiguration {
	
	@Bean
	@Primary
	public UserRepository userRepositoryTest() {
		return Mockito.mock(UserRepository.class);
	}
	
	@Bean
	@Primary
	public ListRepository listRepositoryTest() {
		return Mockito.mock(ListRepository.class);
	}
	
	@Bean
	@Primary
	public CategoryRepository categoryRepositoryTest() {
		return Mockito.mock(CategoryRepository.class);
	}
	
	
	@Bean
	@Primary
	public ItemRepository itemRepositoryTest() {
		return Mockito.mock(ItemRepository.class);
	}

}
