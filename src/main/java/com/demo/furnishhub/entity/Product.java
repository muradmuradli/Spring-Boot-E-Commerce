package com.demo.furnishhub.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(max = 50)
    private String name;

    @NotNull
    @PositiveOrZero
    private Integer stock;

    @NotNull
    @Positive
    private BigDecimal price;

    @ElementCollection
    @NotEmpty
    private List<String> colors;

    @NotBlank
    @Length(max = 50)
    private String category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @NotNull
    @Min(0)
    private Integer reviews;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "5.0")
    private Double stars;

    @NotBlank
    @Length(max = 500)
    private String description;

    @NotBlank
    @Length(max = 50)
    private String company;
}

