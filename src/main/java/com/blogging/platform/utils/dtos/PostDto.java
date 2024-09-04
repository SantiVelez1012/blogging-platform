package com.blogging.platform.utils.dtos;

import java.util.List;

public class PostDto {

    private String title;
    private String content;
    private String category;
    private List<String> tags;

    public PostDto() {
    }

    public PostDto(String title, String content, String category, List<String> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
