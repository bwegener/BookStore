package c.bwegener.bookstore;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.renderscript.ScriptGroup;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.Inflater;

public class BookListAdapter extends ArrayAdapter<Book>
{
    private Context mContext;
    private int mResource;
    private List<Book> mAllBooksList;

    public BookListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Book> allBooks)
    {
        super(context, resource, allBooks);
        mContext = context;
        mResource = resource;
        mAllBooksList = allBooks;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View listItemView = inflater.inflate(mResource, null);

        TextView listItemTitleTextView = (TextView) listItemView.findViewById(R.id.listItemTitleTextView);
        TextView listItemAuthorTextView = (TextView) listItemView.findViewById(R.id.listItemAuthorTextView);

        Book selectedBook = mAllBooksList.get(position);
        listItemTitleTextView.setText(selectedBook.getTitle());
        listItemAuthorTextView.setText(selectedBook.getAuthor());


        return listItemView;
    }


}
