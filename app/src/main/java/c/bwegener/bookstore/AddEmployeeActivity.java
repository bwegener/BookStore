package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AddEmployeeActivity extends AppCompatActivity {

    private DBHelper db;

    private EditText firstNameET;
    private EditText lastNameET;
    private EditText addressET;
    private EditText phoneNumberET;
    private EditText dateOfBirthET;
    private EditText hireDateET;
    private Spinner positionSpinner;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        db = new DBHelper(this);

        Spinner mySpinner = findViewById(R.id.positionSpinner);

        firstNameET = findViewById(R.id.firstNameET);
        lastNameET = findViewById(R.id.lastNameET);
        addressET = findViewById(R.id.addressET);
        phoneNumberET = findViewById(R.id.phoneNumberET);
        dateOfBirthET = findViewById(R.id.dateOfBirthET);
        hireDateET = findViewById(R.id.hireDateET);
        positionSpinner = findViewById(R.id.positionSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(AddEmployeeActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.position));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // This allows the adapter to show the data inside the spinner
        mySpinner.setAdapter(myAdapter);
    }

    public void addEmployee(View v)
    {
        if(!isValidInput())
            return;

        String firstName = firstNameET.getText().toString();
        String lastName = lastNameET.getText().toString();
        String address = addressET.getText().toString();
        String phoneNumber = phoneNumberET.getText().toString();
        String dateOfBirth = dateOfBirthET.getText().toString();
        String hireDate = hireDateET.getText().toString();
        String position = positionSpinner.getSelectedItem().toString();

        Employee newEmployee = new Employee(firstName, lastName, address,
                phoneNumber, dateOfBirth, hireDate, "0", position);

        db.addEmployee(newEmployee);

        firstNameET.setText("");
        lastNameET.setText("");
        addressET.setText("");
        phoneNumberET.setText("");
        dateOfBirthET.setText("");
        hireDateET.setText("");
        positionSpinner.setSelection(0);

        db.close();

        Intent employeeListActivity = new Intent(this, EmployeeListActivity.class);
        startActivity(employeeListActivity);
    }


    private boolean isValidInput()
    {
        boolean valid = true;
        if(TextUtils.isEmpty(firstNameET.getText())) {
            firstNameET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(lastNameET.getText())) {
            lastNameET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(addressET.getText())) {
            addressET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(phoneNumberET.getText())) {
            phoneNumberET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(dateOfBirthET.getText())) {
            dateOfBirthET.setError("Required.");
            valid = false;
        }
        if(TextUtils.isEmpty(hireDateET.getText())) {
            hireDateET.setError("Required.");
            valid = false;
        }
        return valid;
    }

    public void goBack(View v)
    {
        Intent goBack = new Intent(this, EmployeeListActivity.class);
        startActivity(goBack);
    }
}
