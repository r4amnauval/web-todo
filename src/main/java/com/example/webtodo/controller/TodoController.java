package com.example.webtodo.controller;

import com.example.webtodo.model.TodoItem;
import com.example.webtodo.repository.TodoRepository;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private RuntimeService runtimeService;

    // 1. GET: Ambil semua data
    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    // 2. POST: Tambah data baru
    @PostMapping
    public TodoItem createTodo(@RequestBody TodoItem todo) {
        String processId = runtimeService.startProcessInstanceByKey("process_todo").getId();
        todo.setProcessInstanceId(processId);
        todo.setCompleted(false);
        return todoRepository.save(todo);
    }

    // 3. PUT: Update data (Untuk Edit Nama atau Checklist Selesai)
    @PutMapping("/{id}")
    public TodoItem updateTodo(@PathVariable Long id, @RequestBody TodoItem todoDetails) {
        return todoRepository.findById(id).map(todo -> {
            // Update nama jika ada kiriman nama baru
            if (todoDetails.getTaskName() != null) {
                todo.setTaskName(todoDetails.getTaskName());
            }
            // Update status checklist
            todo.setCompleted(todoDetails.isCompleted());

            return todoRepository.save(todo);
        }).orElse(null);
    }

    // 4. DELETE: Hapus data
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}