package com.example.enrollment.utils;

import com.example.enrollment.models.dto.SystemItem;
import com.example.enrollment.models.dto.SystemItemImport;
import com.example.enrollment.models.dto.SystemItemType;
import com.example.enrollment.models.entity.Element;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MappingUtils {
    public SystemItem elementToSystemItem(Element entity){
        SystemItem dto = new SystemItem();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        dto.setParentId(entity.getParentId());
        dto.setType(entity.getType());
        dto.setSize(entity.getSize());
        dto.setDate(entity.getDate());
        dto.setParent(entity.getParent());
        dto.setChildren(entity.getChildren());
        return dto;
    }
    public Element systemItemToElement(SystemItem dto){
        Element entity = new Element();
        entity.setId(dto.getId());
        entity.setId(dto.getId());
        entity.setUrl(dto.getUrl());
        entity.setParentId(dto.getParentId());
        entity.setType(dto.getType());
        entity.setSize(dto.getSize());
        entity.setDate(dto.getDate());
        entity.setParent(dto.getParent());
        entity.setChildren(dto.getChildren());
        return entity;
    }
    public SystemItemImport elementToSystemItemImport(Element entity){
        SystemItemImport dto = new SystemItemImport();
        dto.setId(entity.getId());
        dto.setUrl(entity.getUrl());
        dto.setParentId(entity.getParentId());
        dto.setType(entity.getType());
        dto.setSize(entity.getSize());
        return dto;
    }
    public Element systemItemImportToElement(SystemItemImport dto){
        Element entity = new Element();
        entity.setId(dto.getId());
        entity.setId(dto.getId());
        entity.setUrl(dto.getUrl());
        entity.setParentId(dto.getParentId());
        entity.setType(dto.getType());
        entity.setSize(dto.getSize());
        return entity;
    }
}
