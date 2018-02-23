/**
 * @author LZD		2018/02/08
 */
/*
 * 购物车类
 */
package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {

	//购买商品的集合
	private HashMap<Item, Integer> goods;
	
	//购物车类的总金额
	private double totalPrice;
	
	//构造方法，对goods和totalPrice进行初始化
	public Cart() {
		goods = new HashMap<>();
		totalPrice = 0.0;
	}

	public HashMap<Item, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Item, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//添加商品到购物车
	public boolean addGoodsInCart(Item item, int number) {
		/*
		 * 添加商品前先判断是否已添加过该商品，
		 * 若添加过该商品，则更改value值即可
		 * 若未添加过该商品，此时添加商品
		 */
		if(goods.containsKey(item)) {
			//goods.get(item)获得的是goods这个HashMap集合中对应item的value，即数量
			goods.put(item, goods.get(item) + number);
		}else {
			goods.put(item, number);
		}
		
		//每进行一次添加商品的操作都要重新计算一下商品的总金额
		calTotalPrice();
		return true;
	}
	
	//删除商品
	public boolean removeGoodsFromCart(Item item) {
		goods.remove(item);
		
		//每进行一次删除商品的操作都要重新计算一下商品的总金额
		calTotalPrice();
		return true;
	}
	
	//统计总金额
	public double calTotalPrice() {
		double sum = 0.0;
		
		//将所有的key放入一个Set集合中
		Set<Item> keys = goods.keySet();
		
		//Set使用迭代器遍历
		Iterator<Item> it = keys.iterator();
		
		//计算金额
		while(it.hasNext()) {
			Item i = it.next();
			sum += i.getPrice() * goods.get(i);
		}
		
		//直接将总金额进行赋值
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}
	
	public static void main(String[] args) {
		
		//创建几个商品对象
		Item i1 = new Item(1, "aaa", "wenzhou", 200, 500, "001.jpg");
		Item i2 = new Item(2, "bbb", "guangzhou", 300, 500, "002.jpg");
		Item i3 = new Item(1, "aaa", "wenzhou", 200, 500, "001.jpg");
		
		Cart c = new Cart();
		
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		
		//再次添加相同商品
		c.addGoodsInCart(i3, 3);
		
		Set<Map.Entry<Item, Integer>> items = c.getGoods().entrySet();
		for(Map.Entry<Item, Integer> obj : items) {
			System.out.println(obj);
		}
		
		System.out.println("商品总金额：" + c.getTotalPrice());
		
	}
	
	
}
