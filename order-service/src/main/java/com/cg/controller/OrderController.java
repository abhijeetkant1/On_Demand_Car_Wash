package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.ApiRequestException;
import com.cg.models.OrderDetails;
import com.cg.services.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderService orderservice;

	 /* Name:Abhijeet kant
	  * EmpId: 46195747
	  * Creation Date:20/07/22
	  * Modification Date:21/07/22
	  * 
	  */

	// Order Operations
	@PostMapping("/addorder")
	@ApiOperation(value = "To Add new order")
	public String addOrder(@RequestBody OrderDetails order) {
		order.setOrderId(orderservice.getSequenceNumber(OrderDetails.SEQUENCE_NAME));
		orderservice.addOrder(order);
		return "order placed with washer" + order;
	}

	@GetMapping("/allorders")
	@ApiOperation(value = "To Get all order Details")
	public List<OrderDetails> getOrder() {
		return orderservice.orderdetails();
	}

	@PutMapping("/updateorder")
	@ApiOperation(value = "To update order Details")
	public String updateDetails( @RequestBody OrderDetails order) {
		orderservice.updateOrder(order);
		return "Updated sucessfully";
	}

	@DeleteMapping("/cancelorder/{id}")
	@ApiOperation(value = "Deletes order by Id")
	public ResponseEntity<Object> deletorder(@RequestParam Long id) {
		boolean isOrderExist = orderservice.existsById(id);
		if (isOrderExist) {
			orderservice.deleteById(id);
			return new ResponseEntity<Object>("Order deleted with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("ORDER NOT FOUND WITH THIS ID:" + id);
		}
	}
}
