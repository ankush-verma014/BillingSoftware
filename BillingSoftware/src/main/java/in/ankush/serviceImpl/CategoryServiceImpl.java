package in.ankush.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ankush.exception.CategoryNotFound;

import in.ankush.DTO.CategoryRequest;
import in.ankush.DTO.CategoryResponse;
import in.ankush.entity.CategoryEntity;
import in.ankush.mapper.CategoryMapper;
import in.ankush.repository.CategoryRepository;
import in.ankush.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepo;
	private final CategoryMapper categoryMapper;

	@Override
	public CategoryResponse addCategory(CategoryRequest request) {

		// DTO -> Entity (manual id + mapper fields)
		CategoryEntity entity = categoryMapper.toEntity(request);
		entity.setCategoryId(UUID.randomUUID().toString());

		entity = categoryRepo.save(entity);
		//entity.setUpdateAt(LocalDateTime.now());

		// Entity -> DTO
		return categoryMapper.toResponse(entity);
	}

	@Override
	public List<CategoryResponse> readCategory() {

		List<CategoryEntity> entities = categoryRepo.findAll();

		return categoryMapper.toResponseList(entities);
	}

	@Override
	public CategoryResponse readCategoryById(Long id) {

     CategoryEntity entity = categoryRepo.findById(id).orElseThrow(()-> new CategoryNotFound("Id not Found.!!"));
     
     return categoryMapper.toResponse(entity);
	}
	
	@Override
	public String deleteCategoryById(String categoryId)
	{
        
//		if(!categoryRepo.existsById(categoryId))
//		{
//			throw new CategoryNotFound("Category with Id "+ categoryId+" Not Found");
//		}
		
		Optional<CategoryEntity> entity = categoryRepo.findByCategoryId(categoryId);
		
		if(entity.isEmpty())
		{
			throw new CategoryNotFound("Category not found with this id: "+categoryId);
		}
		
		categoryRepo.delete(entity.get());
        return "Delete category by Id: "+categoryId;
	}
	
	@Override
	public String deleteAllCategory()
	{
		categoryRepo.deleteAll();
		return "All Category deleted Successfully!!.";
	}

	@Override
	public CategoryResponse updateCategoryById(Long id,CategoryRequest request) {
		
		CategoryEntity entity = categoryRepo.findById(id).orElseThrow(()->
		                                                    new CategoryNotFound("Category Not Found with this Id: "+id));
	    

		categoryMapper.updateCategoryById(request, entity);
		
		//updated data save
		CategoryEntity savedEntity = categoryRepo.save(entity);

		return categoryMapper.toResponse(savedEntity);
	}
}
