package vec.com.vec.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vec.com.vec.R;
import vec.com.vec.base.BaseToolBarActivity;

public class SecurityActivity extends BaseToolBarActivity{

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_security;
    }

    @Override
    protected void initTooBar() {
        super.initTooBar();
        toolbar.setTitle("安全中心");
    }
}
