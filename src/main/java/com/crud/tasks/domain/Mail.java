package com.crud.tasks.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private String toCc;
}
