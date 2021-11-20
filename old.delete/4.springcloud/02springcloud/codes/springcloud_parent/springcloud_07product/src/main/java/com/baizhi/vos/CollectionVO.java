package com.baizhi.vos;

import java.util.List;

//定义用来接收集合类型参数的对象
public class CollectionVO {

    private List<String> ids;//接收集合声明在这里

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
