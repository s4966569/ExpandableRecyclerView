package com.example.srt_qa.expandablerecyclerview.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sp on 17-7-28.
 */

public class KnowledgePointResponse {
    private StatusBean status;

    private List<KnowledgePointBean> data = new ArrayList<>();

    public List<KnowledgePointBean> getData() {
        return data;
    }

    public void setData(List<KnowledgePointBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
