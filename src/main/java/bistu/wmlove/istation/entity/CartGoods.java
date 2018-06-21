package bistu.wmlove.istation.entity;

public class CartGoods {
	private String id;
	private String category1;
	private String category2;
	
	private int shopId;
	private String name;
	private String salesNum;
	
	private String descPhrase;
	private String price;
	
	private String selected;
	
	private int num;
	private String path;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(String salesNum) {
		this.salesNum = salesNum;
	}
	public String getDescPhrase() {
		return descPhrase;
	}
	public void setDescPhrase(String descPhrase) {
		this.descPhrase = descPhrase;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "CartGoods [id=" + id + ", category1=" + category1
				+ ", category2=" + category2 + ", shopId=" + shopId + ", name="
				+ name + ", salesNum=" + salesNum + ", descPhrase="
				+ descPhrase + ", price=" + price + ", selected=" + selected
				+ ", num=" + num + ", path=" + path + "]";
	}
	
}
