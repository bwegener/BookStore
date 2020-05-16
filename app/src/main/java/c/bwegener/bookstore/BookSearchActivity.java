package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class BookSearchActivity extends AppCompatActivity {

    private DBHelper db;
    private List<Book> allBooksList;
    private List<Book> filteredBookList;
    private ListView bookListView;

    private BookListAdapter bookListAdapter;

    private EditText searchWindowET;
    private Spinner genreSpinner;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_search);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importBooksFromCSV("books.csv");

        allBooksList = db.getAllBooks();
        filteredBookList = new ArrayList<>(allBooksList);

        bookListView = (ListView) findViewById(R.id.bookListView);
        bookListAdapter = new BookListAdapter(this, R.layout.book_list_item, filteredBookList);
        bookListView.setAdapter(bookListAdapter);


        searchWindowET = (EditText) findViewById(R.id.searchWindowET);
        searchWindowET.addTextChangedListener(searchWindowTextWatcher);

        genreSpinner = (Spinner) findViewById(R.id.genreSpinner);
        genreSpinner.setOnItemSelectedListener(genreSpinnerListener);


        /*
        Can create position spinner if have time
        Construct employeePositionSpinnerAdapter using the method getEmployeePosition() to populate the spinner.
        ArrayAdapter<String> employeePositionSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getEmployeePosition());
        employeePositionSpinner.setAdapter(employeePositionSpinnerAdapter);
         */

    }

    // This only works for titles right now
    public TextWatcher searchWindowTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String entry = charSequence.toString().trim().toUpperCase();

            // Clear the list adapter
            bookListAdapter.clear();

            // Loop through the Books
            for(Book b : allBooksList)
                // if the book title starts with the entry, add it back to the list adapter
                if(b.getTitle().toUpperCase().startsWith(entry))
                    bookListAdapter.add(b);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public AdapterView.OnItemSelectedListener genreSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            // Retrieve the genre
            String genre = String.valueOf(genreSpinner.getItemAtPosition(i));

            // Clear the adapter
            bookListAdapter.clear();

            if(genre.equals("[Select Genre"))
                bookListAdapter.addAll(allBooksList);
            else
            {
                // Loop through books
                for(Book b : allBooksList)
                    if(b.getGenre().equals(genre))
                        bookListAdapter.add(b);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    public void viewBookDetails(View v)
    {
        if(v instanceof LinearLayout)
        {
            LinearLayout selectedLayout = (LinearLayout) v;
            Book selectedBook = (Book) selectedLayout.getTag();
            Log.i("AntiqueBookstore", selectedBook.toString());
            Intent detailsActivity = new Intent(this, BookDetailsActivity.class);

            detailsActivity.putExtra("SelectedBook", selectedBook);
            startActivity(detailsActivity);
        }
    }


    public void handleButtonsBookSearch(View v)
    {
        switch(v.getId())
        {
            case R.id.logoutButton:
                Intent logoutIntent = new Intent(this, HomeScreenActivity.class);
                startActivity(logoutIntent);
                break;
            case R.id.checkoutButton:
                Intent checkoutIntent = new Intent(this, CheckoutActivity.class);
                startActivity(checkoutIntent);
                break;
        }
    }


}
