/**
 * @author LZD		2018/02/08
 */
/*
 * ��Ʒ��Ϣ��
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
	 * Ϊ�˲�����ظ�����Ʒ��дhashCode������equals����(non-Javadoc)
	 * ����������дhashCode����������дequals����
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		/*
		 * Ĭ���ǵ��ôӸ���̳й�����hashCode����������new�����Ķ��ǲ�ͬ�Ķ���
		 * ��Ϊ�ڶ��ڴ��п����˲�ͬ���ڴ�ռ�
		 * return super.hashCode();
		 */
		//��������д��hashCode����
		return this.getId() + this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		/*
		 * �÷����������ж���������������Ƿ���ͬ
		 * ԭequals������return super.equals(obj);
		 */
		//��д��equals����
		if(this == obj) {
			//���ǵ�ǰ����
			return true;
		}
		if(obj instanceof Item) {
			//����Ʒ����
			Item i = (Item)obj;
			if(this.getId() == i.getId() && this.getName().equals(i.getName())) {
				return true;
			}else {
				return false;
			}
		}else {
			//������Ʒ����
			return false;
		}
		
	}

	
	//��дtoString����
	public String toString() {
		return "��Ʒ���ƣ�" + this.getName() + ",��ƷId��" + this.getId()
				+ ",��Ʒ�۸�" + this.getPrice();
	}
	
}
