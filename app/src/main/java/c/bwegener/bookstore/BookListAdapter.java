package c.bwegener.bookstore;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookListAdapter extends ArrayAdapter<Book>
{
    private Context mContext;
    private int mResource;
    private List<Book> mAllBooksList = new ArrayList<>();

    public BookListAdapter(Context context, int resource, List<Book> allBooks)
    {
        super(context, resource, allBooks);
        mContext = context;
        mResource = resource;
        mAllBooksList = allBooks;
    }

    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Book selectedBook = mAllBooksList.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, null);

        LinearLayout bookListLinearLayout =
                view.findViewById(R.id.bookListLinearLayout);
        TextView bookListItemTitleTextView =
                view.findViewById(R.id.bookListItemTitleTextView);
        TextView bookListItemAuthorTextView =
                view.findViewById(R.id.bookListItemAuthorTextView);

        bookListLinearLayout.setTag(selectedBook);
        bookListItemTitleTextView.setText(selectedBook.getTitle());
        bookListItemAuthorTextView.setText(selectedBook.getAuthorLast());

        return view;
    }

}
