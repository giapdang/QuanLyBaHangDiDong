package model.response;

public class Item {
  private int id;
  private String name;

  public Item(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  // JComboBox sẽ sử dụng phương thức này để hiển thị tên
  @Override
  public String toString() {
    return name;
  }
}
