package com.app.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

//@Data //for getters and setters
public class PageResponse extends OperationResponse {
  @Getter
  @Setter
  private boolean first;
  @Getter
  @Setter
  private boolean last;
  @Getter
  @Setter
  private int currentPageNumber;
  @Getter
  @Setter
  private int itemsInPage;
  @Getter
  @Setter
  private int pageSize;
  @Getter
  @Setter
  private int totalPages;
  @Getter
  @Setter
  private long totalItems;
  @Getter
  @Setter
  private Sort sort;
  private List items;

  public void setPageStats(Page pg, boolean setDefaultMessage, boolean isDefault) {
    this.first = pg.isFirst();
    this.last = pg.isLast();
    this.currentPageNumber = pg.getNumber();
    this.itemsInPage = pg.getNumberOfElements();
    this.pageSize = pg.getSize();
    this.totalPages = pg.getTotalPages();
    this.totalItems = pg.getTotalElements();
    //this.items             = pg.getContent();
    this.sort = pg.getSort();
    if (isDefault) {
      this.sort = null;
    }
    if (setDefaultMessage == true) {
      this.setOperationStatus(ResponseStatusEnum.SUCCESS);
      this.setOperationMessage("Page " + (pg.getNumber() + 1) + " of " + pg.getTotalPages());
    }
  }

  public void setPageTotal(int count, boolean setDefaultMessage) {
    //this.items             = list;
    this.first = true;
    this.last = true;
    this.itemsInPage = count;
    this.totalItems = count;
    this.totalPages = 1;
    this.pageSize = count;
    if (setDefaultMessage == true) {
      this.setOperationStatus(ResponseStatusEnum.SUCCESS);
      this.setOperationMessage("Total " + count + " items ");
    }
  }

}
