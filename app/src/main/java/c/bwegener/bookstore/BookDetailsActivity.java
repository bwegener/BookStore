package c.bwegener.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;


public class BookDetailsActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        /*
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String authorLast = intent.getStringExtra("AuthorLast");
        String authorFirst = intent.getStringExtra("AuthorFirst");
        String publisher = intent.getStringExtra("Publisher");
        String publishDate = intent.getStringExtra("PublishDate");
        String edition = intent.getStringExtra("Edition");


        // Potentially change cost and retail price to double
        String cost = intent.getStringExtra("Cost");
        String retailPrice = intent.getStringExtra("RetailPrice");

        // NEED TO ADD RATING BAR

        //
        String coverType = intent.getStringExtra("CoverType");
        String genre = intent.getStringExtra("Genre");
        */


        // Image and Text Views
        // ImageView bookImageView = (ImageView) findViewById(R.id.bookImageView);
        TextView bookTitleTextView = findViewById(R.id.bookTitleTextView);
        TextView bookAuthorLastTextView = findViewById(R.id.bookAuthorLastTextView);
        TextView bookAuthorFirstTextView = findViewById(R.id.bookAuthorFirstTextView);
        TextView bookPublisherTextView = findViewById(R.id.bookPublisherTextView);
        TextView bookPublishDateTextView = findViewById(R.id.bookPublishDateTextView);
        TextView bookEditionTextView = findViewById(R.id.bookEditionTextView);

        // COST and RETAIL PRICE
        TextView bookCostTextView = findViewById(R.id.bookCostTextView);
        TextView bookRetailPriceTextView = findViewById(R.id.bookRetailPriceTextView);

        // RATING BAR
        RatingBar bookRating = findViewById(R.id.bookRating);

        //
        TextView bookCoverTypeTextView = findViewById(R.id.bookCoverTypeTextView);
        TextView bookGenreTextView = findViewById(R.id.bookGenreTextView);


        Book selectedBook = getIntent().getExtras().getParcelable("SelectedBook");

        bookTitleTextView.setText(selectedBook.getTitle());
        if(TextUtils.isEmpty(bookTitleTextView.getText()))
            bookTitleTextView.setText("");

        bookAuthorLastTextView.setText(selectedBook.getAuthorLast());
        if(TextUtils.isEmpty(bookAuthorLastTextView.getText()))
            bookAuthorLastTextView.setText("");

        bookAuthorFirstTextView.setText(selectedBook.getAuthorFirst());
        if(TextUtils.isEmpty(bookAuthorFirstTextView.getText()))
            bookAuthorFirstTextView.setText("");

        bookPublisherTextView.setText(selectedBook.getPublisher());
        if(TextUtils.isEmpty(bookPublisherTextView.getText()))
            bookPublisherTextView.setText("");

        bookPublishDateTextView.setText(selectedBook.getPublishDate());
        if(TextUtils.isEmpty(bookPublishDateTextView.getText()))
            bookPublishDateTextView.setText("");

        bookEditionTextView.setText(selectedBook.getEdition());
        if(TextUtils.isEmpty(bookEditionTextView.getText()))
            bookEditionTextView.setText("");

        bookCostTextView.setText(selectedBook.getCost());
        if(TextUtils.isEmpty(bookCostTextView.getText()))
            bookCostTextView.setText("");

        bookRetailPriceTextView.setText(selectedBook.getRetailPrice());
        if(TextUtils.isEmpty(bookRetailPriceTextView.getText()))
            bookRetailPriceTextView.setText("");

        bookRating.setRating(selectedBook.getRating());

        bookCoverTypeTextView.setText(selectedBook.getCoverType());
        if(TextUtils.isEmpty(bookCoverTypeTextView.getText()))
            bookCoverTypeTextView.setText("");

        bookGenreTextView.setText(selectedBook.getGenre());
    }

    // This goes back to the Book Search Activity
    protected void goBack(View v)
    {
        finish();
    }


    // This function will add the chosen Book to the Cart
    private void addToCart(View v)
    {


    }
}
