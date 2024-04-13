package com.example.DB_RestAPI;

import com.example.DB_RestAPI.controller.UserController;
import com.example.DB_RestAPI.model.UserEntity;
import com.example.DB_RestAPI.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {com.example.DB_RestAPI.application.RestApiApplication.class})
public class UserTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testObterTodos(){
        List<UserEntity> userEntityList = Arrays.asList(
                new UserEntity("1", "User1", "user1@example.com"),
                new UserEntity("1", "User2", "user2@example.com")
        );

        when (userService.obterTodos()).thenReturn(userEntityList);

        List<UserEntity> result = userController.obterTodos();

        assertEquals(userEntityList, result);
    }
    @Test
    void testObterPorId(){
        UserEntity user = new UserEntity(
                new UserEntity("1", "User1", "user1@example.com");

        when (userService.obterPorId("1")).thenReturn(user);

        UserEntity result = userController.obterPorId("1");

        assertEquals(user, result);
    }
    @Test
    void testInserir(){}
    @Test
    void testAtualizar(){}
    @Test
    void testExcluir(){}
}
