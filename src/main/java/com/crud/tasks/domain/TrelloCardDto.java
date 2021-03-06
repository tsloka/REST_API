package com.crud.tasks.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class TrelloCardDto {

    private String name;
    private String description;
    private String pos;
    private String listId;

}
