package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {
    private TodoRepository todoRepository;

    @Autowired
    public void todoRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/todos/add", method = RequestMethod.GET)
    public String createTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "edit";
    }

    @RequestMapping(path = "/todos", method = RequestMethod.POST)
    public String saveTodo(Todo todo) {
        todoRepository.save(todo);
        //return  "redirect:/";
        return "redirect:/todos";
    }

    @RequestMapping(path = "/todos", method = RequestMethod.GET)
    public String getAllTodos(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todos";
    }

    @RequestMapping(path = "/todos/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") Integer id) {
        model.addAttribute("todo", todoRepository.findById(id));
        return "edit";
    }

    @RequestMapping(path = "/todos/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") Integer id) {
        todoRepository.deleteById(id);
        return "redirect:/todos";
    }

}
