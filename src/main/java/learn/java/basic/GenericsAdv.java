package learn.java.basic;

public class GenericsAdv {

	static class Book<T> {
		T price;

		public static void show(Book<? extends Number> b) {
			System.out.println("書籍定價為：" + b.price);
		}
	}

	public static void main(String[] args) {
		Book<Integer> book = new GenericsAdv.Book<Integer>();
		book.price = 580;
		Book.show(book);
	}
}