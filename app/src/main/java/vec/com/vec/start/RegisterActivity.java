package vec.com.vec.start;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vec.com.vec.R;
import vec.com.vec.base.BaseActivity;
import vec.com.vec.utils.TimeCounter;

public class RegisterActivity extends BaseActivity {
    private EditText phoneEt;
    private EditText codeEt;
    private TextView codeTv;
    private TextView sureTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarTranslucent(R.color.transparent, 0);
        setContentView(R.layout.activity_register);
        initView();
        setListener();
    }

    private void initView(){
        phoneEt=(EditText)findViewById(R.id.phone_et);
        codeEt=(EditText)findViewById(R.id.code_et);
        codeTv=findViewById(R.id.code_tv);
        sureTv=findViewById(R.id.sure_tv);
    }
    private void setListener(){
        codeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeCounter.timerBack(codeTv, 60000, 1000);
            }
        });

        sureTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(phoneEt.getText().toString())){
                    Toast.makeText(RegisterActivity.this,"手机号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(codeEt.getText().toString())){
                    Toast.makeText(RegisterActivity.this,"验证码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                gotoRegisterInfo();
            }
        });
    }

    private void gotoRegisterInfo(){
        Intent intent=new Intent(this,RegistInfoActivity.class);
        startActivity(intent);
        finish();
    }


}
