package eddie.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


public class Cart implements Serializable{
	
	// 购物总计:
	private double total;
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	public double getTotal() {
		return total;
	}
	
	
	//添加购物车的方法
	public void addCart(CartItem cartItem) {
		Integer pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());	
		}else{
			map.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();
	}

	//根据ID在购物车里移除对应的商品
	public void removeCart(Integer pid) {
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	
	
	//移除所有购物车
	public void clearCart() {
		map.clear();
		total = 0;
	}
	
	
}
