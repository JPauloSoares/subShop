package org.academiadecodigo.bootcamp.glass.controllers;

import org.academiadecodigo.bootcamp.glass.converters.CustomerDTOtoCustomer;
import org.academiadecodigo.bootcamp.glass.converters.CustomerToCustomerDTO;
import org.academiadecodigo.bootcamp.glass.dto.CustomerDTO;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.academiadecodigo.bootcamp.glass.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/main")
public class AccessController {

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

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<CustomerDTO> customerLogin(@RequestBody CustomerDTO customerDTO) {

        Customer customer1;

        if (customerService.findByEmail(customerDTO.getEmail()) != null) {
            customer1 = customerService.findByEmail(customerDTO.getEmail());

            if (customerDTO.getPassword().equals(customer1.getPassword())) {
                return new ResponseEntity<>(customerToCustomerDto.convert(customer1), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
