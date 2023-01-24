package com.jabbott.listr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jabbott.listr.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findItemsByCategoryId(Long categoryId);

}