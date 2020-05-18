package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private DBHelper db;
    private List<Employee> allEmployeeList;
    private List<Employee> filteredEmployeesList;
    private ListView employeeListView;

    private EmployeeListAdapter employeeListAdapter;

    private Spinner positionSpinner;
    private EditText searchEmployees;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importEmployeesFromCSV("employees.csv");

        allEmployeeList = db.getAllEmployees();
        filteredEmployeesList = new ArrayList<>(allEmployeeList);

        employeeListView = findViewById(R.id.employeeListView);
        employeeListAdapter =
                new EmployeeListAdapter(this, R.layout.employee_list_item, filteredEmployeesList);
        employeeListView.setAdapter(employeeListAdapter);

        // TextWatcher for the Search Bar
        searchEmployees = findViewById(R.id.searchEmployeesET);
        searchEmployees.addTextChangedListener(searchEmployeeTextWatcher);

        // The Spinner for the Position Spinner
        Spinner mySpinner = findViewById(R.id.positionSpinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EmployeeListActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.position));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        positionSpinner = (Spinner) findViewById(R.id.positionSpinner);
        positionSpinner.setOnItemSelectedListener(positionSpinnerListener);

        mySpinner.setAdapter(myAdapter);
    }

    public void viewEmployeeDetails(View v)
    {
        if(v instanceof LinearLayout) {
            LinearLayout selectedLayout = (LinearLayout) v;
            Employee selectedEmployee = (Employee) selectedLayout.getTag();
            Log.i("Antique Bookstore", selectedEmployee.toString());

            Intent detailsIntent = new Intent(this, EmployeeDetailsActivity.class);
            detailsIntent.putExtra("SelectedEmployee", selectedEmployee);
            startActivity(detailsIntent);
        }
    }

    // This only works for titles right now
    public TextWatcher searchEmployeeTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String entry = charSequence.toString().trim().toUpperCase();

            // Clear the list adapter
            employeeListAdapter.clear();

            // Loop through the Books
            for (Employee e : allEmployeeList)
                // if the book title starts with the entry, add it back to the list adapter
                if (e.getFirstName().toUpperCase().startsWith(entry))
                    employeeListAdapter.add(e);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public AdapterView.OnItemSelectedListener positionSpinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            // Retrieve the genre
            String position = String.valueOf(positionSpinner.getItemAtPosition(i));

            // Clear the adapter
            employeeListAdapter.clear();

            if(position.equals("[Select Position]"))
                employeeListAdapter.addAll(allEmployeeList);
            else
            {
                // Loop through books
                for(Employee e : allEmployeeList)
                    if(e.getPosition().equals(position))
                        employeeListAdapter.add(e);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    public void handleButtonsEmployeeList(View v)
    {
        switch(v.getId())
        {
            case R.id.goBackArrow:
                Intent goBack = new Intent(this, HomeScreenActivity.class);
                startActivity(goBack);
                break;
            case R.id.addEmployeeButton:
                Intent addEmployeeIntent = new Intent(this, AddEmployeeActivity.class);
                startActivity(addEmployeeIntent);
                break;
        }
    }
}
