package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.CategoryDto;
import com.kodluyoruz.weekFourHomework.model.entity.Category;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDtoList(List<Category> category);

    Category createCategory(CreateUpdateCategoryRequest request);
//
//    void updateProduct(@MappingTarget Product product, CreateUpdateProductRequest request);
}
