/**
 * http://openhome.cc/Gossip/JUnit/MockObject.html
 */
package learn.java;

import java.util.List;

public interface BookmarkDAO {
	public List<Bookmark> get();

	public void add(Bookmark bookmark);

	public void delete(Bookmark bookmark);
}