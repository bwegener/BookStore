package c.bwegener.bookstore;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LauncherActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BookSearchActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_book_search);
    }



}
