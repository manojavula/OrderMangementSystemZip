package com.manojavula.orderitemsservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

	/**
     * Return the OrderItem by productCode
     * 
     */
    @Query(value= "select o from OrderItems o where o.productCode =:productCode")
    OrderItems getOrderItemsByProductCode(String productCode);
    
    
	
}
