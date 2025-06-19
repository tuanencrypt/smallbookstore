package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReceiptBookListEntity;
import com.example.demo.entity.keycompose.ReceiptBookListId;

@Repository
public interface ReceiptBookListRepository extends JpaRepository<ReceiptBookListEntity, ReceiptBookListId> {

}
