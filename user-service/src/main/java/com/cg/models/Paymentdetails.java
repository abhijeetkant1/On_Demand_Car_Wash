package com.cg.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="paymentdetails")
public class PaymentDetails {
	
	
	
	private String FullName;
	
	@NotNull
	@Size(min=16,max=16,message="Card Number should of 16 digits")
	private String cardNo;
	
	@NotNull
	@Max(value=999,message="CVV cannot exceed 3 digits")
	private int cvv;
	
	@NotNull
	private String validdate;
	
	@NotNull
	private String bankName;
	
	@NotNull
	private int amount;
	



	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getValiddate() {
		return validdate;
	}

	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}

	public String getBankName() {
		return bankName;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public PaymentDetails( String fullName,
			@NotNull @Size(min = 16, max = 16, message = "Card Number should of 16 digits") String cardNo,
			@NotNull @Max(value = 999, message = "CVV cannot exceed 3 digits") int cvv, @NotNull String validdate,
			@NotNull String bankName, @NotNull int amount) {
		super();
		
		FullName = fullName;
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.validdate = validdate;
		this.bankName = bankName;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentDetails [ FullName=" + FullName + ", cardNo=" + cardNo + ", cvv=" + cvv
				+ ", validdate=" + validdate + ", bankName=" + bankName + ", amount=" + amount + "]";
	}

	public PaymentDetails() {
		super();
	}
	
	


	
}

