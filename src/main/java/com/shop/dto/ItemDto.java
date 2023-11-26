package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
  private Long id;
  private String itemNm;
  private int price;
  private String stockNumber;
  private String itemDetail;
  private String itemSellStatus;
  private String regTime;
  private String updateTime;
}
