package vec.com.vec.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import vec.com.vec.MainActivity;
import vec.com.vec.R;
import vec.com.vec.utils.AppSettings;

public class SplashActivity extends Activity {
    private Handler mhandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean hasLogin= AppSettings.getAppSettings().getHasLogin();
                if(hasLogin){
                    gotoMain();
                }else {
                    gotoRegister();
                }

            }
        },800);
    }

    private void gotoRegister(){
        Intent intent=new Intent(SplashActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    private void gotoMain(){
        Intent intent=new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
