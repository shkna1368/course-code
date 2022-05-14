package com.saba.carmanagment.dto;

import lombok.Data;

import java.util.List;
@Data
public class PagingData {

   private List data;
   private Integer currengPage;
   private Integer totalPage;
   private Long totalElement;

}
