package com.jabbott.listr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jabbott.listr.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findCategoriesByCategoryListId(Long id);

}