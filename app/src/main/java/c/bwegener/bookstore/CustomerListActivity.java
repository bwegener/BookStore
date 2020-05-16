package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomerListActivity extends AppCompatActivity {

    private DBHelper db;
    private List<Customer> allCustomersList;
    private List<Customer> filteredCustomersList;
    private ListView customerListView;

    private CustomerListAdapter customerListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importCustomersFromCSV("customers.csv");

        allCustomersList = db.getAllCustomers();
        filteredCustomersList = new ArrayList<>(allCustomersList);

        // If we want a search bar we can add that here
        /*
        customerNameEditText = (EditText) findViewById(R.id.customerNameEditText);
        customerNameEditText.addTextChangedListener(customerNameTextWatcher);
        */

        customerListView = (ListView) findViewById(R.id.customerListView);
        customerListAdapter = new CustomerListAdapter(this, R.layout.customer_list_item, filteredCustomersList);
        customerListView.setAdapter(customerListAdapter);

    }

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
