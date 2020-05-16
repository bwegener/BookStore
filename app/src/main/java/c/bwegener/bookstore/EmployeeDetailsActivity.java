package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class EmployeeDetailsActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        TextView employeeFirstTV = (TextView) findViewById(R.id.employeeFirstNameTextView);
        TextView employeeLastTV = (TextView) findViewById(R.id.employeeLastNameTextView);
        TextView employeeAddressTV = (TextView) findViewById(R.id.employeeAddressTextView);
        TextView employeePhoneTV = (TextView) findViewById(R.id.employeePhoneNumberTextView);
        TextView employeeDateOfBirthTV = (TextView) findViewById(R.id.employeeDateOfBirthTextView);
        TextView employeeHireDateTV = (TextView) findViewById(R.id.employeeHireDateTextView);
        TextView employeeSalesTV = (TextView) findViewById(R.id.employeeSaleTextView);
        TextView employeePositionTV = (TextView) findViewById(R.id.employeePositionTextView);

        Employee selectedEmployee = getIntent().getExtras().getParcelable("SelectedEmployee");

        employeeFirstTV.setText(selectedEmployee.getFirstName());
        employeeLastTV.setText(selectedEmployee.getLastName());
        employeeAddressTV.setText(selectedEmployee.getAddress());
        employeePhoneTV.setText(selectedEmployee.getPhoneNumber());
        employeeDateOfBirthTV.setText(selectedEmployee.getDateOfBirth());
        employeeHireDateTV.setText(selectedEmployee.getHireDate());
        employeeSalesTV.setText(selectedEmployee.getSales());
        employeePositionTV.setText(selectedEmployee.getPosition());
    }

    public void handleButtons(View v) {
        switch (v.getId()) {
            case R.id.goBackArrow:
                Intent employeeListActivity = new Intent(this, EmployeeListActivity.class);
                startActivity(employeeListActivity);
                break;
            case R.id.addEmployeeButton:
                Intent addEmployeeActivity = new Intent(this, AddEmployeeActivity.class);
                startActivity(addEmployeeActivity);
                break;
        }
    }
}
