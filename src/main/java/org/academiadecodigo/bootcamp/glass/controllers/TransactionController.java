package org.academiadecodigo.bootcamp.glass.controllers;

import org.academiadecodigo.bootcamp.glass.converters.CustomerDTOtoCustomer;
import org.academiadecodigo.bootcamp.glass.converters.CustomerToCustomerDTO;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.academiadecodigo.bootcamp.glass.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transaction")
public class TransactionController {

    private CustomerService customerService;
    private CustomerDTOtoCustomer customerDtoToCustomer;
    private CustomerToCustomerDTO customerToCustomerDto;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDTOtoCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDTO customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}/deposit/{amount}")
    public ResponseEntity<?> deposit(@PathVariable("id") Integer id, @PathVariable("amount") Integer amount) {

        if(amount <= 0){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        customer.setBalance(customer.getBalance() + amount);

        customerService.save(customer);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/balance")
    public ResponseEntity<?> balanceCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer.getBalance(), HttpStatus.OK);
    }
}
