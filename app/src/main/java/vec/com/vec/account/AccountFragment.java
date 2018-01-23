package vec.com.vec.account;

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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vec.com.vec.R;
import vec.com.vec.account.bean.AccountInfo;
import vec.com.vec.base.BaseFragment;

/**
 * Created by xumin on 2018/1/22.
 */

public class AccountFragment extends BaseFragment {
    private SwipeRefreshLayout vSwipeRefreshLayout;
    private RecyclerView rvList;
    private AccountFragment.HomeAdapter mAdapter;
    private List<AccountInfo> mDatas=new ArrayList<>();
    private TextView pickAllTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contentView=inflater.inflate(R.layout.account_fram_layout,null);
        vSwipeRefreshLayout=contentView.findViewById(R.id.refresh_srl);
        rvList=contentView.findViewById(R.id.recycler_view);
        pickAllTv=contentView.findViewById(R.id.pick_all_tv);
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter=new AccountFragment.HomeAdapter();
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
        pickAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPick();
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
            AccountInfo info=new AccountInfo();
            info.viewCount="观看"+i+"条内容";
            info.date="2018-01-2"+i;
            if(i%2==0){
                info.time="today:";
            }else {
                info.time="yesterday:";
            }
            info.hour=i+".23";
            info.status=i%3;
            mDatas.add(info);
        }
        mAdapter.notifyDataSetChanged();
    }
    class HomeAdapter extends RecyclerView.Adapter<AccountFragment.HomeAdapter.MyViewHolder>
    {

        @Override
        public AccountFragment.HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            AccountFragment.HomeAdapter.MyViewHolder holder = new AccountFragment.HomeAdapter.MyViewHolder(LayoutInflater.from(
                getContext()).inflate(R.layout.account_item_layout, parent,
                false));
            return holder;
        }

        @Override
        public void onBindViewHolder(AccountFragment.HomeAdapter.MyViewHolder holder, int position)
        {
            AccountInfo info=mDatas.get(position);
            holder.viewCountTv.setText(info.viewCount);
            holder.timeTv.setText(info.time);
            holder.dateTv.setText(info.date);
            holder.hourTv.setText(info.hour);
            holder.pickUpTv.setVisibility(info.status==0?View.VISIBLE:View.GONE);
            holder.pickingUpTv.setVisibility(info.status==1?View.VISIBLE:View.GONE);
            holder.hadpickUpTv.setVisibility(info.status==2?View.VISIBLE:View.GONE);
            holder.pickUpTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gotoPick();
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

            TextView viewCountTv;
            TextView dateTv;
            TextView timeTv;
            TextView hourTv;
            TextView pickUpTv;
            TextView hadpickUpTv;
            TextView pickingUpTv;
            public MyViewHolder(View view)
            {
                super(view);
                viewCountTv = (TextView) view.findViewById(R.id.view_count_tv);
                timeTv = (TextView) view.findViewById(R.id.time_tv);
                dateTv = (TextView) view.findViewById(R.id.date_tv);
                hourTv = (TextView) view.findViewById(R.id.hour_tv);
                pickUpTv = (TextView) view.findViewById(R.id.pickup_tv);
                hadpickUpTv = (TextView) view.findViewById(R.id.had_pickup_tv);
                pickingUpTv = (TextView) view.findViewById(R.id.picking_up_tv);
            }
        }
    }

    private void gotoPick(){
        Intent intent=new Intent(getActivity(),PickActivity.class);
        startActivity(intent);
    }
}
