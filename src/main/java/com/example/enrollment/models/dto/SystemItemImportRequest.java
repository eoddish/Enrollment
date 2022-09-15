package com.example.enrollment.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemItemImportRequest {
    List<SystemItemImport> items;
    String updateDate;
}
