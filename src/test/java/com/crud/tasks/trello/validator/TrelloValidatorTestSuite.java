package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TrelloValidatorTestSuite {

    @InjectMocks
    private TrelloValidator validator;

    @Test
    public void validateTrelloBoardsTest() {
        //Given
        List<TrelloBoard> boards = new LinkedList<>();
        TrelloList list1 = new TrelloList("1", "test", false);
        List<TrelloList> lists = new LinkedList<>();
        lists.add(list1);
        TrelloBoard board1 = new TrelloBoard("1", "test", lists);
        TrelloBoard board2 = new TrelloBoard("2", "not_test", lists);
        boards.add(board1);     boards.add(board2);
        //When
        List<TrelloBoard> result = validator.validateTrelloBoards(boards);

        //Then
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(board2, result.get(result.lastIndexOf(board2)));
    }


}