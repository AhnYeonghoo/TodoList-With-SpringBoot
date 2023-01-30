package todo.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoEntity> getList() {
        return this.todoRepository.findAll();
    }
}
