package vec.com.vec.start;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import vec.com.vec.MainActivity;
import vec.com.vec.R;
import vec.com.vec.base.BaseActivity;
import vec.com.vec.utils.AppSettings;

public class RegistInfoActivity extends BaseActivity {
    private EditText nameTv,pwdTv,pwdAgainTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarTranslucent(R.color.transparent, 0);
        setContentView(R.layout.activity_regist_info);
        nameTv=findViewById(R.id.name_et);
        pwdTv=findViewById(R.id.pwd_et);
        pwdAgainTv=findViewById(R.id.pwd_again_et);
    }

    public void sureInfo(View view) {
        if(TextUtils.isEmpty(nameTv.getText().toString().trim())){
            Toast.makeText(RegistInfoActivity.this,"称呼不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(pwdTv.getText().toString().trim())||TextUtils.isEmpty(pwdAgainTv.getText().toString().trim())){
            Toast.makeText(RegistInfoActivity.this,"密码不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        if(!pwdTv.getText().toString().trim().equals(pwdAgainTv.getText().toString().trim())){
            Toast.makeText(RegistInfoActivity.this,"两次密码不一致",Toast.LENGTH_LONG).show();
            return;
        }

        gotoPermission();

    }

    private void gotoPermission(){
        Intent intent=new Intent(RegistInfoActivity.this, PermissionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }



}
