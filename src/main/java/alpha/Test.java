package alpha;

interface TestA {
	@Override
	String toString();
}

public class Test {
	public class XXX implements TestA {
		@Override
		public String toString() {
			return "testaaaa";
		}
	}

	public static void main(String[] args) {
		TestA xxx = new Test().new XXX();
		Test yyy = new Test();
		yyy.finalize();
		System.out.println(xxx.toString());
//		System.out.println(new XXX() implements TestA {
//			@Override
//			public String toString() {
//				return "test";
//			}
//		});
	}
}
