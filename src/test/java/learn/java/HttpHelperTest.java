package learn.java;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import org.junit.BeforeClass;
import org.junit.Test;

class DummyURLStreamHandlerFactory implements URLStreamHandlerFactory {
	@Override
	public URLStreamHandler createURLStreamHandler(String protocol) {
		return new URLStreamHandler() {
			@Override
			protected URLConnection openConnection(URL u) throws IOException {
				return new DummyURLConnection(u);
			}
		};
	}
}

class DummyURLConnection extends HttpURLConnection {
	DummyURLConnection(URL u) {
		super(u);
	}
	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(new String("success").getBytes());
	}
	@Override
	public void disconnect() {}

	@Override
	public boolean usingProxy() {
		return false;
	}
	@Override
	public void connect() throws IOException {}
}

public class HttpHelperTest {
	@BeforeClass
	public static void setUp() {
		URL.setURLStreamHandlerFactory(new DummyURLStreamHandlerFactory());
	}

	@Test
	public void testGetContent() throws Exception{
		HttpHelper helper = new HttpHelper();
		String expected = "success";
		String result = helper.getContent(new URL("http://localhost"));
		assertEquals(expected, result);
	}
}
