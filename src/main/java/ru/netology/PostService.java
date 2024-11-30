package ru.netology;

import org.springframework.stereotype.Service; // Аннотация для обозначения класса как сервиса
import java.util.List;

@Service // Аннотация, указывающая, что класс является сервисом для бизнес-логики
public class PostService {
    private final PostRepository repository; // Ссылка на репозиторий, который будет обрабатывать данные

    // Конструктор для инжекции зависимости
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        // Получает все посты через репозиторий
        return repository.all();
    }

    public Post getById(long id) {
        // Возвращаем пост по идентификатору или выбрасываем исключение, если пост не найден
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        // Сохраняет или обновляет пост через репозиторий
        return repository.save(post);
    }

    public void removeById(long id) {
        // Удаляет пост по идентификатору через репозиторий
        repository.removeById(id);
    }
}
