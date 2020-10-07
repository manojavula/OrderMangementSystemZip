package com.manojavula.orderitemsservice;

import java.util.List;

public interface OrderItemsService {
	
	/**
	 * List all the orderItems 
	 * @param pageNo PageNo
	 * @param pageSize total number of orders to be displayed in page
	 * @return OrderItems
	 */
    List<OrderItems> findAll();

    /**
     * Get OrderItem details by orderId
     * @param orderId 
     * @return OrderItem
     */
    OrderItems getOrderItemsByProductCode(String productCode);

    /**
     * Save the new OrderItems details or update the existing OrderItems details.
     * @param orderItems Object
     */
    void saveOrUpdateOrder(OrderItems orderItems);
	

}
