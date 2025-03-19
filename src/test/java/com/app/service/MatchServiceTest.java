package com.app.service;


import com.app.client.BesoccerClient;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



@QuarkusTest
public class MatchServiceTest {

    @Mock
    BesoccerClient besoccerClient;

    @InjectMocks
    MatchService matchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


}
