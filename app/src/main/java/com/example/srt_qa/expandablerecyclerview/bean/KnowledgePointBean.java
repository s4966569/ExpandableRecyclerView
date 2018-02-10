package com.example.srt_qa.expandablerecyclerview.bean;

/**
 * Created by sp on 17-7-28.
 */

public class KnowledgePointBean extends Node<KnowledgePointBean> {
    protected String id;
    protected String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
