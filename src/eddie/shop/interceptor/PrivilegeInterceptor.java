package eddie.shop.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import eddie.shop.adminuser.vo.AdminUser;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		AdminUser adminUser = (AdminUser) ServletActionContext.getRequest()
				.getSession().getAttribute("existAdminUser");
		if(adminUser!=null){
			
			return arg0.invoke();
		}else{
			ActionSupport support = (ActionSupport) arg0.getAction();
			support.addActionError("您还没有登录!没有权限访问!");
			return ActionSupport.LOGIN;
		}
		
	}

}
