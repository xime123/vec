package vec.com.vec.content;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vec.com.vec.R;
public class EyeTracking extends AppCompatActivity {
    // 图片封装为一个数组
    private int[] icon = { R.drawable.circle, R.drawable.circle,
            R.drawable.circle, R.drawable.circle, R.drawable.circle,
            R.drawable.circle, R.drawable.circle, R.drawable.circle,
            R.drawable.circle};
    private GridView mgv;
    private SimpleAdapter sim_adapter;
    private List<Map<String, Object>> data_list=new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_eye_tracking);
        mgv=findViewById(R.id.eye_gv);
        init();

    }

    private  void init(){
        String [] from ={"eye_image"};
        int [] to = {R.id.eye_image};
        sim_adapter = new SimpleAdapter(this, getData(), R.layout.eye_item_layout, from, to);
        //配置适配器
        mgv.setAdapter(sim_adapter);
    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("eye_image", icon[i]);

            data_list.add(map);
        }

        return data_list;
    }
}
