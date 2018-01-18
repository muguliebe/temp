package com.skcc.start.fwk;

import com.skcc.start.repository.jpa.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class AdviceTest {

    @Autowired
    TestRestTemplate template;

    @Autowired
    TransactionRepository repoTransaction;

    @Test
    public void 요청마다_거래건수_증가() {

        long countBefore = repoTransaction.count();

        ResponseEntity<String> response   = template.getForEntity("/codes", String.class);
        HttpStatus             statusCode = response.getStatusCode();

        System.out.println("statusCode = " + statusCode);
        assertThat(statusCode, equalTo(HttpStatus.OK));

        long countAfter = repoTransaction.count();
        log.info("countBefore = " + countBefore);
        log.info("countAfter = " + countAfter);

        assertThat(countAfter, greaterThan(countBefore));


    }
}
