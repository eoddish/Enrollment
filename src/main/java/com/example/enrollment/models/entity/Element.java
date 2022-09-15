package com.example.enrollment.models.entity;

import com.example.enrollment.models.dto.SystemItem;
import com.example.enrollment.models.dto.SystemItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Element {
        @Id
        @Column(name="id") @NotNull
        private String id;
        @Column(name="url")
        private String url;
        @Column(name = "parentid")
        private String parentId;
        @Column(name="type")
        @Enumerated(EnumType.STRING)
        private SystemItemType type;
        @Column(name="size")
        private Integer size;
        @Column(name = "date")
        private String date;
        @ManyToOne
        private Element parent;
        @OneToMany(mappedBy = "parent")
        private List<Element> children;


    }
