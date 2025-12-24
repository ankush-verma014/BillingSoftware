package in.ankush.service;

import java.util.List;

import org.mapstruct.Mapping;

import in.ankush.DTO.CategoryRequest;
import in.ankush.DTO.CategoryResponse;

public interface CategoryService {
	
	CategoryResponse addCategory(CategoryRequest request);
	List<CategoryResponse> readCategory();
	CategoryResponse readCategoryById(Long id);
	String deleteAllCategory();
	String deleteCategoryById(String id);
	CategoryResponse updateCategoryById(Long id,CategoryRequest request);
	//CategoryResponse updateAllCategory(CategoryRequest request);
	
}
