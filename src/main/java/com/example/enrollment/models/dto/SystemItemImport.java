package com.example.enrollment.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemItemImport {
    private String id;
    private String url;
    private String parentId;
    private SystemItemType type;
    private Integer size;
}
