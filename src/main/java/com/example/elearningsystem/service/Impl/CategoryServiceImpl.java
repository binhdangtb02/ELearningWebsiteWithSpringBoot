package com.example.elearningsystem.service.Impl;

import com.example.elearningsystem.model.Category;
import com.example.elearningsystem.model.User;
import com.example.elearningsystem.repository.CategoryRepository;
import com.example.elearningsystem.repository.UserRepository;
import com.example.elearningsystem.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepo;
    private final UserRepository userRepository;
    @Override
    public Category insertCategory(Category newCategory) {
        //Client will send all information except id of a new category
            return categoryRepo.save(newCategory);

    }

    @Override
    public Category updateCategory(Long id, Category newCategory) {
        Category updateCategory = categoryRepo.findById(id).map(
                category -> {
                    category.setName(newCategory.getName());
                    return categoryRepo.save(category);
                }
        ).orElseGet(() -> {
            newCategory.setId(id);
            return categoryRepo.save(newCategory);
        });
        return updateCategory;
    }
@Override
    public User registerCategory(String username, Long categoryId){
        User user = userRepository.findByUsername(username);
        if(user == null){
            new RuntimeException("NOT FOUND");
        }
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("NOT FOUND")
        );
        user.getCategories().add(category);
        return userRepository.save(user);
    }

    @Override
    public Category findCategoryById(Long categoryid) {
            return categoryRepo.findById(categoryid).orElseGet(() -> null);
    }
}
