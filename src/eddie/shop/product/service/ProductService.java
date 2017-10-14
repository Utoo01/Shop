package eddie.shop.product.service;

import java.util.List;

import eddie.shop.product.dao.ProductDao;
import eddie.shop.product.vo.Product;
import eddie.shop.utils.PageBean;

public class ProductService {

	// 注入ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}

	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}

	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findByPid(pid);
	}

	public PageBean<Product> findByPageCid(Integer cid, int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();

		pageBean.setPage(page); 
		int limit = 8;
		pageBean.setLimit(limit);
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid); 
		pageBean.setTotalCount(totalCount); 
		// 设置总页数:
		int totalPage = (int) Math.ceil(totalCount / limit);
	
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCid(cid, begin, limit); // 查询对应页数显示的商品
		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page); 
		int limit = 8;
		pageBean.setLimit(limit);
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid); 
		pageBean.setTotalCount(totalCount); 
		int totalPage =  (int) Math.ceil(totalCount / limit);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCsid(csid, begin, limit); 
		pageBean.setList(list);
		return pageBean;

	}

	public PageBean<Product> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page); 
		int limit = 8;
		pageBean.setLimit(limit);
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage =  (int) Math.ceil(totalCount / limit);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}

	public void delete(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

}
