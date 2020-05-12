package c.bwegener.bookstore;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class BookDetailsActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String author = intent.getStringExtra("Author");
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


        // Image and Text Views
        ImageView bookImageView = (ImageView) findViewById(R.id.bookImageView);
        TextView bookTitleTextView = (TextView) findViewById(R.id.bookTitleTextView);
        TextView bookAuthorTextView = (TextView) findViewById(R.id.bookAuthorTextView);
        TextView bookPublisherTextView = (TextView) findViewById(R.id.bookPublisherTextView);
        TextView bookPublishDateTextView = (TextView) findViewById(R.id.bookPublishDateTextView);
        TextView bookEditionTextView = (TextView) findViewById(R.id.bookEditionTextView);

        // COST and RETAIL PRICE
        TextView bookCostTextView = (TextView) findViewById(R.id.bookCostTextView);
        TextView bookRetailPriceTextView = (TextView) findViewById(R.id.bookRetailPriceTextView);

        // RATING BAR

        //
        TextView bookCoverTypeTextView = (TextView) findViewById(R.id.bookCoverTypeTextView);
        TextView bookGenreTextView = (TextView) findViewById(R.id.bookGenreTextView);

        /*
        // THIS IS IF WE WANT THE BOOKS TO HAVE SPECIFIC IMAGES --
        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            bookImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("Book Details", "Error loading image: " + imageFileName, e);
        }
        */

        bookTitleTextView.setText(title);
        bookAuthorTextView.setText(author);
        bookPublisherTextView.setText(publisher);
        bookPublishDateTextView.setText(publishDate);
        bookEditionTextView.setText(edition);
        bookCostTextView.setText("$" + cost);
        bookRetailPriceTextView.setText("($" + retailPrice);
        bookCoverTypeTextView.setText(coverType);
        bookGenreTextView.setText(genre);

    }

    /*
    This quits the detailed view and goes back to the Book Search Activity
     */
    protected void goBack(View v)
    {
        finish();
    }


    /*
    This function will add the chosen book to the cart
     */
    protected void addToCart(View v)
    {

    }
}
