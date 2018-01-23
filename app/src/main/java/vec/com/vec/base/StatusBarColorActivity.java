package vec.com.vec.base;

import android.view.ViewGroup;

import vec.com.vec.R;


/**
 * Created by 徐敏 on 2017/8/30.
 */

abstract class StatusBarColorActivity extends BaseToolBarActivity {
    @Override
    protected void initView(ViewGroup contentView) {
        super.initView(contentView);
        setStatusBarColor(R.color.main_color_normal);
    }
}
