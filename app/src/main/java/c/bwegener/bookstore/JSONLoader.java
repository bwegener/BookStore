package c.bwegener.bookstore;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONLoader {

    public static List<Book> loadJSONFromAsset(Context context) throws IOException {
        ArrayList<Book> allBooksList = new ArrayList<>();
        String json = null;
        InputStream is = context.getAssets().open("Books.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");


        try {
            JSONObject rootObject = new JSONObject(json);
            JSONArray allBooksArray = rootObject.getJSONArray("Books");
            int length = allBooksArray.length();

            for (int i = 0; i < length; ++i) {
                JSONObject bookJSON = allBooksArray.getJSONObject(i);
                Book book = new Book();

                book.setTitle(bookJSON.getString("Title"));
                book.setAuthor(bookJSON.getString("Author"));
                book.setPublisher(bookJSON.getString("Publisher"));
                book.setPublishDate(bookJSON.getString("PublishDate"));
                book.setEdition(bookJSON.getString("Edition"));
                book.setCost(bookJSON.getDouble("Cost"));
                book.setRetailPrice(bookJSON.getDouble("RetailPrice"));
                book.setRating(bookJSON.getDouble("Rating"));
                book.setCoverType(bookJSON.getString("CoverType"));
                book.setGenre(bookJSON.getString("Genre"));

                allBooksList.add(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allBooksList;
    }
}
