package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReceiptEntity;

@Repository
public interface ReceiptRepository extends JpaRepository<ReceiptEntity, Integer> {
	
	@Query("SELECT r FROM ReceiptEntity r LEFT JOIN FETCH r.user u")
	List<ReceiptEntity> findAllEntitiesWithUserEntity();
}
