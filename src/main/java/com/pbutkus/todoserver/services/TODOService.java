package com.pbutkus.todoserver.services;

import com.pbutkus.todoserver.models.TODO;
import com.pbutkus.todoserver.repositories.TODORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TODOService {

    private final TODORepository todoRepository;

    @Autowired
    public TODOService(TODORepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TODO save(TODO todo) {
        todoRepository.save(todo);
        return todo;
    }

    public List<TODO> getAllTodos() {
        return todoRepository.findAll();
    }

    public List<TODO> getAllTodosSorted() {
        return todoRepository.findAllByOrderByCreatedDesc();
    }

    public TODO getTodoById(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }

    public TODO delete(TODO todo) {
        todoRepository.delete(todo);

        return todo;
    }

}
