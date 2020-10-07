package com.manojavula.orderitemsservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {
	
	@Autowired
	OrderItemsRepository orderItemRepository;
	

	@Override
	public List<OrderItems> findAll() {
		// TODO Auto-generated method stub
		return orderItemRepository.findAll();
	}

	@Override
	public OrderItems getOrderItemsByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return orderItemRepository.getOrderItemsByProductCode( productCode );
	}

	@Override
	public void saveOrUpdateOrder(OrderItems order) {
		// TODO Auto-generated method stub
		orderItemRepository.save(order);
	}

}
