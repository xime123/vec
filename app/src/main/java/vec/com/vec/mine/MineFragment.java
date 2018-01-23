package vec.com.vec.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vec.com.vec.R;
import vec.com.vec.base.BaseFragment;
import vec.com.vec.view.CommonLineTextView;

/**
 * Created by xumin on 2018/1/22.
 */

public class  MineFragment extends BaseFragment {
    private CommonLineTextView secCLT;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contentView=inflater.inflate(R.layout.mine_fram_layout,null);
        secCLT=contentView.findViewById(R.id.security_clt);
        secCLT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SecurityActivity.class);
                startActivity(intent);
            }
        });
        return contentView;
    }
}
