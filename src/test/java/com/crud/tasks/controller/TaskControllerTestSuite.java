package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void shouldReturnTasksTest() throws Exception {
        //Given
        List<Task> tasks = new LinkedList<>();
        tasks.add(new Task(1L, "titel1", "what the hell"));
        tasks.add(new Task(2L, "titel2", "what the"));
        List<TaskDto> taskDtos = new LinkedList<>();
        taskDtos.add(new TaskDto(1L, "titel1", "what the hell"));
        taskDtos.add(new TaskDto(2L, "titel2", "what the"));

        when(service.getAllTasks()).thenReturn(tasks);
        when(taskMapper.mapToTaskDtoList(tasks)).thenReturn(taskDtos);
        //When & then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("titel1")))
                .andExpect(jsonPath("$[0].content", is("what the hell")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("titel2")))
                .andExpect(jsonPath("$[1].content", is("what the")));
    }

    @Test
    public void shouldReturnSingleTaskTest() throws Exception {
        //Given
        Task task1 = new Task(1L, "titel1", "what the hell");
        TaskDto taskDto1 = new TaskDto(1L, "titel1", "what the hell");
        Gson longVal = new Gson();
        when(service.getTaskById(1L)).thenReturn(java.util.Optional.of(task1));
        when(taskMapper.mapToTaskDto(task1)).thenReturn(taskDto1);
        //When & then
        mockMvc.perform(get("/v1/task/getTask").contentType(MediaType.APPLICATION_JSON)
                .param("taskId", longVal.toJson(1L)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("titel1")))
                .andExpect(jsonPath("$.content", is("what the hell")));
    }

    @Test
    public void shouldDeleteTaskTest() throws Exception {
        //Given
        Gson longVal = new Gson();
        //When & then
        mockMvc.perform(delete("/v1/task/deleteTask").contentType(MediaType.APPLICATION_JSON)
                .param("taskId", longVal.toJson(1L)))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldUpdateTask() throws Exception {
        //Given
        Task task1 = new Task(1L, "titel1", "what the hell");
        TaskDto taskDto1 = new TaskDto(1L, "titel1", "what the hell");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto1);
        when(service.saveTask(task1)).thenReturn(task1);
        when(taskMapper.mapToTask(taskDto1)).thenReturn(task1);
        when(taskMapper.mapToTaskDto(task1)).thenReturn(taskDto1);
        //When & then
        mockMvc.perform(put("/v1/task/updateTask").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldCreateTask() throws Exception {
        //Given
        Task task1 = new Task(1L, "titel1", "what the hell");
        TaskDto taskDto1 = new TaskDto(1L, "titel1", "what the hell");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(task1);
        when(service.saveTask(task1)).thenReturn(task1);
        when(taskMapper.mapToTaskDto(task1)).thenReturn(taskDto1);
        when(taskMapper.mapToTask(taskDto1)).thenReturn(task1);
        //When & then
        mockMvc.perform(post("/v1/task/createTask").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    public void shouldThrowException() throws Exception {
        //Given
        Gson longVal = new Gson();
        given(service.getTaskById(1L)).willAnswer(invocation -> {
            throw new TaskNotFoundException();
        });
        //When & then
        try {
            mockMvc.perform(get("/v1/task/getTask")
                    .contentType(MediaType.APPLICATION_JSON)
                    .param("taskId", longVal.toJson(1L)));
        } catch (Exception e) {
            Assert.assertEquals(TaskNotFoundException.class, e.getCause().getClass());
        }
    }
}