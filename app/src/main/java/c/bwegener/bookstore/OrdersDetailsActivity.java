package c.bwegener.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class OrdersDetailsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_details);

        TextView ordersCustomerTV = findViewById(R.id.ordersCustomerTextView);
        TextView ordersEmployeeTV = findViewById(R.id.ordersEmployeeTextView);
        TextView ordersTotalTV =  findViewById(R.id.ordersTotalTextView);
        TextView ordersDateTV = findViewById(R.id.ordersDateTextView);
        TextView ordersPaymentTypeTV = findViewById(R.id.ordersPaymentTypeTextView);
        TextView ordersPaidTV = findViewById(R.id.ordersPaidTextView);
        TextView ordersCompleteTV = findViewById(R.id.ordersCompleteTextView);

        Orders selectedOrder = getIntent().getExtras().getParcelable("SelectedOrder");

        if(TextUtils.isEmpty(ordersCustomerTV.getText()))
            ordersCustomerTV.setText("");
        ordersCustomerTV.setText(selectedOrder.getCustomer());

        if(TextUtils.isEmpty(ordersEmployeeTV.getText()))
            ordersEmployeeTV.setText("");
        ordersEmployeeTV.setText(selectedOrder.getEmployee());

        if(TextUtils.isEmpty(ordersTotalTV.getText()))
            ordersTotalTV.setText("$");
        ordersTotalTV.setText(selectedOrder.getTotal());

        if(TextUtils.isEmpty(ordersDateTV.getText()))
            ordersDateTV.setText("");
        ordersDateTV.setText(selectedOrder.getDate());

        if(TextUtils.isEmpty(ordersPaymentTypeTV.getText()))
            ordersPaymentTypeTV.setText("");
        ordersPaymentTypeTV.setText(selectedOrder.getPaymentType());

        if(TextUtils.isEmpty(ordersPaidTV.getText()))
            ordersPaidTV.setText("false");
        ordersPaidTV.setText(selectedOrder.isPaid() ? "false" : "true");

        if(TextUtils.isEmpty(ordersCompleteTV.getText()))
            ordersCompleteTV.setText("false");
        ordersCompleteTV.setText(selectedOrder.isComplete() ? "false" : "true");
    }

    public void goBack(View view) {
        Intent goBack = new Intent(this, OrdersListActivity.class);
        startActivity(goBack);
    }
}
