package info.ginpei.saltandvinegarandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Settings {
    final public static String NAME = "info.ginpei.saltandvinegarandroid.SETTINGS";
    final public static String KEY_BOOK_ID = "bookId";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public static Settings createInstance(Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences(NAME, MODE_PRIVATE);
        Settings settings = new Settings(preferences);
        return settings;
    }

    @SuppressLint("CommitPrefEdits")
    public Settings(SharedPreferences preferences) {
        this.preferences = preferences;
        editor = preferences.edit();
    }

    public String getBookId() {
        return preferences.getString(KEY_BOOK_ID, "");
    }

    public void setBookId(String id) {
        editor.putString(KEY_BOOK_ID, id);
        editor.apply();
    }
}
