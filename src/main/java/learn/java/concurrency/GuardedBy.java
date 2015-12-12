/**
 * Parallel Processing and Multi-Core Utilization with Java
 * https://github.com/desp0916/LearnJava/blob/master/doc/Parallel_Processing_and_Multi-Core_Utilization_with_Java/Parallel_Processing_and_Multi-Core_Utilization_with_Java.md
 *
 * Java线程(七)：Callable和Future
 * http://blog.csdn.net/ghsau/article/details/7451464
 */

package learn.java.concurrency;

public @interface GuardedBy {
	public enum Current {NONE, REQUIRE, ANALYSIS, DESIGN, SYSTEM};
	String value() default "NoMethod";

}
