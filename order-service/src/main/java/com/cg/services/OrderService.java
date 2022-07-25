package com.cg.services;

import java.util.List;

import com.cg.models.OrderDetails;

public interface OrderService {
	
	public OrderDetails addOrder(OrderDetails order);
	public List<OrderDetails> orderdetails();
	public OrderDetails updateOrder(OrderDetails update);
	public void deleteById(int id);
	public Long getSequenceNumber(String sequenceName);
	public boolean existsById(int id);

}
