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

public class OrdersListActivity extends AppCompatActivity {


    private DBHelper db;
    private List<Orders> allOrdersList;
    private List<Orders> filteredOrdersList;
    private ListView ordersListView;

    private OrdersListAdapter ordersListAdapter;

    private Spinner customerSpinner;
    private EditText searchOrders;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_list);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importOrdersFromCSV("orders.csv");

        allOrdersList = db.getAllOrders();
        filteredOrdersList = new ArrayList<>(allOrdersList);

        ordersListView = (ListView) findViewById(R.id.ordersList);
        ordersListAdapter =
                new OrdersListAdapter(this, R.layout.orders_list_item, filteredOrdersList);
        ordersListView.setAdapter(ordersListAdapter);

        // TextWatcher for the Search Bar
        searchOrders = findViewById(R.id.searchOrders);
        searchOrders.addTextChangedListener(searchOrdersTextWatcher);

        // The Spinner for the Position Spinner
        Spinner mySpinner = findViewById(R.id.customerSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(OrdersListActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.customers));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customerSpinner = (Spinner) findViewById(R.id.customerSpinner);
        customerSpinner.setOnItemSelectedListener(customerSpinnerListener);

        mySpinner.setAdapter(myAdapter);

    }

    // This only works for titles right now
    public TextWatcher searchOrdersTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String entry = charSequence.toString().trim().toUpperCase();

            // Clear the list adapter
            ordersListAdapter.clear();

            // Loop through the Books
            for (Orders o : allOrdersList)
                // if the book title starts with the entry, add it back to the list adapter
                if (o.getCustomer().toUpperCase().startsWith(entry))
                    ordersListAdapter.add(o);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public AdapterView.OnItemSelectedListener customerSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            // Retrieve the customer
            String customer = String.valueOf(customerSpinner.getItemAtPosition(i));

            // Clear the adapter
            ordersListAdapter.clear();

            if(customer.equals("[Select Customer]"))
                ordersListAdapter.addAll(allOrdersList);
            else
            {
                // Loop through books
                for(Orders o : allOrdersList)
                    if(o.getCustomer().equals(customer))
                        ordersListAdapter.add(o);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    public void viewOrderDetails(View v)
    {
        if(v instanceof LinearLayout)
        {
            LinearLayout selectedLayout = (LinearLayout) v;
            Orders selectedOrder = (Orders) selectedLayout.getTag();
            Log.i("Antique Bookstore", selectedOrder.toString());

            Intent detailsIntent = new Intent(this, OrdersDetailsActivity.class);
            detailsIntent.putExtra("SelectedOrder", selectedOrder);
            startActivity(detailsIntent);
        }
    }


    public void handleButtonsOrdersList(View v)
    {
        switch(v.getId())
        {
            case R.id.goBackArrow:
                Intent goBack = new Intent(this, HomeScreenActivity.class);
                startActivity(goBack);
                break;
            case R.id.addOrderButton:
                Intent addOrders = new Intent(this, AddOrdersActivity.class);
                startActivity(addOrders);
                break;
        }
    }


}
