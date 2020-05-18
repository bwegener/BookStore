package c.bwegener.bookstore;

public class Cart {
    private long mId;
    private Book mBook;

    public Cart(long id, Book book) {
        mId = id;
        mBook = book;
    }

    public long getId() { return mId; }

    public void setId(long id) { mId = id; }

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
