/**
 * http://openhome.cc/Gossip/JUnit/MockObject.html
 */
package learn.java;

public class Bookmark {

	String url;
	String title;
	String category;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Bookmark(String url, String title, String category) {
		super();
		this.url = url;
		this.title = title;
		this.category = category;
	}

}