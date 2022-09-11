package com.example.enrollment.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
public class SystemItemImportRequest {
    List<Element> items;
    String updateDate;
}
