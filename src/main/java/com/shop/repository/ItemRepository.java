package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
  List<Item> findByItemNm(String itemNm);

  @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc") // JPQL을 사용한 쿼리
  List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}
