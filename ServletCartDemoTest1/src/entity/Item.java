/**
 * @author LZD		2018/02/08
 */
/*
 * 商品信息类
 */
package entity;

public class Item {
	
	private int id;
	private String name;
	private String city;
	private int price;
	private int number;
	private String picture;
	
	public Item() {}
	
	public Item(int id, String name, String city, int price, int number, String picture) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.picture = picture;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/*
	 * 为了不添加重复的商品重写hashCode方法和equals方法(non-Javadoc)
	 * 并且是先重写hashCode方法，再重写equals方法
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		/*
		 * 默认是调用从父类继承过来的hashCode方法，凡是new出来的都是不同的对象，
		 * 因为在堆内存中开辟了不同的内存空间
		 * return super.hashCode();
		 */
		//以下是重写的hashCode方法
		return this.getId() + this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		/*
		 * 该方法是真正判断两个对象的内容是否相同
		 * 原equals方法：return super.equals(obj);
		 */
		//重写的equals方法
		if(this == obj) {
			//就是当前对象
			return true;
		}
		if(obj instanceof Item) {
			//是商品对象
			Item i = (Item)obj;
			if(this.getId() == i.getId() && this.getName().equals(i.getName())) {
				return true;
			}else {
				return false;
			}
		}else {
			//不是商品对象
			return false;
		}
		
	}

	
	//重写toString方法
	public String toString() {
		return "商品名称：" + this.getName() + ",商品Id：" + this.getId()
				+ ",商品价格：" + this.getPrice();
	}
	
}
