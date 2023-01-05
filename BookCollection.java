package test;

import java.util.*;
import java.io.*;
class Book implements Serializable{
	String Authorname,Bookname;
	int isbcno;
	Book(String Authorname,String Bookname,int isbcno)
	{
		this.Authorname=Authorname;
		this.Bookname=Bookname;
		this.isbcno=isbcno;
	}
	public String toString()
	{
		return "Authorname : "+Authorname+"\n"+"Bookname : "+Bookname+"\n"+"isbcno : "+isbcno;
	}
}
class Books{
	public static void main(String...args)throws IOException,ClassNotFoundException
	{
		LinkedHashSet<Book> l=new LinkedHashSet<Book>();
		Book b1=new Book("Joseph","Industrial revolution",2235);
		Book b2=new Book("Daniel","Subconcious strength",3546);
		Book b3=new Book("Priya","Agriculture",7947);
		Book b4=new Book("Agarwal","Aptitude",8976);
		l.add(b1);
		l.add(b2);
		l.add(b3);
		l.add(b4);
		for(Book b:l)
		{
			System.out.println(b);
		}
		FileOutputStream fos=new FileOutputStream("D:\\Lab\\Assessment week 5\\Books.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(l);
		oos.close();
		fos.close();
		FileInputStream fis=new FileInputStream("D:\\Lab\\Assessment week 5\\Books.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		LinkedHashSet<Book> rd=(LinkedHashSet<Book>)ois.readObject();
		ois.close();
		fis.close();
		LinkedHashSet<Book> clo=(LinkedHashSet<Book>)rd.clone();
		Iterator it=clo.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
