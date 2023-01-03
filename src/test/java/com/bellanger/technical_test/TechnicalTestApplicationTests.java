package com.bellanger.technical_test;

import com.bellanger.technical_test.controller.UserController;
import com.bellanger.technical_test.dto.commons.Gender;
import com.bellanger.technical_test.dto.request.UserRequest;
import com.bellanger.technical_test.dto.response.UserResponse;
import com.bellanger.technical_test.exception.controller.ControllerAdvisor;
import com.bellanger.technical_test.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TechnicalTestApplicationTests {

    @InjectMocks
    private UserController userController;

    ObjectMapper mapper;
    @Mock
    UserService userService;

    MockMvc mockMvc;

    @BeforeAll
    public void init() {
        mockMvc = standaloneSetup(userController).setControllerAdvice(ControllerAdvisor.class).build();
        this.mapper = new ObjectMapper();
    }

    @AfterAll
    public void tearDown() {
    }

    @Test
    public void postUserFailedUnderEighteen() {
        UserRequest userRequest = new UserRequest(1L, "username", "FRA", new Timestamp(System.currentTimeMillis()), Gender.MALE, "06.06.06.05.15");
        when(userService.createUser(userRequest)).thenReturn(1L);
        try {
            this.mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsBytes(userRequest))).andExpect(status().isBadRequest());
        } catch (Exception e) {
            Assertions.fail("Exception throwns:", e.getCause());
        }
    }

    @Test
    public void postUserOk() {
        UserRequest userRequest = new UserRequest(1L, "username", "FRA", Timestamp.valueOf("2004-09-23 10:10:10.0"), Gender.MALE, "06.06.06.05.15");
        when(userService.createUser(userRequest)).thenReturn(1L);
        try {
            this.mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsBytes(userRequest))).andExpect(status().is2xxSuccessful());
        } catch (Exception e) {
            Assertions.fail("Exception throwns:", e.getCause());
        }
    }

    @Test
    public void retrieveUserById() {
        UserResponse userResponse = new UserResponse("username", "FRA", new Timestamp(System.currentTimeMillis()), Gender.MALE, "06.06.06.05.15");
        when(userService.getUser(Mockito.anyLong())).thenReturn(userResponse);
        try {
            String result = this.mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            UserResponse userResult = mapper.readValue(result, UserResponse.class);
            Assertions.assertEquals(userResponse, userResult);
        } catch (Exception e) {
            Assertions.fail("Exception throwns:", e.getCause());
        }
    }

}
