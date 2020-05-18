package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CustomerDetailsActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        TextView customerFirstTV = (TextView) findViewById(R.id.customerFirstNameTextView);
        TextView customerLastTV = (TextView) findViewById(R.id.customerLastNameTextView);
        TextView customerAddressTV = (TextView) findViewById(R.id.customerAddressTextView);
        TextView customerZipTV = (TextView) findViewById(R.id.customerZipTextView);
        TextView customerPhoneTV = (TextView) findViewById(R.id.customerPhoneTextView);
        TextView customerBooksTV = (TextView) findViewById(R.id.customerBooksTextView);
        TextView customerOrdersTV = (TextView)  findViewById(R.id.customerOrdersTextView);

        Customer selectedCustomer = getIntent().getExtras().getParcelable("SelectedCustomer");

        customerFirstTV.setText(selectedCustomer.getFirstName());
        customerLastTV.setText(selectedCustomer.getLastName());
        customerAddressTV.setText(selectedCustomer.getAddress());
        customerZipTV.setText(selectedCustomer.getZipCode());
        customerPhoneTV.setText(selectedCustomer.getPhoneNumber());
        customerBooksTV.setText(selectedCustomer.getBooks());
        customerOrdersTV.setText(selectedCustomer.getOrders());
    }

    public void handleButtons(View v)
    {
        switch(v.getId())
        {
            case R.id.backButton:
                Intent launchHomeScreen = new Intent(this, CustomerListActivity.class);
                startActivity(launchHomeScreen);
                break;
            case R.id.addCustomerButton:
                Intent launchAddCustomer = new Intent(this, AddCustomerActivity.class);
                startActivity(launchAddCustomer);
                break;
        }
    }
}
