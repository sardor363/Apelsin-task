package uz.sardor.apelsintask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sardor.apelsintask.payload.ApiResponse;
import uz.sardor.apelsintask.payload.CategoryDto;
import uz.sardor.apelsintask.payload.CustomerDto;
import uz.sardor.apelsintask.repository.CustomerRepository;
import uz.sardor.apelsintask.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody CustomerDto customerDto) {
        ApiResponse apiResponse = customerService.add(customerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("getOne/{id}")
    public HttpEntity<?> get(@PathVariable Integer id) {
        ApiResponse apiResponse = customerService.getCustomer(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("getAll")
    public HttpEntity<?> gatAll() {
        ApiResponse apiResponse = customerService.getCustomers();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
        ApiResponse apiResponse = customerService.edit(id, customerDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
