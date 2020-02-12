package com.example.todo.boot;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private TodoRepository todoRepository;

    @Autowired
    public void productRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Todo todo1 = new Todo();
        todo1.setTitle("Meeting");
        todo1.setDescription("Have a meeting with Java stack guys.");
        todo1.setStatus("PENDING");
        todoRepository.save(todo1);

        Todo todo2 = new Todo();
        todo2.setTitle("Algorithm solving");
        todo2.setDescription("Finish up the algorithm exercises later in the day");
        todo2.setStatus("PENDING");
        todoRepository.save(todo2);
    }

}
