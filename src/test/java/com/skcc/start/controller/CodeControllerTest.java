package com.skcc.start.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CodeControllerTest {

    @Autowired
    TestRestTemplate template;

    @Test
    public void 코드조회상태_정상() {
        ResponseEntity<String> response   = template.getForEntity("/codes", String.class);
        HttpStatus             statusCode = response.getStatusCode();

        System.out.println("statusCode = " + statusCode);
        assertThat(statusCode, equalTo(HttpStatus.OK));

    }

//    @Test
    public void 코드조회결과값비교_정상() {
        ResponseEntity<String> response   = template.getForEntity("/codes", String.class);
        HttpStatus             statusCode = response.getStatusCode();

        String body = response.getBody();
        assertThat(body, equalTo("good"));
    }

}
