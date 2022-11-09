package com.fiba.inventory.business.dto;

public class CategoryDto {

    private long categoryId;
    private String categotyName;

    public CategoryDto() {
    }

    public CategoryDto(long categoryId, String categotyName) {
        this.categoryId = categoryId;
        this.categotyName = categotyName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategotyName() {
        return categotyName;
    }

    public void setCategotyName(String categotyName) {
        this.categotyName = categotyName;
    }
}
