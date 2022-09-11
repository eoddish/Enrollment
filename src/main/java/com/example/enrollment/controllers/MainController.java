package com.example.enrollment.controllers;


import com.example.enrollment.exceptions.ElementNotFoundException;
import com.example.enrollment.models.Element;
import com.example.enrollment.models.Response;
import com.example.enrollment.models.SystemItemImportRequest;
import com.example.enrollment.repositories.ElementRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
class MainController {

    private final ElementRepository repository;

    public MainController(ElementRepository repository) {
        this.repository = repository;
    }
/*
    @RequestMapping( "/item" )
    public String getStockItem() {
        return "It's working...!";
    }
*/
    @PostMapping("/imports")
    Response newElement(@RequestBody SystemItemImportRequest systemItemImportRequest) throws IOException {
/*
        final String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        newElement.saveElement(baseUrl);
*/
        List<Element> list = systemItemImportRequest.getItems();
        for (int i = 0; i < list.size(); i++) {
        list.get(i).setDate(systemItemImportRequest.getUpdateDate());
            repository.save(list.get(i));

        }
        return new Response(200, "Done");
    }


    @DeleteMapping("/delete/{id}")
    void deleteNode(@PathVariable String id) {
        repository.deleteById(id);
        return;
    }

    @GetMapping("/nodes/{id}")
    Element findNode(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id));
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
