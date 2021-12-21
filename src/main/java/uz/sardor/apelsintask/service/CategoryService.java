package uz.sardor.apelsintask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sardor.apelsintask.entity.Category;
import uz.sardor.apelsintask.payload.ApiResponse;
import uz.sardor.apelsintask.payload.CategoryDto;
import uz.sardor.apelsintask.payload.ProductDto;
import uz.sardor.apelsintask.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse add(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new ApiResponse("Saved", true, category);
    }

    public ApiResponse getCategory(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (!optional.isPresent()) return new ApiResponse("Not found", false);
        return new ApiResponse("Found", true, optional);
    }

    public ApiResponse getCategories() {
        List<Category> all = categoryRepository.findAll();
        return new ApiResponse("Found", true, all);
    }

    public ApiResponse edit(Integer id, CategoryDto categoryDto) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Not found",false);
        Category category = byId.get();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new ApiResponse("Saved", true, category);
    }

    public ApiResponse delete(Integer id) {
        if (!categoryRepository.existsById(id)) return new ApiResponse("Not found", false);
        categoryRepository.deleteById(id);
        return new ApiResponse("Deleted", false);
    }

    public ApiResponse deleteAll() {
        categoryRepository.deleteAll();
        return new ApiResponse("Deleted", true);
    }
}
