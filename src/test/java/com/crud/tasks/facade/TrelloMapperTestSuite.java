package com.crud.tasks.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.trello.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrelloMapperTestSuite {

    //Mapper
    private static TrelloMapper trelloMapper;
    //Lists
    private static TrelloList list1;
    private static TrelloList list2;
    private static TrelloList list3;
    private static TrelloListDto dto1;
    private static TrelloListDto dto2;
    private static TrelloListDto dto3;
    private static List<TrelloList> lists;
    private static List<TrelloListDto> dtos;
    //Boards
    private static TrelloBoard board1;
    private static TrelloBoard board2;
    private static TrelloBoard board3;
    private static TrelloBoardDto boardDto1;
    private static TrelloBoardDto boardDto2;
    private static TrelloBoardDto boardDto3;
    private static List<TrelloBoard> boards;
    private static List<TrelloBoardDto> boardDtos;
    //Cards
    private static TrelloCard card1;
    private static TrelloCard card2;
    private static TrelloCard card3;
    private static TrelloCardDto cardDto1;
    private static TrelloCardDto cardDto2;
    private static TrelloCardDto cardDto3;

    @BeforeClass
    public static void createTestData() {
        //Mapper
        trelloMapper = new TrelloMapper();
        //Lists
        list1 = new TrelloList("1", "Name", true);
        list2 = new TrelloList("2", "1", false);
        list3 = new TrelloList(null, null, true);
        dto1 = new TrelloListDto("1", "Name", true);
        dto2 = new TrelloListDto("2", "1", false);
        dto3 = new TrelloListDto(null, null, true);
        lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);
        dtos.add(dto3);
        //Boards
        board1 = new TrelloBoard("1", "Trello1", lists);
        board2 = new TrelloBoard("", "", new ArrayList<>());
        board3 = new TrelloBoard(null, null, new ArrayList<>());
        boardDto1 = new TrelloBoardDto("1", "Trello1", dtos);
        boardDto2 = new TrelloBoardDto("", "", new ArrayList<>());
        boardDto3 = new TrelloBoardDto(null, null, new ArrayList<>());
        boards = new LinkedList<>();
        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
        boardDtos = new LinkedList<>();
        boardDtos.add(boardDto1);
        boardDtos.add(boardDto2);
        boardDtos.add(boardDto3);
        //Cards
        card1 = new TrelloCard("Trello Card", "New Trello Card", "pos1", "32");
        card2 = new TrelloCard("", "", "", "");
        card3 = new TrelloCard(null, null, null, null);
        cardDto1 = new TrelloCardDto("Trello Card", "New Trello Card", "pos1", "32");
        cardDto2 = new TrelloCardDto("", "", "", "");
        cardDto3 = new TrelloCardDto(null, null, null, null);
    }

    @Before
    public void init() {
        createTestData();
    }

    @Test
    public void testMappingToBoardDto() {
        //Given

        //When
        List<TrelloBoardDto> resultDtos = trelloMapper.mapToBoardsDto(boards);

        //Then
        Assert.assertEquals(boardDtos.size(), resultDtos.size());
        Assert.assertEquals(boardDto2.getName(), resultDtos.get(1).getName());
        Assert.assertEquals(boardDto3.getLists(), resultDtos.get(2).getLists());
        Assert.assertEquals(boardDto1.getId(), resultDtos.get(0).getId());
    }

    @Test
    public void testMappingToBoard() {
        //Given

        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(boardDtos);

        //Then
        Assert.assertEquals(boards.size(), result.size());
        Assert.assertEquals(boards.get(2).getName(), result.get(2).getName());
        Assert.assertEquals(boards.get(1).getLists(), result.get(1).getLists());
        Assert.assertEquals(boards.get(0).getId(), result.get(0).getId());
    }

    @Test
    public void testMappingToListDto() {
        //Given

        //When
        List<TrelloListDto> resultDtos = trelloMapper.mapToListsDto(lists);

        //Then
        Assert.assertEquals(dtos.size(), resultDtos.size());
        Assert.assertEquals(dto3.getName(), resultDtos.get(2).getName());
        Assert.assertEquals(dto2.isClosed(), resultDtos.get(1).isClosed());
        Assert.assertEquals(dto1.getId(), resultDtos.get(0).getId());
    }

    @Test
    public void testMappingToList() {
        //Given

        //When
        List<TrelloList> resultlist = trelloMapper.mapToList(dtos);

        //Then
        Assert.assertEquals(lists.size(), resultlist.size());
        Assert.assertEquals(list3.getName(), resultlist.get(2).getName());
        Assert.assertEquals(list2.isClosed(), resultlist.get(1).isClosed());
        Assert.assertEquals(list1.getId(), resultlist.get(0).getId());
    }

    @Test
    public void testMappingToCard() {
        //Given

        //When
        TrelloCard result1 = trelloMapper.mapToCard(cardDto1);
        TrelloCard result2 = trelloMapper.mapToCard(cardDto2);
        TrelloCard result3 = trelloMapper.mapToCard(cardDto3);
        //Them
        Assert.assertEquals(card1, result1);
        Assert.assertEquals(card1.getListId(), result1.getListId());
        Assert.assertEquals(card2.getDescription(), result2.getDescription());
        Assert.assertEquals(card3.getName(), result3.getName());
        Assert.assertEquals(card3.getPos(), result3.getPos());
    }

    @Test
    public void testMappingToCardDto() {
        //Given

        //When
        TrelloCardDto result1 = trelloMapper.mapToCardDto(card1);
        TrelloCardDto result2 = trelloMapper.mapToCardDto(card2);
        TrelloCardDto result3 = trelloMapper.mapToCardDto(card3);
        //Them
        Assert.assertEquals(cardDto1, result1);
        Assert.assertEquals(cardDto1.getListId(), result1.getListId());
        Assert.assertEquals(cardDto2.getDescription(), result2.getDescription());
        Assert.assertEquals(cardDto3.getName(), result3.getName());
        Assert.assertEquals(cardDto3.getPos(), result3.getPos());
    }
}
