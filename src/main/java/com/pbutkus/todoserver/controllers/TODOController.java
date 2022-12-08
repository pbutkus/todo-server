package com.pbutkus.todoserver.controllers;

import com.pbutkus.todoserver.models.TODO;
import com.pbutkus.todoserver.services.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TODOController {

    @Autowired
    TODOService todoService;

    @PostMapping("/todo")
    public ResponseEntity<TODO> createNewTodo(@RequestBody TODO todo) {
        todoService.save(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TODO>> getAllTodos() {
        return new ResponseEntity<>(todoService.getAllTodosSorted(), HttpStatus.OK);
    }

    @PutMapping("/todo")
    public ResponseEntity<TODO> updateTodo(@RequestBody TODO todo) {
        TODO todoToUpdate = todoService.getTodoById(todo.getId());

        if (todoToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        todoService.save(todo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<TODO> deleteTodo(@PathVariable String id) {
        TODO todoToDelete = todoService.getTodoById(UUID.fromString(id));

        if (todoToDelete == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        todoService.delete(todoToDelete);

        return new ResponseEntity<>(todoToDelete, HttpStatus.OK);
    }

}
