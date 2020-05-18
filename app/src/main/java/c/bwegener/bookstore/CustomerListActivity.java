package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CustomerListActivity extends AppCompatActivity {

    private DBHelper db;
    private List<Customer> allCustomersList;
    private List<Customer> filteredCustomersList;
    private ListView customerListView;

    private CustomerListAdapter customerListAdapter;

    private EditText searchCustomersET;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importCustomersFromCSV("customers.csv");

        allCustomersList = db.getAllCustomers();
        filteredCustomersList = new ArrayList<>(allCustomersList);

        customerListView = (ListView) findViewById(R.id.customerListView);
        customerListAdapter = new CustomerListAdapter(this, R.layout.customer_list_item, filteredCustomersList);
        customerListView.setAdapter(customerListAdapter);


        searchCustomersET = (EditText) findViewById(R.id.searchCustomersET);
        searchCustomersET.addTextChangedListener(searchCustomersTextWatcher);
    }

    public void viewCustomerDetails(View v)
    {
        if(v instanceof LinearLayout)
        {
            LinearLayout selectedLayout = (LinearLayout) v;
            Customer selectedCustomer = (Customer) selectedLayout.getTag();
            Log.i("Antique Bookstore", selectedCustomer.toString());

            Intent detailsIntent = new Intent(this, CustomerDetailsActivity.class);
            detailsIntent.putExtra("SelectedCustomer", selectedCustomer);
            startActivity(detailsIntent);
        }
    }

    // This only works for titles right now
    public TextWatcher searchCustomersTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String entry = charSequence.toString().trim().toUpperCase();

            // Clear the list adapter
            customerListAdapter.clear();

            // Loop through the Books
            for(Customer c : allCustomersList)
                // if the book title starts with the entry, add it back to the list adapter
                if(c.getFirstName().toUpperCase().startsWith(entry))
                    customerListAdapter.add(c);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void handleButtons(View v)
    {
        switch(v.getId())
        {
            case R.id.goBackArrow:
                Intent launchHomeScreen = new Intent(this, HomeScreenActivity.class);
                startActivity(launchHomeScreen);
                break;
            case R.id.addCustomerButton:
                Intent launchAddCustomer = new Intent(this, AddCustomerActivity.class);
                startActivity(launchAddCustomer);
                break;
        }
    }
}
