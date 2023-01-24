package com.charter.rewardsProgram.controller;

import com.charter.rewardsProgram.RewardPointsApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RewardPointsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RewardsControllerIntegrationTest {

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    @Test
    public void testRetrieveStudentCourse() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response =
                restTemplate.exchange(createURLWithPort("/customers/1/rewards"), HttpMethod.GET, entity, String.class);

        String expected =
                "{\"customerId\":1,\"lastMonthRewardPoints\":170,\"lastSecondMonthRewardPoints\":96,\"lastThirdMonthRewardPoints\":27,\"totalRewards\":293}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
