package com.example.blog.categories.utilities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {

    private int categoryId;
    private String categoryTitle;
    private String categoryDescription;

}
