package com.spendkey.ecommerce.Models;
import java.util.ArrayList;
public class CategoryTree {
    Category category;
    ArrayList<CategoryTree> childCategories = new ArrayList<>();

    public CategoryTree(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public ArrayList<CategoryTree> getChildCategories() {
        return childCategories;
    }
    public void setChildCategories(CategoryTree childCategories) {
        this.childCategories.add(childCategories);
    }
}
