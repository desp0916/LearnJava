/**
 * http://openhome.cc/Gossip/JUnit/MockObject.html
 */
package learn.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BookmarkServiceTest {
	@Test
	public void testAdd() {
		BookmarkDAO mockDAO = new MockDAO();
		Bookmark bookmark1 = new Bookmark("testURL1", "testTitle1", "testCategory1");
		Bookmark bookmark2 = new Bookmark("testURL2", "testTitle2", "testCategory2");
		mockDAO.add(new Bookmark("testURL1", "testTitle1", "testCategory1"));

		BookmarkService service = new BookmarkService(mockDAO);
		service.add(bookmark1);
		assertEquals(2, mockDAO.get().size());

		service.add(bookmark2);
		assertEquals(3, mockDAO.get().size());
		assertEquals(bookmark2, mockDAO.get().get(2));
	}
}
