package Common;

public class Book {
	private String BNo;
	private String Author;
	private int Pages;
	private String Subject;
	private String Title;

	public String getBNo() {
		return BNo;
	}

	public void setBNo(String bNo) {
		if (!bNo.trim().isEmpty())
			BNo = bNo.trim();
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getPages() {

		return Pages;
	}

	public void setPages(int pages) {
		if (pages > 32 & pages < 100000)
			Pages = pages;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	@Override
	public String toString() {
		return BNo + Commons.SPLITTER + Author + Commons.SPLITTER + Pages + Commons.SPLITTER + Subject
				+ Commons.SPLITTER + Title;
	}

}
