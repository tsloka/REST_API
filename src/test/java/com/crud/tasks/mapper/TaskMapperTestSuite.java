package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {
    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto1 = new TaskDto(0L, "title", "Content");
        TaskDto taskDto2 = new TaskDto(null, null, null);
        Task task1 = new Task(0L, "title", "Content");
        Task task2 = new Task(null, null, null);
        //When
        Task result1 = taskMapper.mapToTask(taskDto1);
        Task result2 = taskMapper.mapToTask(taskDto2);
        //Then
        Assert.assertEquals(task1, result1);
        Assert.assertEquals(task2, result2);
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        TaskDto taskDto1 = new TaskDto(0L, "title", "Content");
        TaskDto taskDto2 = new TaskDto(null, null, null);
        Task task1 = new Task(0L, "title", "Content");
        Task task2 = new Task(null, null, null);
        //When
        TaskDto result1 = taskMapper.mapToTaskDto(task1);
        TaskDto result2 = taskMapper.mapToTaskDto(task2);
        //Then
        Assert.assertEquals(taskDto1, result1);
        Assert.assertEquals(taskDto2, result2);
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        TaskDto taskDto1 = new TaskDto(0L, "title", "Content");
        TaskDto taskDto2 = new TaskDto(null, null, null);
        Task task1 = new Task(0L, "title", "Content");
        Task task2 = new Task(null, null, null);
        List<Task> tasks = new LinkedList<>();
        tasks.add(task1);
        tasks.add(task2);
        List<TaskDto> taskDtos = new LinkedList<>();
        taskDtos.add(taskDto1);
        taskDtos.add(taskDto2);
        //When
        List<TaskDto> result = taskMapper.mapToTaskDtoList(tasks);
        //Then
        result.forEach(taskDto -> {
            Assert.assertEquals(taskDtos.get(result.indexOf(taskDto)).getId(), taskDto.getId());
            Assert.assertEquals(taskDtos.get(result.indexOf(taskDto)).getId(), taskDto.getId());
            Assert.assertEquals(taskDtos.get(result.indexOf(taskDto)).getId(), taskDto.getId());
        });
    }
}
