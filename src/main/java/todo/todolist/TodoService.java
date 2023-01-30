package todo.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoEntity> getList() {
        return this.todoRepository.findAll();
    }

    public void create(String content) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setContent(content);
        todoEntity.setCompleted(false);
        this.todoRepository.save(todoEntity);
    }

    public void delete(Integer id) {
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("해당 아이템이 없습니다. id=" + id)));
        this.todoRepository.delete(todoEntity);
    }

    @Transactional
    public void update(Integer id, String content) {
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다 id="+ id));
        todoEntity.setContent(content);
        this.todoRepository.save(todoEntity );
    }
}
