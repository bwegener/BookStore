package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class EmployeeDetailsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        TextView employeeFirstTV = findViewById(R.id.employeeFirstNameTextView);
        TextView employeeLastTV = findViewById(R.id.employeeLastNameTextView);
        TextView employeeAddressTV = findViewById(R.id.employeeAddressTextView);
        TextView employeePhoneTV = findViewById(R.id.employeePhoneNumberTextView);
        TextView employeeDateOfBirthTV = findViewById(R.id.employeeDateOfBirthTextView);
        TextView employeeHireDateTV = findViewById(R.id.employeeHireDateTextView);
        TextView employeeSalesTV = findViewById(R.id.employeeSaleTextView);
        TextView employeePositionTV = findViewById(R.id.employeePositionTextView);

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

    public void handleButtonsEmployeeDetails(View v) {
        switch (v.getId()) {
            case R.id.backButton:
                Intent employeeListActivity = new Intent(this, EmployeeListActivity.class);
                startActivity(employeeListActivity);
                break;
            case R.id.modifyEmployeeButton:
            {
                // This needs to be fixed to reset all the TextViews to EditText
                Intent addEmployeeActivity = new Intent(this, AddEmployeeActivity.class);
                startActivity(addEmployeeActivity);
                break;
            }

        }
    }
}
