package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity // DB 테이블과 매핑되는 객체임을 명시
@Table(name = "item") // DB 테이블 이름
@Getter
@Setter
@ToString
public class Item {
  @Id // PK임을 명시
  @Column(name = "item_id") // DB 컬럼 이름
  @GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성 전략을 명시
  private Long id;

  @Column(nullable = false, length = 50)
  private String itemNm;

  @Column(name = "price", nullable = false)
  private int price;

  @Column(nullable = false)
  private String stockNumber;

  @Lob // 대용량 데이터를 저장할 때 사용
  @Column(nullable = false)
  private String itemDetail;

  @Enumerated(EnumType.STRING) // Enum 타입 매핑을 명시
  private ItemSellStatus itemSellStatus; // 상수 패키지에 있는 ItemSellStatus 클래스를 사용

  private LocalDateTime regTime;

  private LocalDateTime updateTime;
}
