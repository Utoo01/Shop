package eddie.shop.categorysecond.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import eddie.shop.category.service.CategoryService;
import eddie.shop.category.vo.Category;
import eddie.shop.categorysecond.service.CategorySecondService;
import eddie.shop.categorysecond.vo.CategorySecond;
import eddie.shop.utils.PageBean;

public class AdminCategorySecondAction extends ActionSupport implements
		ModelDriven<CategorySecond> {

	private CategorySecond categorySecond = new CategorySecond();

	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}

	private CategorySecondService categorySecondService;
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	public String findAll() {
		PageBean<CategorySecond> pageBean = categorySecondService
				.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	public String addPage() {
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPageSuccess";
	}

	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}

	public String delete() {
		categorySecond = categorySecondService.findByCsid(categorySecond
				.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	public String edit(){
		categorySecond = categorySecondService.findByCsid(categorySecond
				.getCsid());
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}

	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	
}
