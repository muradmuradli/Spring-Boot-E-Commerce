package com.demo.furnishhub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Integer width;

    @NotNull
    @Positive
    private Integer height;

    @NotBlank
    @URL
    private String url;

    @NotBlank
    @Length(max = 50)
    private String filename;

    @NotNull
    @PositiveOrZero
    private Long size;

    @NotBlank
    @Length(max = 10)
    private String type;
}
