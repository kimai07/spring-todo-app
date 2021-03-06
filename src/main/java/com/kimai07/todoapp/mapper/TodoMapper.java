package com.kimai07.todoapp.mapper;

import com.kimai07.todoapp.entity.TodoEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Insert("INSERT INTO todos (title, description, deadline, done) VALUES (#{title}, #{description}, #{deadline}, #{done})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(TodoEntity todo);

    @Update("UPDATE todos SET title = #{title}, description = #{description}, deadline = #{deadline}, done = #{done} WHERE id = #{id}")
    boolean update(TodoEntity todo);

    @Delete("DELETE FROM todos WHERE id = #{id}")
    void deleteById(Long id);

    @Select("SELECT id, title, description, deadline, done FROM todos WHERE id = #{id}")
    TodoEntity findById(Long id);

    @Select("SELECT id, title, description, deadline, done FROM todos LIMIT 100")
    List<TodoEntity> findAll();
}