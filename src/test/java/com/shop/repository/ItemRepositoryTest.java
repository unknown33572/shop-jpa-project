package com.shop.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.entity.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties") // 테스트용 properties 파일을 사용
class ItemRepositoryTest {
  @Autowired // 스프링 컨테이너에 등록된 Bean을 주입
  ItemRepository itemRepository;

  @PersistenceContext
  EntityManager em;

  @Test
  @DisplayName("상품 저장 테스트")
  public void createItemList() {
    for(int i = 1; i <= 10; i++) {
      Item item = new Item();
      item.setItemNm("테스트 상품" + i);
      item.setPrice(10000 + i);
      item.setItemDetail("테스트 상품 상세 설명" + i);
      item.setItemSellStatus(ItemSellStatus.SELL);
      item.setStockNumber("100");
      item.setRegTime(LocalDateTime.now());
      item.setUpdateTime(LocalDateTime.now());
      Item saveItem = itemRepository.save(item);
    }
  }

  @Test
  @DisplayName("상품 조회 테스트")
  public void findByItemNmTest() {
    this.createItemList();
    List<Item> itemList = itemRepository.findByItemNm("테스트 상품2");
    for(Item item : itemList) {
      System.out.println(item.toString());
    }
  }

  @Test
  @DisplayName("@Query를 사용한 상품 조회 테스트")
  public void findByItemDetailTest() {
    this.createItemList();
    List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");
    for(Item item : itemList) {
      System.out.println(item.toString());
    }
  }

}