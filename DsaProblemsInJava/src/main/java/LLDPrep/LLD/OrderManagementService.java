package LLDPrep.LLD;

import java.util.ArrayList;
import java.util.List;

public class OrderManagementService {
    private static OrderManagementService orderManagementService = null;

    List<Order> orderList = new ArrayList<>();
    private OrderManagementService(){

    }

    public static OrderManagementService getInstance() {
        if(orderManagementService==null){
            orderManagementService = new OrderManagementService();
        }
        return orderManagementService;
    }
    public void makePayment(PaymentType paymentType,Item item){
        // updates the payment and adds order
    }
    public Order getOrderForAgent(DelivaryAgent delivaryAgent){
        return orderManagementService.getOrderForAgent(delivaryAgent);
    }

    public void updateOrderStatus(OrderStatus newOrderStatus, String orderId) {

    }
}
