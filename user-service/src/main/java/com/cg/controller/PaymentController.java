//package com.cg.controller;
//
///* Name:Abhijeet kant
// * EmpId: 46195747
// * Creation Date:26/07/22
// * Modification Date:27/07/22
// * 
// */
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cg.models.Payment;
//import com.cg.service.PaymentService;
//
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/payment")
//public class PaymentController {
//
//	Logger logger = LoggerFactory.getLogger(PaymentController.class);
//	@Autowired
//	transient private PaymentService paymentService;
//
//	@GetMapping("/all")
//	public List<Payment> fetchAllPayments() {
//		logger.info("Getting All payment details");
//		List<Payment> payments = paymentService.getAllPayments();
//		return payments;
//	}
//
//	@PostMapping("/save")
//	public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment payment) {
//		logger.info("Adding Payment");
//		Payment newPayment = paymentService.savePayment(payment);
//		ResponseEntity<Payment> responseEntity = new ResponseEntity<Payment>(newPayment, HttpStatus.CREATED);
//		logger.info("Successfully added payment details");
//		return responseEntity;
//	}
//
//	@GetMapping("/get/{id}")
//	public ResponseEntity<?> fetchPaymentById(@PathVariable("id") String paymentId) {
//		 logger.info("Getting Payment by id");
//		ResponseEntity<?> responseEntity = null;
//		Payment payment = paymentService.getPaymentById(paymentId);
//		responseEntity = new ResponseEntity<>(payment, HttpStatus.OK);
//		 logger.info("Successfully got all payments by id");
//		return responseEntity;
//	}
//
//}