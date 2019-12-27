package com.crud.tasks.service;

import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    private TrelloService trelloService;

    @Test
    public void testFetchTrelloBoards() {
        //Given
        List<TrelloBoardDto> boardDtos = trelloService.fetchTrelloBoards();
        for (TrelloBoardDto boardDto: boardDtos) {
            System.out.println(boardDto.toString());
        }
        //When

        //Then


    }
}
