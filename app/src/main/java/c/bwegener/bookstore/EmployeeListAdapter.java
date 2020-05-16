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

public class EmployeeListAdapter extends ArrayAdapter<Employee> {

    private Context mContext;
    private List<Employee> mEmployeesList = new ArrayList<>();
    private int mResourceId;

    public EmployeeListAdapter(Context c, int rId, List<Employee> employees) {
        super(c, rId, employees);
        mContext = c;
        mResourceId = rId;
        mEmployeesList = employees;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Employee selectedEmployee = mEmployeesList.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout employeeListLinearLayout =
                (LinearLayout) view.findViewById(R.id.employeeListLinearLayout);

        TextView employeeListFullNameTextView =
                (TextView) view.findViewById(R.id.employeeListFullNameTextView);
        TextView employeeListPositionTextView =
                (TextView) view.findViewById(R.id.employeeListPositionTextView);

        employeeListLinearLayout.setTag(selectedEmployee);

        employeeListFullNameTextView.setText(selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName());
        employeeListPositionTextView.setText(selectedEmployee.getPosition());

        return view;
    }


}


