package com.ebeatsz.schoolproject.model;

public class CategoryItem {
    int itemid;
    int imageUrl;
    String department;

    public CategoryItem(Integer itemid, Integer imageUrl, String department) {
        this.itemid = itemid;
        this.imageUrl = imageUrl;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
