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

public class CustomerListAdapter extends ArrayAdapter<Customer> {

    private Context mContext;
    private List<Customer> mCustomersList = new ArrayList<>();
    private int mResourceId;

    public CustomerListAdapter(Context c, int rId, List<Customer> customers)
    {
        super(c, rId, customers);
        mContext = c;
        mResourceId = rId;
        mCustomersList = customers;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Customer selectedCustomer = mCustomersList.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout customerListLinearLayout =
                (LinearLayout) view.findViewById(R.id.customerListLinearLayout);

        TextView customerListFullNameTextView =
                (TextView) view.findViewById(R.id.customerListFullNameTextView);

        TextView customerListPhoneTextView =
                (TextView) view.findViewById(R.id.customerListPhoneTextView);

        customerListLinearLayout.setTag(selectedCustomer);

        customerListFullNameTextView.setText(selectedCustomer.getFirstName() + " " + selectedCustomer.getLastName());
        customerListPhoneTextView.setText(selectedCustomer.getPhoneNumber());

        return view;
    }
}
