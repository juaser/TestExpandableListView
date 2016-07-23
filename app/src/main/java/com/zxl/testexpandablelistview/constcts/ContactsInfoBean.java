package com.zxl.testexpandablelistview.constcts;


/**
 * @类说明：
 * @author：zxl
 * @CreateTime 2016/7/23.
 */
public class ContactsInfoBean {
    public int id;
    public String name;
    public String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "ContactsInfoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
