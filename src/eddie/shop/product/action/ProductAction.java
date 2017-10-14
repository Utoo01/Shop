package eddie.shop.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import eddie.shop.product.service.ProductService;
import eddie.shop.product.vo.Product;
import eddie.shop.utils.PageBean;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {

	// 用于接收数据的模型驱动.
	private Product product = new Product();

	private Integer cid; // 接收一级分类cid

	// 接收当前页数:
	private int page;

	// 接收二级分类id
	private Integer csid;
	

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	// 注入商品的Service
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

	// 根据商品的ID进行查询商品:执行方法:
	public String findByPid() {
		// 调用Service的方法完成查询.
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	// 根据一级分类查询商品:
	public String findByCid() {
		// List<Category> cList = categoryService.findAll();
		// 因为刚进入Index.action已经将一级分类存入sesion中，所以此处可以选择不查询

		// 根据一级分类查询商品,带分页查询
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);
		
		// 将PageBean存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);

		return "findByCid";
	}
	
	
	
	// 根据二级分类查询商品:
	public String findByCsid(){
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}

}
