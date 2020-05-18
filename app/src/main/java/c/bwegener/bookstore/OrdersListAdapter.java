package c.bwegener.bookstore;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrdersListAdapter extends ArrayAdapter<Orders>
{

    private Context mContext;
    private List<Orders> mOrdersList = new ArrayList<>();
    private int mResourceId;

    public OrdersListAdapter(Context c, int rId, List<Orders> orders) {
        super(c, rId, orders);
        mContext = c;
        mResourceId = rId;
        mOrdersList = orders;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Orders selectedOrder = mOrdersList.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout ordersListLinearLayout =
                (LinearLayout) view.findViewById(R.id.ordersListLinearLayout);

        TextView ordersListCustomerTV =
                (TextView) view.findViewById(R.id.ordersListCustomerTextView);
        TextView ordersListTotalTV =
                (TextView) view.findViewById(R.id.ordersListTotalTextView);

        ordersListLinearLayout.setTag(selectedOrder);

        ordersListCustomerTV.setText(selectedOrder.getCustomer());
        ordersListTotalTV.setText(selectedOrder.getTotal());

        return view;
    }

}
