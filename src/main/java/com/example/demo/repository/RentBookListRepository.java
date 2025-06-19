package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RentBookListEntity;
import com.example.demo.entity.keycompose.RentBookListId;

@Repository
public interface RentBookListRepository extends JpaRepository<RentBookListEntity, RentBookListId> {

}
