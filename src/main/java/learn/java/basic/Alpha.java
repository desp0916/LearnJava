package learn.java.basic;

class Alpha {
	public void bar(int ... x) {}
	public void bar(int x) {}
}

/**
 * 覆寫與重載 (Overloading) 不同，覆寫是改變方法的內容，而重載是
 * 改變方法的回傳值與參數。但兩者均不會改變方法的名稱。（「方法名稱 +
 * 參數」即所謂的「Signature」）
 */
class Beta extends Alpha {
//	private void bar(int x) {} 				// Compile Failed. Cannot reduce visibility
	@Override
	public void bar(int x) {}				// Compile OK. Override 成功
	public int bar(String x) { return 1; }	// Compile OK. Overload
//	public Alpha bar(int x) { }				// Compile Failed. Return type is incompatible with Alpha.bar(int)
	public void bar(int x, int y) {}		// Compile OK. Overload
//	public int bar(int x) { return x; }		// Compile Failed. Return type is incompatible with Alpha.bar(int)
}
