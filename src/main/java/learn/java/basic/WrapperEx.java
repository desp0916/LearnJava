package learn.java.basic;

class WrapperEx{
	public static void main(String[] args){
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		System.out.println("---Integer類別---");
		System.out.println(i1.equals(i2));
		System.out.println(i1==i2);
		System.out.println(Integer.parseInt("3"));
		//System.out.println(Integer.parseInt("xx"));

		System.out.println("---Double類別---");
		double d = Double.parseDouble("0.0");
		System.out.println(Double.isInfinite(1.0/d));
		System.out.println(Double.isNaN(0.0/d));

		System.out.println("---Boolean類別---");
		System.out.println(Boolean.valueOf("true"));
		System.out.println(Boolean.valueOf("yes"));
	}
}