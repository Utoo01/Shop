package eddie.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import eddie.shop.order.vo.Order;
import eddie.shop.order.vo.OrderItem;
import eddie.shop.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport {

	public void save(Order order) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(order);
	}

	public int findCountByUid(Integer uid) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		// TODO Auto-generated method stub

		String hql = "from Order o where o.user.uid = ? order by o.ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, new Object[] { uid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	public void update(Order currOrder) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(currOrder);
	}

	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<OrderItem> findOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql, oid);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
