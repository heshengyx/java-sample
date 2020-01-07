package com.hsheng.core.design.iterator;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/7 16:16
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Java"));
        bookShelf.appendBook(new Book("C++"));
        bookShelf.appendBook(new Book("Linux"));
        bookShelf.appendBook(new Book("Docker"));

        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
