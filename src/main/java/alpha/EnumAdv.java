package alpha;

public class EnumAdv {

	enum BookType {
		COMPUTER, COMIC, BUSINESS;

		@Override
		public String toString() {
			String type = "";
			switch (this) {
				case COMPUTER:
					type = "電腦類";
					break;
				case COMIC:
					type = "漫畫類";
					break;
				case BUSINESS:
					type = "商業類";
					break;
			}
			return type;
		}
	}

	public static void main(String[] args) {
		BookType[] types = BookType.values();
		System.out.println("書籍類型依序為：");
		for (BookType type : types) {
			System.out.println(type + "");
		}
	}
}
