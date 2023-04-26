package org.academiadecodigo.bootcamp.glass.controllers;

import org.academiadecodigo.bootcamp.glass.converters.CustomerDTOtoCustomer;
import org.academiadecodigo.bootcamp.glass.converters.CustomerToCustomerDTO;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.academiadecodigo.bootcamp.glass.model.products.LightSub;
import org.academiadecodigo.bootcamp.glass.model.products.MaxSub;
import org.academiadecodigo.bootcamp.glass.model.products.MediumSub;
import org.academiadecodigo.bootcamp.glass.model.products.options.LightSubOptions;
import org.academiadecodigo.bootcamp.glass.model.products.options.MaxSubOptions;
import org.academiadecodigo.bootcamp.glass.model.products.options.MediumSubOptions;
import org.academiadecodigo.bootcamp.glass.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sub")
public class SubsController {
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
    @RequestMapping(method = RequestMethod.POST, path = "/light/{id}")
    public ResponseEntity<Customer> subscribeLight(@PathVariable int id ) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(customer.getBalance()< LightSub.value){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        LightSub lightSub= new LightSub();

        //need to add options and a body to get them
        lightSub.setOption1(LightSubOptions.LIGHT_1);
        lightSub.setOption2(LightSubOptions.LIGHT_3);

        customer.setProducts(lightSub);
        customer.setBalance(customer.getBalance() - LightSub.value);

        customerService.save(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/medium/{id}")
    public ResponseEntity<?> subscribeMedium(@PathVariable int id ) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(customer.getBalance()< MediumSub.value){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        MediumSub mediumSub = new MediumSub();

        //need to add options and a body to get them
        mediumSub.setOption3(MediumSubOptions.MEDIUM_1);
        mediumSub.setOption4(MediumSubOptions.MEDIUM_4);
        mediumSub.setOption5(MediumSubOptions.MEDIUM_3);

        customer.setProducts(mediumSub);
        customer.setBalance(customer.getBalance() - MediumSub.value);

        customerService.save(customer);


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/max/{id}")
    public ResponseEntity<?> subscribeMax(@PathVariable int id ) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(customer.getBalance()< MaxSub.value){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        MaxSub maxSub = new MaxSub();

        //need to add options and a body to get them
        maxSub.setOption7(MaxSubOptions.MAX_7);
        maxSub.setOption8(MaxSubOptions.MAX_1);
        maxSub.setOption9(MaxSubOptions.MAX_3);

        customer.setProducts(maxSub);
        customer.setBalance(customer.getBalance() - MaxSub.value);

        customerService.save(customer);


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
