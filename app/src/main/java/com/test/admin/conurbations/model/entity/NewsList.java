package com.test.admin.conurbations.model.entity;

import java.util.List;

/**
 * Created by laucherish on 16/3/15.
 */
public class NewsList extends Base{
    private String date;
    public List<News> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
