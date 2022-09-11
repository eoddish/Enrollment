package com.example.enrollment.repositories;

import com.example.enrollment.models.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, String> {
}
