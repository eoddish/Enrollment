package com.example.enrollment.controllers;


import com.example.enrollment.exceptions.ElementNotFoundException;
import com.example.enrollment.models.dto.SystemItem;
import com.example.enrollment.models.dto.Response;
import com.example.enrollment.models.dto.SystemItemImport;
import com.example.enrollment.models.dto.SystemItemImportRequest;
import com.example.enrollment.models.entity.Element;
import com.example.enrollment.repositories.ElementRepository;
import com.example.enrollment.utils.MappingUtils;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

@RestController
@Data
class MainController {

    private final ElementRepository repository;
    private final MappingUtils mappingUtils;;

    @PostMapping("/imports")
    Response newElement(@RequestBody SystemItemImportRequest systemItemImportRequest) throws IOException, InterruptedException {
        List<SystemItemImport> list = systemItemImportRequest.getItems();
        for (int i = 0; i < list.size(); i++) {
            SystemItemImport systemItemImport = list.get(i);
            Element element = mappingUtils.systemItemImportToElement(systemItemImport);
            element.setDate(systemItemImportRequest.getUpdateDate());

/*
            String parentId = element.getParentId();
            if (parentId != null) {
                Element parent = repository.getReferenceById(element.getParentId());
                if (parent != null) {
                    element.setParent(parent);
                    List<Element> list1 = parent.getChildren();
                    if (list1 == null)
                        list1 = new ArrayList<>();
                    list1.add(element);
                    parent.setChildren(list1);
                }
            }
*/

            repository.save(element);
        }

        return new Response(200, "Done");
    }


    @DeleteMapping("/delete/{id}")
    void deleteNode(@PathVariable String id) {
        repository.deleteById(id);
    }

    @GetMapping("/nodes/{id}")
    SystemItem findNode(@PathVariable String id) {

        Element element = repository.getReferenceById(id);
        return mappingUtils.elementToSystemItem(element);
    }
/*
    @GetMapping("/updates")
    Employee one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @GetMapping("/nodes/{id}/history")
    Employee one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
*/
}
