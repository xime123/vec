package vec.com.vec.content;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vec.com.vec.R;
import vec.com.vec.base.BaseFragment;
import vec.com.vec.content.bean.ContentInfo;

/**
 * Created by xumin on 2018/1/22.
 */

public class ContentFragment extends BaseFragment {
    private SwipeRefreshLayout vSwipeRefreshLayout;
    private RecyclerView rvList;
    private HomeAdapter mAdapter;
    private List<ContentInfo>mDatas=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contentView=inflater.inflate(R.layout.content_fram_layout,null);
        vSwipeRefreshLayout=contentView.findViewById(R.id.refresh_srl);
        rvList=contentView.findViewById(R.id.recycler_view);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter=new HomeAdapter();
        rvList.setAdapter(mAdapter);
        vSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //再这里做刷新的操作
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        vSwipeRefreshLayout.setRefreshing(false);
                    }
                },1200);
            }

        });
        initData();
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void initData() {
        mDatas.clear();
        //此处可以网络请求数据
        for(int i=0;i<10;i++){
            ContentInfo info=new ContentInfo();
            info.contentStr="走进全球最顶级餐厅NOMA的私家厨房";
            info.count="22"+i+"次";
            info.time="2018/01/0"+i;
            mDatas.add(info);
        }
        mAdapter.notifyDataSetChanged();
    }
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                getContext()).inflate(R.layout.content_item_layout, parent,
                false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {

            ContentInfo info=mDatas.get(position);
            holder.contentTv.setText(info.contentStr);
            holder.timeTv.setText(info.time);
            holder.countTv.setText(info.count);
            holder.contentIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoEye();
                }
            });
        }

        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView countTv;
            TextView timeTv;
            TextView contentTv;
            ImageView contentIv;
            public MyViewHolder(View view)
            {
                super(view);
                contentIv=view.findViewById(R.id.content_iv);
                countTv = (TextView) view.findViewById(R.id.count_tv);
                timeTv = (TextView) view.findViewById(R.id.time_tv);
                contentTv = (TextView) view.findViewById(R.id.content_tv);
            }
        }
    }

    private void gotoEye(){
        Intent intent=new Intent(getActivity(),EyeTracking.class);
        startActivity(intent);
    }
}
