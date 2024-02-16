package automation.EcommerceApiTest;

import java.util.List;

public class Orders {
  public List<OrderDetail> order;

  public List<OrderDetail> getOrder() {
    return order;
  }

  public void setOrder(List<OrderDetail> order) {
    this.order = order;
  }
}
