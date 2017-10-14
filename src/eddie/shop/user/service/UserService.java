package eddie.shop.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import eddie.shop.user.dao.UserDao;
import eddie.shop.user.vo.User;
import eddie.shop.utils.MailUitls;
import eddie.shop.utils.MailUtilsTest;
import eddie.shop.utils.PageBean;
import eddie.shop.utils.UUIDUtils;


@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	// 按用户名查询用户的方法:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	// 业务层完成用户注册代码:
	public void save(User user) throws Exception {
		// 将数据存入到数据库
		user.setState(0); // 0:代表用户未激活.  1:代表用户已经激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		// 发送激活邮件;
		MailUtilsTest.initMain(user.getEmail(), code);
	}

	// 业务层根据激活码查询用户
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	// 修改用户的状态的方法
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// 用户登录的方法
	public User login(User user) {
		return userDao.login(user);
	}


	public PageBean<User> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setPage(page);
		int limit = 5;
		pageBean.setLimit(limit);
		int totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(totalCount/limit);
		pageBean.setTotalPage(totalPage);
		int begin = (page-1) * limit;
		List<User> list = userDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}


	public User findByuId(Integer uid) {
		// TODO Auto-generated method stub
		return userDao.findByUid(uid);
	}


	public void delete(User user) {
		// TODO Auto-generated method stub
		userDao.delete(user);
	}





	
}
