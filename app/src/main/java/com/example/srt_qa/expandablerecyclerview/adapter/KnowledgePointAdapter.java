package com.example.srt_qa.expandablerecyclerview.adapter;

import android.support.v7.widget.RecyclerView;

import com.example.srt_qa.expandablerecyclerview.bean.KnowledgePointBean;

import java.util.List;

/**
 * Created by sunpeng on 2018/2/10.
 */

public class KnowledgePointAdapter extends SimpleExpandableAdapter<KnowledgePointBean> {
    public KnowledgePointAdapter(List<KnowledgePointBean> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ((ExpandableViewHolder)holder).text.setText(mData.get(position).getName());
    }
}
