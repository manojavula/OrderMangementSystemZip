package com.manojavula.orderitemsservice;

public class OrderItemsNotFoundException extends RuntimeException {

	public OrderItemsNotFoundException(String message) {
		super(message);
	}
}
