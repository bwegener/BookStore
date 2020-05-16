package c.bwegener.bookstore;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class BookListActivity extends ListActivity {

    private DBHelper db;
    private List<Book> booksList;
    private BookListAdapter booksListAdapter;
    private ListView booksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        db = new DBHelper(this);

        booksList = db.getAllBooks();
        booksListAdapter = new BookListAdapter(this, R.layout.book_list_item, booksList);
        booksListView = findViewById(R.id.booksListView);
        booksListView.setAdapter(booksListAdapter);
    }

    public void viewBookDeatails(View v)
    {
        if(v instanceof LinearLayout)
        {
            LinearLayout selectedLayout = (LinearLayout) v;
            Book selectedBook = (Book) selectedLayout.getTag();
            Log.i("Antique Bookstore", selectedBook.toString());
            Intent bookDetailsIntent = new Intent(this, BookDetailsActivity.class);

            bookDetailsIntent.putExtra("SelectedBook", selectedBook);
            startActivity(bookDetailsIntent);
        }
    }

}