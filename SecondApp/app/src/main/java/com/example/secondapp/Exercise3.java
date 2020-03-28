package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondapp.model.Message;
import com.example.secondapp.model.PullParser;

import java.io.InputStream;
import java.util.List;

public class Exercise3 extends AppCompatActivity implements MyAdapter.ListItemClickListener{

    private static String TAG="yuhang";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Toast mToast;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);
        recyclerView=(RecyclerView) findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        //线性布局管理器
        layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        try{
            InputStream assetInput=getAssets().open("data.xml");
            List<Message> messages= PullParser.pull2xml(assetInput);

            // 声明Adapter
            mAdapter = new MyAdapter(messages,this);
            recyclerView.setAdapter(mAdapter);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                // 最后一个完全可见项的位置
                private int lastCompletelyVisibleItemPosition;

                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        if (visibleItemCount > 0 && lastCompletelyVisibleItemPosition >= totalItemCount - 1) {
                            Toast.makeText(Exercise3.this, "已滑动到底部!,触发loadMore", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        lastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
                    }
                    Log.d(TAG, "onScrolled: lastVisiblePosition=" + lastCompletelyVisibleItemPosition);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onListItemClick(int clickedItemIndex) {
        Log.d(TAG, "onListItemClick: "+Integer.toString(clickedItemIndex));
        Intent intent=new Intent(this,showNumbers.class);
        Bundle bundle=new Bundle();
        intent.putExtra("bundle",bundle);
        bundle.putString("position", Integer.toString(clickedItemIndex));
        startActivity(intent);
    }
}
