package vec.com.vec.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import vec.com.vec.utils.AppSettings;

/**
 * Created by xumin on 2018/1/22.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppSettings.getAppSettings().init(this);
    }
    @Override
    public void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }
}
