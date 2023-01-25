package com.jabbott.listr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jabbott.listr.model.List;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {

	java.util.List<List> findListsByListUserId(Long userId);

}