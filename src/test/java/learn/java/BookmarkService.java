/**
 * http://openhome.cc/Gossip/JUnit/MockObject.html
 */
package learn.java;

public class BookmarkService {

	private BookmarkDAO dao;

	public BookmarkService(BookmarkDAO dao) {
		this.dao = dao;
	}

	public void add(Bookmark bookmark) {
		if (!dao.get().contains(bookmark)) {
			dao.add(bookmark);
		}
	}
}
