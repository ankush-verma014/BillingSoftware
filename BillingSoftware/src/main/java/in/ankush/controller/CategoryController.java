package in.ankush.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ankush.DTO.CategoryRequest;
import in.ankush.DTO.CategoryResponse;
import in.ankush.service.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryResponse> addCategory(
            @RequestBody CategoryRequest request) {

        CategoryResponse saved = categoryService.addCategory(request);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/displayCategory")
    public ResponseEntity<List<CategoryResponse>> getAllCategory() {

        List<CategoryResponse> list = categoryService.readCategory();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/categoryById/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id)
    {
    	CategoryResponse res = categoryService.readCategoryById(id);
    	
    	return ResponseEntity.ok(res);
    }
    
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> categoryDeleteById(@PathVariable String categoryId)
    {
     String msg = categoryService.deleteCategoryById(categoryId);
    	
    	return ResponseEntity.ok(msg);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllCategory()
    {
    	String msg = categoryService.deleteAllCategory();
    	return ResponseEntity.ok(msg);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponse> updateCategoryById(@PathVariable Long id,CategoryRequest request)
    {
    	CategoryResponse msg = categoryService.updateCategoryById(id, request);
    	
    	return ResponseEntity.ok(msg);
    }
}
