package org.kecmen.quiz.service.impl;

import javax.annotation.Resource;

import org.kecmen.quiz.model.Category;
import org.kecmen.quiz.repository.CategoryRepository;
import org.kecmen.quiz.service.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Resource
	private CategoryRepository categoryRepository;

	@Override
	public Category findCategoryById(int id) {
		return categoryRepository.findOne(id);
	}
}
