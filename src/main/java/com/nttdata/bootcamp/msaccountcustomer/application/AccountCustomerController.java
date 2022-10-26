package com.nttdata.bootcamp.msaccountcustomer.application;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.msaccountcustomer.model.AccountCustomer;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/accountcustomer")
@RefreshScope
public class AccountCustomerController {
	
	@Autowired
	AccountCustomerService accountCustomerService;
	
	@PostMapping
	public Mono<AccountCustomer> insertAccountCustomer(@RequestBody AccountCustomer accountCustomer){
		accountCustomer.setCreatedAt(new Date());
		accountCustomer.setContableBalance(accountCustomer.getAvailableBalance());
		return accountCustomerService.crearCuenta(Mono.just(accountCustomer));
	}
	
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<AccountCustomer>> findById(@PathVariable String id) {
		log.info(id);
		return accountCustomerService.findById(id)
				.map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	

}
