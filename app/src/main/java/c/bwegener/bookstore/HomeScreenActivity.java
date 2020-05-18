package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

        // String userName = getIntent().getStringExtra("username");

        bookSearchButton = findViewById(R.id.bookSearchButton);
        addBooksButton = findViewById(R.id.addBooksButton);
        employeesButton = findViewById(R.id.employeesButton);
        customersButton = findViewById(R.id.customersButton);
        ordersButton = findViewById(R.id.ordersButton);
        logoutButton = findViewById(R.id.logoutButton);

        /*
        Is a splash animation for the Buttons
         */
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim);
        a.reset();
        bookSearchButton.clearAnimation();
        bookSearchButton.startAnimation(a);
        customersButton.clearAnimation();
        customersButton.startAnimation(a);
        ordersButton.clearAnimation();
        ordersButton.startAnimation(a);
        logoutButton.clearAnimation();
        logoutButton.startAnimation(a);

        // TODO: FIGURE OUT HOW TO MAKE A USER LOGIN
        addBooksButton.clearAnimation();
        addBooksButton.startAnimation(a);
        employeesButton.clearAnimation();
        employeesButton.startAnimation(a);


        // reset these to invisible
        addBooksButton.setVisibility(View.VISIBLE);
        employeesButton.setVisibility(View.VISIBLE);

        /*
        if(userName.equals("mFinch"))
        {
            // This is an animation for the Add Book
            addBooksButton.clearAnimation();
            addBooksButton.startAnimation(a);
            employeesButton.clearAnimation();
            employeesButton.startAnimation(a);

            addBooksButton.setVisibility(View.VISIBLE);
            employeesButton.setVisibility(View.VISIBLE);
        }

        if(userName.equals("aManager"))
        {
            employeesButton.clearAnimation();
            employeesButton.startAnimation(a);

            employeesButton.setVisibility(View.VISIBLE);
        }
        */
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
                Intent launchAddBookScreen = new Intent(this, AddBookActivity.class);
                startActivity(launchAddBookScreen);
                break;
            case R.id.ordersButton:
                Intent launchOrderScreen = new Intent(this, OrdersListActivity.class);
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
