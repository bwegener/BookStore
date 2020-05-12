package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Spinner;

public class AddBookScreenActivity extends AppCompatActivity {

    private ImageButton backArrow;
    private EditText title;
    private EditText author;
    private EditText publisher;
    private EditText publishDate;
    private EditText edition;
    private EditText cost;
    private EditText retailPrice;
    private RatingBar rating;
    private EditText coverType;
    private Spinner genre;
    private Button addBook;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_screen);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        backArrow = findViewById(R.id.backArrowImage);

        /*
        How to create drop down menu
         */
        Spinner mySpinner = (Spinner) findViewById(R.id.genreSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddBookScreenActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.genre));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // This allows the adapter to show the data inside the spinner
        mySpinner.setAdapter(myAdapter);
    }

    public void goBack(View v)
    {
        Intent goBack = new Intent(this, HomeScreenActivity.class);

        startActivity(goBack);
    }

    public void addBook(View v)
    {
        // put extra
        // then call go back
        
    }
}
