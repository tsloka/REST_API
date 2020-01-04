package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.scheduler.EmailScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTestSuite {

    @InjectMocks
    private EmailScheduler emailScheduler;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void sendScheduledEmailTest() {
        //Given
        when(taskRepository.count()).thenReturn(1L);
        Mail mail = new Mail(adminConfig.getAdminMail(),
                "Tasks: Once a day email", "Currently in database you have: only one task.");
        //When
        emailScheduler.sendInformationEmail();
        //Then
        Mockito.verify(emailService, Mockito.times(1))
                .send(mail);

    }
}
