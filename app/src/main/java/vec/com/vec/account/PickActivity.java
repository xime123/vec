package vec.com.vec.account;

import android.view.View;
import android.view.ViewGroup;

import vec.com.vec.R;
import vec.com.vec.base.BaseToolBarActivity;

public class PickActivity extends BaseToolBarActivity {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_pick;
    }

    @Override
    protected void initView(ViewGroup contentView) {
        super.initView(contentView);
    }

    @Override
    protected void initTooBar() {
        super.initTooBar();
        toolbar.setTitle("VEC兑换");
    }

    public void surePick(View view) {
        finish();
    }
}
