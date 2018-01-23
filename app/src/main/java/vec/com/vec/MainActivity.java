package vec.com.vec;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import vec.com.vec.account.AccountFragment;
import vec.com.vec.base.BaseActivity;
import vec.com.vec.content.ContentFragment;
import vec.com.vec.mine.MineFragment;
import vec.com.vec.view.MyFragmentTabHost;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {
    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    private static final String TAG = "MainActivity";
    private static final String TAG_HOME = "tag_home";
    private static final String TAG_APP = "tag_app";
    private static final String TAG_USER = "tag_userCenter";


    public static final int MAIN_TAB_HOME = 0;
    public static final int MAIN_TAB_CATEGORY = 1;

    public static final int MAIN_TAB_CART = 2;
    private FragmentManager mFragmentManager;
    public static final int MAIN_TAB_USER = 3;

    private MyFragmentTabHost mTabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        // TODO Auto-generated method stub
        mTabHost = (MyFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        TabWidget tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        tabWidget.setDividerDrawable(null);
        //首页
        mTabHost.addTab(mTabHost.newTabSpec(TAG_HOME).setIndicator(
            getIndicatorView(TAG_HOME, "内容")),
            ContentFragment.class, null);
        //应用
        mTabHost.addTab(mTabHost.newTabSpec(TAG_APP).setIndicator(
            getIndicatorView(TAG_APP,  "账户")),
            AccountFragment.class, null);

        //个人中心
        mTabHost.addTab(mTabHost.newTabSpec(TAG_USER).setIndicator(
            getIndicatorView(TAG_USER,  "我的")),
            MineFragment.class, null);

        mTabHost.setOnTabChangedListener(this);
        // setTabHostClickable(false);

        mTabHost.setCurrentTabByTag(TAG_HOME);

    }


    private View getIndicatorView(String tag,  String labelResId) {
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.main_tab_indicator, null);
        TextView view = (TextView) rootView.findViewById(R.id.label);
        view.setText(labelResId);

        return rootView;
    }


    public void setTabHostClickable(boolean canClickable) {
        for (int i = 0; i < mTabHost.getTabWidget().getTabCount(); i++) {
            Log.e(TAG, i + "  " + canClickable);
            mTabHost.getTabWidget().getChildTabViewAt(i).setClickable(canClickable);
        }
    }

    @Override
    public void onTabChanged(String tabId) {

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "双击退出", Toast.LENGTH_SHORT)
                .show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {

            finish();
            //  moveTaskToBack(true);
            //       Process.killProcess(Process.myPid());
        }
    }


}
