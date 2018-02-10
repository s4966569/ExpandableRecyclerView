package com.example.srt_qa.expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.srt_qa.expandablerecyclerview.adapter.KnowledgePointAdapter;
import com.example.srt_qa.expandablerecyclerview.bean.KnowledgePointBean;
import com.example.srt_qa.expandablerecyclerview.bean.KnowledgePointResponse;
import com.example.srt_qa.expandablerecyclerview.utils.FileUtils;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<KnowledgePointBean> mDataList;
    private RecyclerView mRecyclerView;
    private KnowledgePointAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTestData();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new KnowledgePointAdapter(mDataList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initTestData(){
        String jsonData = FileUtils.getDataFromAssets(this,"testdata");
        Gson gson = new Gson();
        KnowledgePointResponse response = gson.fromJson(jsonData,KnowledgePointResponse.class);
        mDataList = response.getData();
    }
}
