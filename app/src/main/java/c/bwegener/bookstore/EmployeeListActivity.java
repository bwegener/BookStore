package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private DBHelper db;
    private List<Employee> allEmployeeList;
    private List<Employee> filteredEmployeesList;
    private ListView employeeListView;

    private EmployeeListAdapter employeeListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importEmployeesFromCSV("employees.csv");

        allEmployeeList = db.getAllEmployees();
        filteredEmployeesList = new ArrayList<>(allEmployeeList);

        // If we want a search bar we can add that here
        /*
        employeeNameEditText = (EditText) findViewById(R.id.employeeNameEditText);
        employeeNameEditText.addTextChangedListener(employeeNameTextWatcher);

        employeePositionSpinner = (Spinner) findViewById(R.id.employeePositionSpinner);
        employeeSpinner.setOnItemSelectedListener(employeeSpinnerListener);
        */

        employeeListView = (ListView) findViewById(R.id.employeeListView);
        employeeListAdapter =
                new EmployeeListAdapter(this, R.layout.employee_list_item, filteredEmployeesList);
        employeeListView.setAdapter(employeeListAdapter);

        /*
        Can create position spinner if have time
        Construct employeePositionSpinnerAdapter using the method getEmployeePosition() to populate the spinner.
        ArrayAdapter<String> employeePositionSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getEmployeePosition());
        employeePositionSpinner.setAdapter(employeePositionSpinnerAdapter);
         */

    }


    /*
    private String[] getEmployeePosition()
    {
        String[] employeePosition = new String[allEmployeeList.size() + 1];
        employeePosition[0] = "[Select Position]";
        for(int i = 1; i < employeePosition.length; i++)
            employeePosition[i] = allEmployeeList.get(i-1).getFirstName();
        return employeePosition;
    }
    */

    public void addEmployee(View v)
    {
        Intent addEmployee = new Intent(EmployeeListActivity.this, AddEmployeeActivity.class);
        startActivity(addEmployee);
    }

    public void goBack(View v)
    {
        Intent goBack = new Intent(EmployeeListActivity.this, HomeScreenActivity.class);
        startActivity(goBack);
    }


}
