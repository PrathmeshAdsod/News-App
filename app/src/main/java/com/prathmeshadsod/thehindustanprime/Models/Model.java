package com.prathmeshadsod.thehindustanprime.Models;

public class Model {

    /* All data result that we are want to fetch */

    private String title ,image_url , description ,pubDate ,   link ,  source_id ;

    int imageId;   // If image_url is null in API then we have to give default image

    // We don't need content on front page that's why not taken it here
    // We don't need keywords also and creator also

    public Model(String title, String image_url,  String description, String pubDate,  String creator, String link, String source_id) {
        this.title = title;
        this.image_url = image_url;
        this.description = description;
        this.pubDate = pubDate;

        this.link = link;
        this.source_id = source_id;
    }

    // If image_url is null in API then we have to give default image
    // We will do it with the help of Glide Library in Adapter created for Recycler view

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String putDate) {
        this.pubDate = putDate;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }
}
