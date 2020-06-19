package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountsRepository extends JpaRepository<Discounts, Long> {

   // @Query(value = "SELECT discount FROM DISCOUNTS where item_id = ?1", nativeQuery = true)
    Optional<Discounts> findDistinctByItem_Id(Long itemId);
}
