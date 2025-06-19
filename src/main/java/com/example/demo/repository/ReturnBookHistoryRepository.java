package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReturnBookHistoryEntity;
import com.example.demo.entity.keycompose.ReturnBookHistoryId;

@Repository
public interface ReturnBookHistoryRepository extends JpaRepository<ReturnBookHistoryEntity, ReturnBookHistoryId> {

}
