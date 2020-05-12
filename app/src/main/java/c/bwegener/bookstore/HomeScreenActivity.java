package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends AppCompatActivity {

    private Button bookSearchButton;
    private Button addBooksButton;
    private Button employeesButton;
    private Button customersButton;
    private Button ordersButton;
    private Button logoutButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        bookSearchButton = findViewById(R.id.bookSearchButton);


    }

    public void handleButtons(View v)
    {
        switch(v.getId())
        {
            case R.id.bookSearchButton:
                Intent launchBookSearchScreen = new Intent(this, BookSearchActivity.class);
                startActivity(launchBookSearchScreen);
                break;
            case R.id.employeesButton:
                Intent launchEmployeeScreen = new Intent(this, EmployeeListActivity.class);
                startActivity(launchEmployeeScreen);
                break;
            case R.id.addBooksButton:
                Intent launchAddBookScreen = new Intent(this, AddBookScreenActivity.class);
                startActivity(launchAddBookScreen);
                break;
            case R.id.ordersButton:
                Intent launchOrderScreen = new Intent(this, OrdersActivity.class);
                startActivity(launchOrderScreen);
                break;
            case R.id.customersButton:
                Intent launchCustomerScreen = new Intent(this, CustomerListActivity.class);
                startActivity(launchCustomerScreen);
                break;
            case R.id.logoutButton:
                Intent launchLoginScreen = new Intent(this, LoginActivity.class);
                startActivity(launchLoginScreen);
                break;
        }
    }

}
