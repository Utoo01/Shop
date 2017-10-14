package eddie.shop.cart.action;

import org.apache.struts2.ServletActionContext;
import org.omg.IOP.ServiceContext;

import com.opensymphony.xwork2.ActionSupport;

import eddie.shop.cart.vo.Cart;
import eddie.shop.cart.vo.CartItem;
import eddie.shop.product.service.ProductService;
import eddie.shop.product.vo.Product;

public class CartAction extends ActionSupport {

	private Integer pid; // 接收商品id

	private Integer count; // 接收商品数量

	private ProductService productService; // 注入productService

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 添加购物车
	public String addCart() {
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		Product product = productService.findByPid(pid);
		cartItem.setProduct(product);
		Cart cart = getCart();
		cart.addCart(cartItem);
		return "addCart";
	}

	// 根据pid删除购物车对应的商品
	public String removeCart() {
		Cart cart = getCart();
		cart.removeCart(pid);
		return "removeCart";
	}

	// 清空购物车
	public String clearCart() {
		Cart cart = getCart();
		cart.clearCart();
		return "clearCart";
	}

	
	public String myCart(){
		return "myCart";
	}
	
	
	private Cart getCart() {
		// 从Session中获取购物车
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");

		if (cart == null) {
			// Session中不存在购物车，将其保存在Session
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
	
	

	

}
