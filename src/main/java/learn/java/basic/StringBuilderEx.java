package learn.java.basic;

class StringBuilderEx{
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder("A dog");
		System.out.println(sb.append("!"));
		System.out.println(sb.insert(2, "barking "));

		int beginIndex = sb.indexOf("bark");
		int endIndex = sb.indexOf("!");
		System.out.println(
			sb.replace(beginIndex, endIndex, "meowing cat"));

		beginIndex = sb.indexOf("meow");
		endIndex = sb.indexOf("cat");
		System.out.println(sb.delete(beginIndex, endIndex));

		System.out.println(sb.substring(2, sb.length()));
	}
}