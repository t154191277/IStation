package bistu.wmlove.istation.entity;

public class WordAndCount {
    private String text;
    
    private int count;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "WordAndCount [text=" + text + ", count=" + count + "]";
	}
	
	
    
}