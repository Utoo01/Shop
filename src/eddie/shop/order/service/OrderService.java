package eddie.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import eddie.shop.order.dao.OrderDao;
import eddie.shop.order.vo.Order;
import eddie.shop.order.vo.OrderItem;
import eddie.shop.utils.PageBean;

@Transactional
public class OrderService {
	
	// 注入OrderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
		
	}

	public PageBean<Order> findByUid(Integer uid, Integer page) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);
		int limit = 5;
		pageBean.setLimit(limit);
		int totalCount = 0;
		totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		//向上取整
		totalPage = (int) Math.ceil(totalCount / limit);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1)*limit;
		List<Order> list = orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findByOid(oid);
	}

	public void update(Order currOrder) {
		// TODO Auto-generated method stub
		orderDao.update(currOrder);
	}

	public PageBean<Order> findAll(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);
		int limit = 10;
		pageBean.setLimit(limit);
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(totalCount/limit);
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit; 
		List<Order> list = orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public List<OrderItem> findOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findOrderItem(oid);
	}
		
		
}
