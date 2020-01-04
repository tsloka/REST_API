package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.SpringVersion;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void shouldFetchTrelloBoardsTest() {
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test_list", false));

        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoardDto("1", "test", trelloLists));

        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoards);
        //When
        List<TrelloBoardDto> result = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1, result.size());
        assertEquals("1", result.get(0).getLists().get(0).getId());
        assertEquals("test_list", result.get(0).getLists().get(0).getName());
        assertEquals("test", result.get(0).getName());
    }

    @Test
    public void shouldCreateTrelloCardTest() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("name", "description", "pos", "1");
        CreatedTrelloCardDto createdCardDto = new CreatedTrelloCardDto("3", "new_name", "http://dont.give.a.shit");
        when(trelloClient.createNewCard(cardDto)).thenReturn(createdCardDto);
        //When
        CreatedTrelloCardDto result = trelloService.createTrelloCard(cardDto);
        //Then
        assertEquals(CreatedTrelloCardDto.class, result.getClass());
        assertEquals("new_name", result.getName());
        assertEquals("3", result.getId());
    }

    @Test
    public void createNullTrelloCardTest() {
        //Given
        //When
        CreatedTrelloCardDto result = trelloService.createTrelloCard(null);
        //Then
        verify(trelloClient, times(1)).createNewCard(null);
    }
}
