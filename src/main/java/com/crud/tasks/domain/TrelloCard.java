package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TrelloCard {
    private String name;
    private String description;
    private String pos;
    private String listId;

}
