package com.nttdata.bootcamp.msaccountcustomer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.msaccountcustomer.model.AccountCustomer;

import reactor.core.publisher.Mono;


@RestController("accountcustomer")
public class AccountCustomerController {
	
	@Autowired
	AccountCustomerService accountCustomerService;
	
	@PostMapping
	public Mono<AccountCustomer> insertAccountCustomer(@RequestBody AccountCustomer accountCustomer){
		return accountCustomerService.crearCuenta(Mono.just(accountCustomer));
	}

}
