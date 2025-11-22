package com.example.webtodo.repository;

import com.example.webtodo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    // Kosong saja!
    // Spring Boot otomatis membuatkan fungsi: save(), findAll(), findById(), delete(), dll.
}