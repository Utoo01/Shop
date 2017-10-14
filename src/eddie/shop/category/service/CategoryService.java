package eddie.shop.category.service;

import java.util.List;

import eddie.shop.category.dao.CategoryDao;
import eddie.shop.category.vo.Category;

public class CategoryService {
	
	private CategoryDao categoryDao; 

	


	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}




	public List<Category> findAll() {
		// TODO Auto-generated method stub
		
		return categoryDao.findAll();
	}




	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryDao.save(category);
	}




	public void delete(Category category) {
		// TODO Auto-generated method stub
		categoryDao.delete(category);
	}




	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findByCid(cid);
	}




	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDao.update(category);
	}


}
