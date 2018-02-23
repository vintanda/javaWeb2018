/**
 * @author LZD		2018/02/08
 */
/*
 * ���ﳵ��
 */
package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {

	//������Ʒ�ļ���
	private HashMap<Item, Integer> goods;
	
	//���ﳵ����ܽ��
	private double totalPrice;
	
	//���췽������goods��totalPrice���г�ʼ��
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
	
	//�����Ʒ�����ﳵ
	public boolean addGoodsInCart(Item item, int number) {
		/*
		 * �����Ʒǰ���ж��Ƿ�����ӹ�����Ʒ��
		 * ����ӹ�����Ʒ�������valueֵ����
		 * ��δ��ӹ�����Ʒ����ʱ�����Ʒ
		 */
		if(goods.containsKey(item)) {
			//goods.get(item)��õ���goods���HashMap�����ж�Ӧitem��value��������
			goods.put(item, goods.get(item) + number);
		}else {
			goods.put(item, number);
		}
		
		//ÿ����һ�������Ʒ�Ĳ�����Ҫ���¼���һ����Ʒ���ܽ��
		calTotalPrice();
		return true;
	}
	
	//ɾ����Ʒ
	public boolean removeGoodsFromCart(Item item) {
		goods.remove(item);
		
		//ÿ����һ��ɾ����Ʒ�Ĳ�����Ҫ���¼���һ����Ʒ���ܽ��
		calTotalPrice();
		return true;
	}
	
	//ͳ���ܽ��
	public double calTotalPrice() {
		double sum = 0.0;
		
		//�����е�key����һ��Set������
		Set<Item> keys = goods.keySet();
		
		//Setʹ�õ���������
		Iterator<Item> it = keys.iterator();
		
		//������
		while(it.hasNext()) {
			Item i = it.next();
			sum += i.getPrice() * goods.get(i);
		}
		
		//ֱ�ӽ��ܽ����и�ֵ
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}
	
	public static void main(String[] args) {
		
		//����������Ʒ����
		Item i1 = new Item(1, "aaa", "wenzhou", 200, 500, "001.jpg");
		Item i2 = new Item(2, "bbb", "guangzhou", 300, 500, "002.jpg");
		Item i3 = new Item(1, "aaa", "wenzhou", 200, 500, "001.jpg");
		
		Cart c = new Cart();
		
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		
		//�ٴ������ͬ��Ʒ
		c.addGoodsInCart(i3, 3);
		
		Set<Map.Entry<Item, Integer>> items = c.getGoods().entrySet();
		for(Map.Entry<Item, Integer> obj : items) {
			System.out.println(obj);
		}
		
		System.out.println("��Ʒ�ܽ�" + c.getTotalPrice());
		
	}
	
	
}
