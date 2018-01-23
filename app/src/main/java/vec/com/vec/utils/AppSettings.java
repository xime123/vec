package vec.com.vec.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettings {
    private static final String LOCK_PATTERN = "lock_pattern";

    private static final AppSettings APP_SETTINGS = new AppSettings();

    private SharedPreferences preferences; // 文件存储

    // 默认城市
    private static final String DEFAULT_CITY = "深圳市";

    private AppSettings() {

    }

    public static AppSettings getAppSettings() {
        return APP_SETTINGS;
    }

    public void init(Context ctx) {
        preferences = ctx
                .getSharedPreferences("vec.com.vec.utils.AppSettings", Context.MODE_PRIVATE);
    }

    public void clear() {
        preferences.edit().clear().commit();
    }

    private String getStringItem(String key, String defaultvalue) {
        return preferences.getString(key, defaultvalue);
    }

    private void setStringItem(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }

    private int getIntItem(String key, int defaultvalue) {
        return preferences.getInt(key, defaultvalue);
    }

    private void setIntItem(String key, int value) {
        preferences.edit().putInt(key, value).commit();
    }

    private long getLongItem(String key, long defaultvalue) {
        return preferences.getLong(key, defaultvalue);
    }

    private void setLongItem(String key, long value) {
        preferences.edit().putLong(key, value).commit();
    }

    private boolean getBooleanItem(String key, boolean defaultvalue) {
        return preferences.getBoolean(key, defaultvalue);
    }

    private void setBooleanItem(String key, boolean value) {
        preferences.edit().putBoolean(key, value).commit();
    }

    public void setHasLogin(boolean hasLogin) {
        setBooleanItem("hasLogin",hasLogin);
    }

    public boolean getHasLogin() {
       return getBooleanItem("hasLogin",false);
    }

}
