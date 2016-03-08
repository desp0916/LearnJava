package learn.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHelper {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://mart.ibon.com.tw/mart/rui001.faces");
		try {
			HttpHelper helper = new HttpHelper();
			String c = helper.getContent(url);
			System.out.println(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getContent(URL url) throws IOException {
		InputStream input = url.openStream();
		StringWriter writer = new StringWriter();
		byte[] data = new byte[2048];
		int length = -1;
		while ((length = input.read(data)) != -1) {
			writer.write(new String(data, 0, length));
		}
		input.close();
		writer.close();
		return writer.toString();
	}
}
