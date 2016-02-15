package learn.java.scjp;

import java.util.HashSet;

class Book {
	String name;
	Double price;

	public Book(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || !(obj instanceof Book)) {
			return false;
		}
		Book book = (Book) obj;
		System.out.println("equals() - this.name: " + this.name + ", this.price: " +
				this.price + ", book.name: " + book.name +
				", book.price: " + book.price);
		return this.name.equals(book.name) && this.price.equals(book.price);
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode() - name: " + name + ", price: " + price + ", name.hashCode(): " + name.hashCode()
				+ ", price.hashCode(): " + price.hashCode());
		return name.hashCode() + price.hashCode();
	}

	public void show() {
		System.out.println(name);
		System.out.println(price);
	}
}

public class HashCodeEquals {
	public static void main(String[] args) {
		HashSet<Book> hs = new HashSet<Book>();
		Book book1 = new Book("Java程式設計", 580.0);
		Book book2 = new Book("SCJP認證手冊", 600.0);
		Book book3 = new Book("Java程式設計", 580.0);
		hs.add(book1);
		hs.add(book2);
		hs.add(book3);
		System.out.println("書籍資訊如下：");
		System.out.println("--------------------------");
		for (Book book : hs) {
			book.show();
			System.out.println("--------------------------");
		}
	}
}
