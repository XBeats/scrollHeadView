package com.aitangba.testproject.paging;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.aitangba.testproject.R;
import com.aitangba.testproject.paging.view.PagingRecyclerView;
import com.aitangba.testproject.paging.view.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fhf11991 on 2017/5/11.
 */

public class PagingRecyclerViewActivity extends AppCompatActivity {

    private Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging_recycler_view);
        PagingRecyclerView recyclerView = (PagingRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                Log.d("TAG", "onLoadMore ---");
                loadData();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter = new Adapter());

        View view = findViewById(R.id.emptyView);
        recyclerView.setEmptyView(view);

        TextView textView = new TextView(this);
        textView.setText("title");
        recyclerView.setHeaderView(textView);

        findViewById(R.id.emptyTextBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.mList.clear();
                mAdapter.notifyDataSetChanged();
            }
        });

        loadData();
    }

    private List<String> getData(int size) {
        List<String> list = new ArrayList<>(size);
        for(int i= 0; i< size ; i++) {
            list.add( "名字" + (i + page * 10));
        }
        return list;
    }

    private int page = 0;
    private void loadData() {
        page = page + 1;

        if(page > 3) return;
        findViewById(Window.ID_ANDROID_CONTENT).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(page == 1 || page == 2) {
                    mAdapter.setData(getData(10));
                } else if (page == 3) {
                    mAdapter.setData(getData(2));
                }

            }
        }, 2000);
    }

    static class Adapter extends RecyclerView.Adapter<ViewHolder> {

        private List<String> mList = new ArrayList<>();

        public void setData(List<String> items) {
            mList.addAll(items);
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_light_adapter, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.mTextView.setText(mList.get(position));

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mList.remove(position);
                    notifyDataSetChanged();
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.name_text);
        }
    }
}
