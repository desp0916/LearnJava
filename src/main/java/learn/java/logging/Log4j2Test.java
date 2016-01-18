/**
 * http://web.cogs.idv.tw/2015/01/jcllog4j2log.html
 */

package learn.java.logging;

import java.net.URL;
import java.net.URLClassLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Log4j2Test {

	protected static Log log = LogFactory.getLog(Log4j2Test.class);

	public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println(url.getFile());
        }

		log.info("Hello, World!");
		log.error("Hello, World!");
	}

}