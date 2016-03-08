/**
 * http://openhome.cc/Gossip/JUnit/EasyMock.html
 */
package learn.java;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookmarkServiceTest2 {
	private Bookmark bookmark1;
	private Bookmark bookmark2;
	private BookmarkDAO mockDAO;
	private BookmarkService service;

	@Before
	public void setUp() {
		bookmark1 = new Bookmark("testURL1", "testTitle1", "testCategory1");
		bookmark2 = new Bookmark("testURL2", "testTitle2", "testCategory2");
		// 動態建立Mock物件
		mockDAO = createMock(BookmarkDAO.class);
		service = new BookmarkService(mockDAO);
	}

	@Test
	public void testAddSameBookmark() {
		// 錄製預期被呼叫的方法、設定預期之傳回值
		expect(mockDAO.get()).andReturn(Arrays.asList(bookmark1));
		replay(mockDAO);

		service.add(bookmark1);
	}

	@Test
	public void testAddDifferentBookmark() {
		expect(mockDAO.get()).andReturn(Arrays.asList(bookmark1));
		mockDAO.add(bookmark2);
		replay(mockDAO);

		service.add(bookmark2);
	}

	@After
	public void tearDown() {
		// 驗證預期的流程是否完成
		verify(mockDAO);
	}
}