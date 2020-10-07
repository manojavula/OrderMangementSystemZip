package com.manojavula.orderitemsservice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemsController {
	
	private final static Logger logger = LogManager.getLogger(OrderItemsController.class);

    @Autowired
    private OrderItemsService orderItemsService;
    
    /**
     * List all the OrderItems 
     * @return orderItems
     */
    @GetMapping("/orderitems")
    public ResponseEntity<?> listOrders()  {
        try {
    	List<OrderItems> orderItems = orderItemsService.findAll();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
        }
        catch(Exception ex) {
        	logger.error(ex.getMessage());
        	return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        	}
    }

    /**
     * Returns OrderItems details based on the orderItemsId
     * @param orderItemsId orderItemsId
     * @return OrderItems
     */
    @GetMapping("/orderitems/{productCode}")
    public OrderItems getOrderItemsByProductName(@PathVariable(name="productCode") String productCode) {
        
    	try {
    		OrderItems orderItem = orderItemsService.getOrderItemsByProductCode(productCode);
	    	
	    	System.out.println("OrderItem------"+orderItem);
	    	
	        return orderItem;
        }
        catch(Exception ex) {
        	logger.error(ex.getMessage());
        	return new OrderItems();
        }
    }

    /**
     * Create new order in the database
     * @param order order Object
     * @return
     */
    @PostMapping("/orderitems")
    public ResponseEntity<?> createOrder(@RequestBody OrderItems orderItems) {
        try {
        	
        	orderItemsService.saveOrUpdateOrder(orderItems);
        return new ResponseEntity<>( HttpStatus.CREATED);
        }
        catch(Exception ex) {
        	logger.error(ex.getMessage());
        	return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        	}
    }
	
	

}
