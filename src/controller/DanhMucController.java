package controller;

import model.service.DanhMucService;

public class DanhMucController {

  private final DanhMucService danhMucService;

  public DanhMucController(DanhMucService danhMucService) {
    this.danhMucService = danhMucService;
  }

  //method all danh muc
  public void findAllDanhMuc() {
  }
}
