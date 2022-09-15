package com.example.enrollment.models.dto;

import com.example.enrollment.models.entity.Element;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemItem {
    private String id;
    private String url;
    private String parentId;
    private SystemItemType type;
    private Integer size;
    private String date;
    private Element parent;
    private List<Element> children;
}
