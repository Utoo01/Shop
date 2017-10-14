package eddie.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import eddie.shop.adminuser.service.AdminUserService;
import eddie.shop.adminuser.vo.AdminUser;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}

	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	public String login(){
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser ==null){
			this.addActionError("用户名或密码错误!");
			return "loginFail";
		}else {
			// 登录成功:
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
	}
	
	
}
