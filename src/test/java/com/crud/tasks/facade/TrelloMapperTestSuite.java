package com.crud.tasks.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.trello.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TrelloMapperTestSuite {

    @Test
    public void testMappingToBoardDto() {
        //Given
//        createTestData();
        TrelloMapper trelloMapper = new TrelloMapper();

        TrelloList list1 = new TrelloList("1", "Name", true);
        TrelloList list2 = new TrelloList("2", "1", false);
        TrelloList list3 = new TrelloList(null, null, true);
        TrelloListDto dto1 = new TrelloListDto("1", "Name", true);
        TrelloListDto dto2 = new TrelloListDto("2", "1", false);
        TrelloListDto dto3 = new TrelloListDto(null, null, true);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<TrelloListDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);
        dtos.add(dto3);

        TrelloBoard board1 = new TrelloBoard("1", "Trello1", lists);
        TrelloBoard board2 = new TrelloBoard("", "", new ArrayList<>());
        TrelloBoard board3 = new TrelloBoard(null, null, new ArrayList<>());
        TrelloBoardDto boardDto1 = new TrelloBoardDto("1", "Trello1", dtos);
        TrelloBoardDto boardDto2 = new TrelloBoardDto("", "", new ArrayList<>());
        TrelloBoardDto boardDto3 = new TrelloBoardDto(null, null, new ArrayList<>());
        List<TrelloBoard> boards = new LinkedList<>();
        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
        List<TrelloBoardDto> boardDtos = new LinkedList<>();
        boardDtos.add(boardDto1);
        boardDtos.add(boardDto2);
        boardDtos.add(boardDto3);
        //When
        List<TrelloBoardDto> resultDtos = trelloMapper.mapToBoardsDto(boards);

        //Then
        Assert.assertEquals(boardDtos.size(), resultDtos.size());
        Assert.assertEquals(boardDtos.get(1).getName(), resultDtos.get(1).getName());
        Assert.assertEquals(boardDtos.get(2).getLists(), resultDtos.get(2).getLists());
        Assert.assertEquals(boardDtos.get(0).getId(), resultDtos.get(0).getId());
    }

    @Test
    public void testMappingToBoard() {
        //Given
//        createTestData();
        TrelloMapper trelloMapper = new TrelloMapper();

        TrelloList list1 = new TrelloList("1", "Name", true);
        TrelloList list2 = new TrelloList("2", "1", false);
        TrelloList list3 = new TrelloList(null, null, true);
        TrelloListDto dto1 = new TrelloListDto("1", "Name", true);
        TrelloListDto dto2 = new TrelloListDto("2", "1", false);
        TrelloListDto dto3 = new TrelloListDto(null, null, true);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<TrelloListDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);
        dtos.add(dto3);

        TrelloBoard board1 = new TrelloBoard("1", "Trello1", lists);
        TrelloBoard board2 = new TrelloBoard("", "", new ArrayList<>());
        TrelloBoard board3 = new TrelloBoard(null, null, new ArrayList<>());
        TrelloBoardDto boardDto1 = new TrelloBoardDto("1", "Trello1", dtos);
        TrelloBoardDto boardDto2 = new TrelloBoardDto("", "", new ArrayList<>());
        TrelloBoardDto boardDto3 = new TrelloBoardDto(null, null, new ArrayList<>());
        List<TrelloBoard> boards = new LinkedList<>();
        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
        List<TrelloBoardDto> boardDtos = new LinkedList<>();
        boardDtos.add(boardDto1);
        boardDtos.add(boardDto2);
        boardDtos.add(boardDto3);
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
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList list1 = new TrelloList("1", "Name", true);
        TrelloList list2 = new TrelloList("2", "1", false);
        TrelloList list3 = new TrelloList(null, null, true);
        TrelloListDto dto1 = new TrelloListDto("1", "Name", true);
        TrelloListDto dto2 = new TrelloListDto("2", "1", false);
        TrelloListDto dto3 = new TrelloListDto(null, null, true);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<TrelloListDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);
        dtos.add(dto3);
//        createTestData();
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
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloListDto dto1 = new TrelloListDto("1", "Name", true);
        TrelloListDto dto2 = new TrelloListDto("2", "1", false);
        TrelloListDto dto3 = new TrelloListDto(null, null, true);
        TrelloList list1 = new TrelloList("1", "Name", true);
        TrelloList list2 = new TrelloList("2", "1", false);
        TrelloList list3 = new TrelloList(null, null, true);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        List<TrelloListDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);
        dtos.add(dto3);

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
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard card1 = new TrelloCard("Trello Card", "New Trello Card", "pos1", "32");
        TrelloCard card2 = new TrelloCard("", "", "", "");
        TrelloCard card3 = new TrelloCard(null, null, null, null);
        TrelloCardDto cardDto1 = new TrelloCardDto("Trello Card", "New Trello Card", "pos1", "32");
        TrelloCardDto cardDto2 = new TrelloCardDto("", "", "", "");
        TrelloCardDto cardDto3 = new TrelloCardDto(null, null, null, null);
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
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard card1 = new TrelloCard("Trello Card", "New Trello Card", "pos1", "32");
        TrelloCard card2 = new TrelloCard("", "", "", "");
        TrelloCard card3 = new TrelloCard(null, null, null, null);
        TrelloCardDto cardDto1 = new TrelloCardDto("Trello Card", "New Trello Card", "pos1", "32");
        TrelloCardDto cardDto2 = new TrelloCardDto("", "", "", "");
        TrelloCardDto cardDto3 = new TrelloCardDto(null, null, null, null);
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

//    @Before
//    public void createTestData() {
//        //Mapper
//        TrelloMapper trelloMapper = new TrelloMapper();
//        //Lists
//        TrelloList list1 = new TrelloList("1", "Name", true);
//        TrelloList list2 = new TrelloList("2", "1", false);
//        TrelloList list3 = new TrelloList(null, null, true);
//        TrelloListDto dto1 = new TrelloListDto("1", "Name", true);
//        TrelloListDto dto2 = new TrelloListDto("2", "1", false);
//        TrelloListDto dto3 = new TrelloListDto(null, null, true);
//        List<TrelloList> lists = new ArrayList<>();
//        lists.add(list1);
//        lists.add(list2);
//        lists.add(list3);
//        List<TrelloListDto> dtos = new ArrayList<>();
//        dtos.add(dto1);
//        dtos.add(dto2);
//        dtos.add(dto3);
//        //Boards
//        TrelloBoard board1 = new TrelloBoard("1", "Trello1", lists);
//        TrelloBoard board2 = new TrelloBoard("", "", new ArrayList<>());
//        TrelloBoard board3 = new TrelloBoard(null, null, null);
//        TrelloBoardDto boardDto1 = new TrelloBoardDto("1", "Trello1", dtos);
//        TrelloBoardDto boardDto2 = new TrelloBoardDto("", "", new ArrayList<>());
//        TrelloBoardDto boardDto3 = new TrelloBoardDto(null, null, null);
//        List<TrelloBoard> boards = new LinkedList<>();
//        boards.add(board1);
//        boards.add(board2);
//        boards.add(board3);
//        List<TrelloBoardDto> boardDtos = new LinkedList<>();
//        boardDtos.add(boardDto1);
//        boardDtos.add(boardDto2);
//        boardDtos.add(boardDto3);
//        //Cards
//        TrelloCard card1 = new TrelloCard("Trello Card","New Trello Card", "pos1", "32");
//        TrelloCard card2 = new TrelloCard("","", "", "");
//        TrelloCard card3 = new TrelloCard(null,null, null, null);
//        TrelloCardDto cardDto1 = new TrelloCardDto("Trello Card","New Trello Card", "pos1", "32");
//        TrelloCardDto cardDto2 = new TrelloCardDto("","", "", "");
//        TrelloCardDto cardDto3 = new TrelloCardDto(null,null, null, null);
//    }
}
