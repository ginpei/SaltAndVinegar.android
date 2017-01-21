package info.ginpei.saltandvinegarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    private Settings settings;
    private EditText bookIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = Settings.createInstance(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bookIdEditText = (EditText) findViewById(R.id.bookIdEditText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bookIdEditText.setText(settings.getBookId());
    }

    public void updateSettings(View view) {
        switch (view.getId()) {
            case R.id.bookIdEditText:
                settings.setBookId(((EditText) view).getText().toString());
                break;
        }
    }
}
