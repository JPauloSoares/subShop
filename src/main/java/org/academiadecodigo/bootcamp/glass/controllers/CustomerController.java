package org.academiadecodigo.bootcamp.glass.controllers;

import org.academiadecodigo.bootcamp.glass.converters.CustomerDTOtoCustomer;
import org.academiadecodigo.bootcamp.glass.converters.CustomerToCustomerDTO;
import org.academiadecodigo.bootcamp.glass.dto.CustomerDTO;
import org.academiadecodigo.bootcamp.glass.model.customer.Customer;
import org.academiadecodigo.bootcamp.glass.model.products.LightSub;
import org.academiadecodigo.bootcamp.glass.model.products.MaxSub;
import org.academiadecodigo.bootcamp.glass.model.products.MediumSub;
import org.academiadecodigo.bootcamp.glass.model.products.options.LightSubOptions;
import org.academiadecodigo.bootcamp.glass.model.products.options.MaxSubOptions;
import org.academiadecodigo.bootcamp.glass.model.products.options.MediumSubOptions;
import org.academiadecodigo.bootcamp.glass.services.CustomerService;
import org.academiadecodigo.bootcamp.glass.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customer")
public class CustomerController {

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

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<CustomerDTO> showCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerToCustomerDto.convert(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/add"})
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {


        if (customerDTO.getId() != 0) {
            return new ResponseEntity<>(customerDTO,HttpStatus.FORBIDDEN);

        } else {

            customerService.save(customerDtoToCustomer.convert(customerDTO));
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<CustomerDTO> editCustomer(@Valid @RequestBody CustomerDTO customerDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerDto.getId() != 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Customer customer = customerService.get(id);

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());


        customerService.save(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {

        customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
