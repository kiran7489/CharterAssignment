package com.charter.rewardsProgram.controller;

import com.charter.rewardsProgram.entity.Customer;
import com.charter.rewardsProgram.model.Rewards;
import com.charter.rewardsProgram.repository.CustomerRepository;
import com.charter.rewardsProgram.service.RewardsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class RewardsController {

    @Autowired
    RewardsService rewardsService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/{customerId}/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getRewardsByCustomerId(@PathVariable("customerId") Long customerId) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("Missing customer Id ");
        }
        Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(mapper.writeValueAsString(customerRewards), HttpStatus.OK);
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getRewardsByCustomerId() {
        List<Customer> customers = customerRepository.findAll();
        if (customers == null) {
            throw new RuntimeException("Missing customer Id ");
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
