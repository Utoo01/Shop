package eddie.shop.categorysecond.service;

import java.util.List;

import eddie.shop.categorysecond.dao.CategorySecondDao;
import eddie.shop.categorysecond.vo.CategorySecond;
import eddie.shop.utils.PageBean;

public class CategorySecondService {

	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	public PageBean<CategorySecond> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		pageBean.setPage(page);
		int limit = 10;
		pageBean.setLimit(limit);
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(totalCount / limit);
		pageBean.setTotalPage(totalPage);
		int begin = (page -1) *limit;
		List<CategorySecond> list =  categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.save(categorySecond);
	}

	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return categorySecondDao.findByCsid(csid);
	}

	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.delete(categorySecond);
	}

	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		categorySecondDao.update(categorySecond);
	}

	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		return categorySecondDao.findAll();
	}

	
	
}
