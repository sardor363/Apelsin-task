package uz.sardor.apelsintask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sardor.apelsintask.entity.Category;
import uz.sardor.apelsintask.entity.Customer;
import uz.sardor.apelsintask.payload.ApiResponse;
import uz.sardor.apelsintask.payload.CustomerDto;
import uz.sardor.apelsintask.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public ApiResponse add(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setCountry(customerDto.getCountry());
        customer.setAddress(customerDto.getAddress());
        customer.setPhone(customerDto.getPhone());
        customerRepository.save(customer);
        return new ApiResponse("Saved",true,customer);
    }

    public ApiResponse getCustomer(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("not found",false);
        return new ApiResponse("found",true,byId);
    }

    public ApiResponse getCustomers() {
        List<Customer> all = customerRepository.findAll();
        return new ApiResponse("Found", true, all);
    }

    public ApiResponse edit(Integer id, CustomerDto customerDto) {
        Optional<Customer> byId = customerRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Not found",false);

        Customer customer = byId.get();
        customer.setName(customerDto.getName());
        customer.setCountry(customerDto.getCountry());
        customer.setAddress(customerDto.getAddress());
        customer.setPhone(customerDto.getPhone());
        customerRepository.save(customer);
        return new ApiResponse("Edited",true,customer);
    }
}
