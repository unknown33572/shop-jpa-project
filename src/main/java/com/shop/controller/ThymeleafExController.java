package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {
  @GetMapping(value = "/ex02")
  public String thymeleafExample02(Model model) { // Model 객체를 파라미터로 받음
    ItemDto itemDto = new ItemDto();
    itemDto.setItemDetail("상품 상세 설명");
    itemDto.setItemNm("테스트 상품1");
    itemDto.setPrice(10000);
    itemDto.setRegTime(String.valueOf(LocalDateTime.now()));

    model.addAttribute("itemDto", itemDto); // Model 객체에 itemDto를 저장
    return "thymeleafEx/thymeleafEx02"; // 뷰 페이지 경로를 리턴
  }

  @GetMapping(value = "/ex03")
  public String thymeleafExample03(Model model) {
    List<ItemDto> itemDtoList = new ArrayList<>();

    for(int i = 1; i <= 10; i++) {
      ItemDto itemDto = new ItemDto();
      itemDto.setItemDetail("상품 상세 설명" + i);
      itemDto.setItemNm("테스트 상품" + i);
      itemDto.setPrice(10000 + i);
      itemDto.setRegTime(String.valueOf(LocalDateTime.now()));
      itemDtoList.add(itemDto);
    }

    model.addAttribute("itemDtoList", itemDtoList);
    return "thymeleafEx/thymeleafEx03";
  }
}
