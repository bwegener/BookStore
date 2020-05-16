package c.bwegener.bookstore;

public class Cart {
    private int mId;
    private Book mBook;

    public Cart(int id, Book book) {
        mId = id;
        mBook = book;
    }

    public int getId() { return mId; }

    public void setId(int id) { mId = id; }

    public Book getBook() {return mBook; }

    public void setBook(Book book) { mBook = book; }

    @Override
    public String toString() {
        return "Cart{" +
                "mId=" + mId +
                ", mBook=" + mBook +
                '}';
    }
}
