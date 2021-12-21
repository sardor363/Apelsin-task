package uz.sardor.apelsintask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sardor.apelsintask.entity.Category;
import uz.sardor.apelsintask.entity.Product;
import uz.sardor.apelsintask.payload.ApiResponse;
import uz.sardor.apelsintask.payload.ProductDto;
import uz.sardor.apelsintask.repository.CategoryRepository;
import uz.sardor.apelsintask.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse add(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        if (!categoryRepository.existsById(productDto.getCategoryId())) return new ApiResponse("Not found", false);
        product.setCategoryId(categoryRepository.getById(productDto.getCategoryId()));
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setPhoto(productDto.getPhoto());
        productRepository.save(product);
        return new ApiResponse("Saved", true, product);
    }

    public ApiResponse getProduct(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Not found", false);
        return new ApiResponse("Found", true, byId);
    }

    public ApiResponse getProducts(Integer id) {
        List<Product> all = productRepository.findAll();
        return new ApiResponse("Found", true, all);
    }

    public ApiResponse edit(Integer id, ProductDto productDto) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Not found", false);

        Product product = byId.get();
        product.setName(productDto.getName());
        if (!categoryRepository.existsById(productDto.getCategoryId())) return new ApiResponse("Not found", false);
        product.setCategoryId(categoryRepository.getById(productDto.getCategoryId()));
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setPhoto(productDto.getPhoto());
        productRepository.save(product);
        return new ApiResponse("Saved", true, product);
    }

    public ApiResponse delete(Integer id) {
        if (!productRepository.existsById(id)) return new ApiResponse("Not found", true);
        productRepository.deleteById(id);
        return new ApiResponse("Deleted",false);
    }
    public ApiResponse deleteAll() {
        productRepository.deleteAll();
        return new ApiResponse("Deleted",true);
    }
}
