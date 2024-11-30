package ru.netology;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// аннотация @RestController объединяет @Controller и @ResponseBody,
@RestController
// указывает базовый путь для всех маршрутов в контроллере.
@RequestMapping("/api/posts")

// класс принимающий запрос
public class PostController {
    private final PostService service; // сервис для работы с бизнес-логикой.

    // конструктор контроллера, который принимает сервис.
    public PostController(PostService service) {
        this.service = service;
    }

    // метод для обработки запроса на получение всех постов.
    @GetMapping // аннотация для обработки GET-запроса.
    public List<Post> all() {
        return service.all(); // возвращаем список постов.
    }

    // метод для обработки запроса на получение поста по id.
    @GetMapping("/{id}") // аннотация для обработки GET-запроса с параметром id.
    public Post getById(@PathVariable long id) {
        return service.getById(id); // возвращаем пост по id. Spring автоматически сериализует его в JSON.
    }

    // метод для обработки запроса на сохранение/обновление поста.
    @PostMapping // аннотация для обработки POST-запроса.
    public Post save(@RequestBody Post post) {
        return service.save(post); // сохраняем пост через сервис. Spring автоматически сериализует его в JSON.
    }

    // метод для обработки запроса на удаление поста по id.
    @DeleteMapping("/{id}") // аннотация для обработки DELETE-запроса с параметром id.
    public void removeById(@PathVariable long id) {
        service.removeById(id); // удаляем пост через сервис. Метод возвращает пустой ответ.
    }
}
