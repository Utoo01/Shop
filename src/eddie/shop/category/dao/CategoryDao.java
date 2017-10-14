package eddie.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import eddie.shop.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport{

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public void save(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(category);
	}

	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	public void delete(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(category);
	}

	public void update(Category category) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(category);
	}

}
