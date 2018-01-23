package vec.com.vec.start;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import vec.com.vec.MainActivity;
import vec.com.vec.R;
import vec.com.vec.utils.AppSettings;

public class PermissionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

    }

    /**
     * 保存登录状态
     */
    private void saveLoginState(){
        AppSettings.getAppSettings().setHasLogin(true);
    }
    private void gotoMain(){
        Intent intent=new Intent(PermissionActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void permissionSure(View view) {
        saveLoginState();
        gotoMain();
    }
}
