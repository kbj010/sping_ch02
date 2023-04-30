package samp05;

public class Book {
	private String title;
	private int price;
	public Book(String title, int price) {
		this.title = title;  this.price = price;
	}
	// 재정의 안하면 패키지명.클래스명@해시코드
	public String toString() {
		return "책[제목:"+title+", 가격:"+price+"]";
	}
}
