package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class AddBookActivity extends AppCompatActivity {

    private DBHelper db;

    private EditText titleET;
    private EditText costET;
    private EditText retailPriceET;

    // private BookListAdapter bookListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new DBHelper(this);

        titleET = findViewById(R.id.titleEditText);
        costET = findViewById(R.id.costEditText);
        retailPriceET = findViewById(R.id.retailPriceEditText);

        // How to create a Drop Down menu
        Spinner mySpinner = findViewById(R.id.genreSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddBookActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.genre));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // This allows the adapter to show the data inside the spinner
        mySpinner.setAdapter(myAdapter);
    }

    public void addBook(View v)
    {
        if(!isValidInput())
            return;

        EditText authorLastET = findViewById(R.id.authorLastEditText);
        if(TextUtils.isEmpty(authorLastET.getText()))
            authorLastET.setText("");
        EditText authorFirstET = findViewById(R.id.authorFirstEditText);
        if(TextUtils.isEmpty(authorFirstET.getText()))
            authorFirstET.setText("");
        EditText publisherET = findViewById(R.id.publisherEditText);
        if(TextUtils.isEmpty(publisherET.getText()))
            publisherET.setText("");
        EditText publishDateET = findViewById(R.id.publishDateEditText);
        if(TextUtils.isEmpty(publishDateET.getText()))
            publishDateET.setText("");
        EditText editionET = findViewById(R.id.editionEditText);
        if(TextUtils.isEmpty(editionET.getText()))
            editionET.setText("");
        RatingBar ratingET = findViewById(R.id.ratingBar);
        EditText coverTypeET =  findViewById(R.id.coverTypeEditText);
        if(TextUtils.isEmpty(coverTypeET.getText()))
            coverTypeET.setText("");
        Spinner genreSpinner = findViewById(R.id.genreSpinner);

        String title = titleET.getText().toString();
        String authorLast = authorLastET.getText().toString();
        String authorFirst = authorFirstET.getText().toString();
        String publisher = publisherET.getText().toString();
        String publishDate = publishDateET.getText().toString();
        String edition = editionET.getText().toString();
        String cost = costET.getText().toString();
        String retailPrice = retailPriceET.getText().toString();
        Float rating = ratingET.getRating();
        String coverType = coverTypeET.getText().toString();
        String genre = genreSpinner.getSelectedItem().toString();

        Book newBook = new Book(title, authorLast, authorFirst, publisher,
                publishDate, edition, cost, retailPrice, rating,
                coverType, genre);

        db.addBook(newBook);
        // bookListAdapter.add(newBook);

        titleET.setText("");
        authorLastET.setText("");
        authorFirstET.setText("");
        publisherET.setText("");
        publishDateET.setText("");
        editionET.setText("");
        costET.setText("");
        retailPriceET.setText("");
        ratingET.setRating(0.0f);
        coverTypeET.setText("");
        genreSpinner.setSelection(0);

        db.close();

        Intent homeScreen = new Intent(this, HomeScreenActivity.class);
        startActivity(homeScreen);
    }

    private boolean isValidInput()
    {
        boolean valid = true;
        if(TextUtils.isEmpty(titleET.getText())) {
            titleET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(costET.getText())) {
            costET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(retailPriceET.getText())) {
            retailPriceET.setError("Required.");
            valid = false;
        }
        return valid;
    }
}
