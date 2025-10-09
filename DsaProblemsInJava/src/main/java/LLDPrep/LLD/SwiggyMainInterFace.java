package LLDPrep.LLD;

import java.util.List;

public class SwiggyMainInterFace {
    RestaurantManagementService restaurantManagementService;
    OrderManagementService orderManagementService;

    public SwiggyMainInterFace(){
       this.restaurantManagementService = RestaurantManagementService.getInstance();
       this.orderManagementService = OrderManagementService.getInstance();
    }

    public List<Restaurant> searchRestaurants(String keyword){
        return restaurantManagementService.searchRestaurant(keyword);
    }
    public List<Item> searchOrderItem(String keyword){
        return restaurantManagementService.searchMenuItem(keyword);
    }

    // Restaurant view
    public void AddMenuItem(){
        restaurantManagementService.addMenuItem();
    }
    public void removeMenuItem(){
        restaurantManagementService.removeMenuItem();
    }
    public void editMenuItem(){
        restaurantManagementService.editMenuItem();
    }

    // Payment related
    public void makeOrder(PaymentType paymentType, Item item){
        orderManagementService.makePayment(paymentType,item);
    }

    // Agent view
    public List<Order> getOrdersToBePickedForAgent(DelivaryAgent delivaryAgent){
        return null;
    }

    // User and restaurants access
    public OrderStatus getOrderStatus(String orderId){
        return null;
    }

    // To be accessed by the Agent and Restaurant
    public void updateOrderStatus(OrderStatus newOrderStatus,String orderId){
        orderManagementService.updateOrderStatus(newOrderStatus,orderId);
    }

}
