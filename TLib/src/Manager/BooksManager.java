package Manager;

import java.util.ArrayList;
import java.util.List;

import Common.Book;
import Common.Commons;
import txtFileManager.TFileManeger;

public class BooksManager {

	private TFileManeger fm;
	private static BooksManager bm;
	public BooksManager() {
		super();
		this.fm = new TFileManeger("Books.txt");
	}
	
	public static BooksManager getBookManager(){
		if(bm==null){
			bm = new BooksManager();
		}
		return bm;
	}

	public void Insert(Book b) {
		String s = BookToString(b);
		fm.AppendRow(s);
	}

	public void Update(Book b) {

	}

	public void Delete(Book b) {

	}

	public List<Book> SelectAll() {
		List<Book> books = new ArrayList<>();
		String lines[];
		lines = fm.getArray();
		for (String string : lines) {
			books.add(StringToBook(string));
		}
		
		return books;
		
	}

	public void clearLibrary() {
		fm.Clear();
	}
	
	private String BookToString(Book b){
		return b.getBNo() + Commons.SPLITTER + b.getAuthor() + Commons.SPLITTER + b.getPages() + Commons.SPLITTER
		+ b.getSubject() + Commons.SPLITTER + b.getTitle();
	}
	private Book StringToBook(String s){
		Book b = new Book();
		String[] tmp = s.split(Commons.SPLITTER);
		
		b.setBNo(tmp[0]);
		b.setAuthor(tmp[1]);
		b.setPages(Integer.parseInt(tmp[2]));
		b.setSubject(tmp[3]);
		b.setTitle(tmp[4]);
		
		return b;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fm.toString();
	}

	
}
