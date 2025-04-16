package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CustomerData;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/signup")
public class SignupController {
    private CustomerRepository customerRepository;

    public SignupController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CustomerData customer) {
        try {
            customerRepository.add(customer);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
