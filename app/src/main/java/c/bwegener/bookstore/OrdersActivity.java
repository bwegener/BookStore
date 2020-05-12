package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.NestedScrollingParent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class OrdersActivity extends AppCompatActivity {

    private ImageButton backArrowImage;
    private NestedScrollingParent ordersList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        backArrowImage = findViewById(R.id.backArrowImage);
        ordersList = findViewById(R.id.ordersList);
    }

    public void goBack(View v)
    {
        Intent launchHomeScreen = new Intent(this, HomeScreenActivity.class);

        startActivity(launchHomeScreen);
    }

    /*
    Connect ordersList
     */
}
