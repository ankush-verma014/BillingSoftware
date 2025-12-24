package in.ankush.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import in.ankush.DTO.CategoryRequest;
import in.ankush.DTO.CategoryResponse;
import in.ankush.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // DTO -> Entity (create / update input)
    CategoryEntity toEntity(CategoryRequest dto);

    // Entity -> DTO (single record response)
    CategoryResponse toResponse(CategoryEntity entity);

    // Entity list -> DTO list (list response)
    List<CategoryResponse> toResponseList(List<CategoryEntity> entities);
    
    //for update Category
  
    void updateCategoryById(CategoryRequest request, @MappingTarget CategoryEntity entity);
    
  
    CategoryResponse updateAllCategory(CategoryRequest request);
}
