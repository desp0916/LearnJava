package learn.java.basic;

class StringEx{
	public static void main(String[] args){
		String str = "A dog ";
		System.out.println(str.length());
		System.out.println(str.concat("!"));
		System.out.println(str.trim());
		System.out.println(str.indexOf("d"));
		System.out.println(str.charAt(3));
		System.out.println(str.substring(2, 5));
		System.out.println(str.replace("dog","cat"));
		System.out.println(str.equalsIgnoreCase("A DOG "));
		System.out.println(str.startsWith("A"));
		System.out.println(str.endsWith("dog "));
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println(str);
	}
}
