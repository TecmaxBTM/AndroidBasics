package com.hotstar.corngenerator.retrofit.model;

import java.util.ArrayList;

public class CollectionResponse {
    private ArrayList<CollectionData> collections;
    private String display_text;
    private int has_more;
    private int has_total;
    private String share_url;

    public ArrayList<CollectionData> getCollections() {
        return collections;
    }

    public void setCollections(ArrayList<CollectionData> collections) {
        this.collections = collections;
    }

    public String getDisplay_text() {
        return display_text;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public int getHas_total() {
        return has_total;
    }

    public void setHas_total(int has_total) {
        this.has_total = has_total;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }
}

class CollectionData {
    private Collection collection;

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}

class Collection {
    private int collection_id;
    private String description;
    private String image_url;
    private int res_count;
    private String share_url;
    private String title;
    private String url;

    public int getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getRes_count() {
        return res_count;
    }

    public void setRes_count(int res_count) {
        this.res_count = res_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}