package eddie.shop.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import eddie.shop.category.vo.Category;
import eddie.shop.product.vo.Product;

public class CategorySecond {

	private Integer csid;
	private String csname;

	// 所属一级分类
	private Category category;
	// 配置商品集合
	private Set<Product> products = new HashSet<Product>();

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

}
