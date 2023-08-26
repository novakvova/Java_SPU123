package org.example.dto.category;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryCreateDTO {
    @NotBlank(message = "Назва є обов'язковою")
    private String name;
    @NotBlank(message = "Опис є обов'язковим")
    private String description;
}
