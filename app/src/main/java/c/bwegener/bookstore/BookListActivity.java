package c.bwegener.bookstore;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class BookListActivity extends ListActivity {

    private List<Book> mAllBooksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            mAllBooksList = JSONLoader.loadJSONFromAsset(this);
        }
        catch (IOException e)
        {
            Log.e("Bookstore", "Error loading from JSON", e);
        }

        setListAdapter(new BookListAdapter(this, R.layout.book_list_item, mAllBooksList));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent detailsIntent = new Intent(this, BookDetailsActivity.class);
        Book selectedBook = mAllBooksList.get(position);

        detailsIntent.putExtra("Title", selectedBook.getTitle());
        detailsIntent.putExtra("Author", selectedBook.getAuthor());
        detailsIntent.putExtra("Publisher", selectedBook.getPublisher());
        detailsIntent.putExtra("PublishDate", selectedBook.getPublishDate());
        detailsIntent.putExtra("Edition", selectedBook.getEdition());
        detailsIntent.putExtra("Cost", selectedBook.getCost());
        detailsIntent.putExtra("RetailPrice", selectedBook.getRetailPrice());
        detailsIntent.putExtra("Rating", selectedBook.getRating());
        detailsIntent.putExtra("CoverType", selectedBook.getCoverType());
        detailsIntent.putExtra("Genre", selectedBook.getGenre());

        startActivity(detailsIntent);
    }
}