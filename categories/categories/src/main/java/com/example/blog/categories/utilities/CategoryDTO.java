package com.example.blog.categories.utilities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {

    private int categoryId;
    @NotBlank
    @Size(min = 4, message = "Minimum size of category title is 4 characters")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "Minimum size of category description is 10 characters")
    private String categoryDescription;

}
