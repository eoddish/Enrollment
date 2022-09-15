package com.example.enrollment.repositories;

import com.example.enrollment.models.dto.SystemItem;
import com.example.enrollment.models.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ElementRepository extends JpaRepository<Element, String> {
}
