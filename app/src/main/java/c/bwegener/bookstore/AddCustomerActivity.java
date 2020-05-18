package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class AddCustomerActivity extends AppCompatActivity
{
    private DBHelper db;

    private EditText firstET;
    private EditText lastNameET;
    private EditText addressET;
    private EditText zipET;
    private EditText phoneET;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        db = new DBHelper(this);


        firstET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        addressET = findViewById(R.id.addressET);
        zipET = findViewById(R.id.zipET);
        phoneET = findViewById(R.id.phoneNumberET);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddCustomerActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.position));
    }

    public void addCustomer(View v)
    {
        if(!isValidInput())
            return;

        String firstName = firstET.getText().toString();
        String lastName = lastNameET.getText().toString();
        String address = addressET.getText().toString();
        if(TextUtils.isEmpty(addressET.getText()))
            addressET.setText("");
        String zip = zipET.getText().toString();
        if(TextUtils.isEmpty(zipET.getText()))
            zipET.setText("");
        String phone = phoneET.getText().toString();
        if(TextUtils.isEmpty(phoneET.getText()))
            phoneET.setText("");
        String books = "";
        String orders = "";

        Customer newCustomer = new Customer(firstName, lastName, address,
                zip, phone, books, orders);

        db.addCustomer(newCustomer);

        firstET.setText("");
        lastNameET.setText("");
        addressET.setText("");
        zipET.setText("");
        phoneET.setText("");

        db.close();

        Intent customerListActivity = new Intent(this, CustomerListActivity.class);
        startActivity(customerListActivity);
    }


    private boolean isValidInput()
    {
        boolean valid = true;
        if(TextUtils.isEmpty(firstET.getText())) {
            firstET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(lastNameET.getText())) {
            lastNameET.setError("Required.");
            valid = false;
        }
        return valid;
    }

    public void goBack(View v)
    {
        Intent goBack = new Intent(this, CustomerListActivity.class);
        startActivity(goBack);
    }
}

