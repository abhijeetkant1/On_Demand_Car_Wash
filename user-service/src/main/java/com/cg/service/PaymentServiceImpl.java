//package com.cg.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.exception.PaymentNotFoundException;
//import com.cg.models.Payment;
//import com.cg.repository.PaymentRepository;
//
//
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//
//	Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
//
//	@Autowired
//	private PaymentRepository paymentRepository;
//
//	@Override
//	public List<Payment> getAllPayments() {
//		logger.info("Getting List of Payments");
//		List<Payment> payments = paymentRepository.findAll();
//		logger.info("Successfully got list of payments");
//		return payments;
//	}
//
//	@Override
//	public Payment savePayment(Payment payment) {
//		logger.info("Adding a Payment");
//		Payment savedPayment = paymentRepository.save(payment);
//		logger.info("Successfully added payment");
//		return savedPayment;
//	}
//
//	@Override
//	public Payment getPaymentById(String transactionId) {
//		 logger.info("Getting payment by id");
//		Optional<Payment> optionalPayment = paymentRepository.findById(transactionId);
//
//		if (optionalPayment == null) {
//			throw new PaymentNotFoundException("Payment not exising with id: " + transactionId);
//		}
//
//		Payment payment = optionalPayment.get();
//		 logger.info("successfully got payment by id");
//		return payment;
//	}
//
//}