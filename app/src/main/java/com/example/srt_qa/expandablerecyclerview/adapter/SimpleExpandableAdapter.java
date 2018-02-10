package com.example.srt_qa.expandablerecyclerview.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.srt_qa.expandablerecyclerview.bean.Node;
import com.example.srt_qa.expandablerecyclerview.R;
import com.example.srt_qa.expandablerecyclerview.utils.ScreenUtils;

import java.util.List;

/**
 * Created by sp on 17-7-31.
 */

public class SimpleExpandableAdapter<T extends Node> extends BaseExpandableRecyclerAdapter<T> {
    private int mIndentation;  //缩进
    public SimpleExpandableAdapter(List<T> data) {
        super(data);
    }

    @Override
    public ExpandableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mIndentation == 0)
            mIndentation = ScreenUtils.dpToPxInt(parent.getContext(), 50);
        return new ExpandableViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chapter, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mData.get(position).isExpanded()) {
            ((ExpandableViewHolder)holder).indicator.setImageResource(R.drawable.expand_normal);
        } else {
            ((ExpandableViewHolder)holder).indicator.setImageResource(R.drawable.collapse_normal);
        }
        if (mData.get(position).hasChildren()) {
            ((ExpandableViewHolder)holder).ll_indicator.setVisibility(View.VISIBLE);
        } else {
            ((ExpandableViewHolder)holder).ll_indicator.setVisibility(View.INVISIBLE);
        }
        setBackgroundByLevel(holder.itemView,mData.get(position).getLevel());
        setTextSizeByLevel(((ExpandableViewHolder)holder).text,mData.get(position).getLevel());
        ((ExpandableViewHolder)holder).ll_above.setPadding(mIndentation * mData.get(position).getLevel(),0,0,0);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private void setBackgroundByLevel(View itemView, int level){
        switch (level){
            case 0:
                itemView.setBackgroundColor(Color.parseColor("#ffffff"));
                break;
            case 1:
                itemView.setBackgroundColor(Color.parseColor("#fcfcfc"));
                break;
            case 2:
                itemView.setBackgroundColor(Color.parseColor("#f9f9f9"));
                break;
            case 3:
                itemView.setBackgroundColor(Color.parseColor("#f6f6f6"));
                break;
            default:
                itemView.setBackgroundColor(Color.parseColor("#f6f6f6"));
                break;
        }
    }

    private void setTextSizeByLevel(TextView textView, int level){
        switch (level){
            case 0:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
                break;
            case 1:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
                break;
            case 2:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
                break;
            case 3:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,13);
                break;
            default:
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,13);
                break;
        }
    }

    protected class ExpandableViewHolder extends RecyclerView.ViewHolder {

        public ImageView indicator;
        public TextView text;
        public View ll_indicator,ll_content,ll_above;

        public ExpandableViewHolder(final View itemView) {
            super(itemView);
            indicator = (ImageView) itemView.findViewById(R.id.indicator);
            text = (TextView) itemView.findViewById(R.id.text);
            ll_indicator = itemView.findViewById(R.id.ll_indicator);
            ll_content = itemView.findViewById(R.id.ll_content);
            ll_above = itemView.findViewById(R.id.ll_above);

            ll_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(itemView,getLayoutPosition(),mData.get(getLayoutPosition()));
                    }
                }
            });

            ll_indicator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mData.get(getLayoutPosition()).isExpanded()) {
                        indicator.setImageResource(R.drawable.collapse_normal);
                        collapse(getLayoutPosition(),true);
                    } else {
                        indicator.setImageResource(R.drawable.expand_normal);
                        expand(getLayoutPosition(),true);
                    }
                }
            });
        }
    }
}
