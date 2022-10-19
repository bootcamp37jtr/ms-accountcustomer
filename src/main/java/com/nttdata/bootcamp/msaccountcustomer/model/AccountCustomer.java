package com.nttdata.bootcamp.msaccountcustomer.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCustomer {
	
	@Id
	private Long accountId;
	private Integer productId;
	private String numberAccount; // numero de cuenta
	private String numberInterbankAccount; // numero de cuenta
	private BigDecimal availableBalance; // saldo disponible
	private BigDecimal contableBalance; // saldo contable
	private Integer customerId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	 
}
