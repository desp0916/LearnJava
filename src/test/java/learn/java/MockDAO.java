package learn.java;

import java.util.ArrayList;
import java.util.List;

public class MockDAO implements BookmarkDAO {
	private List<Bookmark> bookmarks = new ArrayList<Bookmark>();

	@Override
	public void add(Bookmark bookmark) {
		bookmarks.add(bookmark);
	}

	@Override
	public void delete(Bookmark bookmark) {
		bookmarks.remove(bookmark);
	}

	@Override
	public List<Bookmark> get() {
		return bookmarks;
	}

}