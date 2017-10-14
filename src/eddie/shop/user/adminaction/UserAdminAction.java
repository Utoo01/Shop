package eddie.shop.user.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import eddie.shop.user.service.UserService;
import eddie.shop.user.vo.User;
import eddie.shop.utils.PageBean;

public class UserAdminAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private Integer page ;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public String findAll(){
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	public String delete(){
		User users = userService.findByuId(user.getUid());
		userService.delete(users);
		return "deleteSuccess";
	}
	
	public String edit(){
		user = userService.findByuId(user.getUid());
		return "editSuccess";
	}
	
	public String update(){
		userService.update(user);
		return "updateSuccess";
	}

}
