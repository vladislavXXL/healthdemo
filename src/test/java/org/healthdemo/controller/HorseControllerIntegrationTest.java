package org.healthdemo.controller;

import org.healthdemo.entity.Horse;
import org.healthdemo.entity.Mare;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HorseControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/horse";
    private static final String ADD = "/add";
    private static final String DELETE = "/delete";
    private static final String UPDATE = "update";
    private static final String ALL = "/all";
    private static final String GET = "/get";

    @Test
    public void testAddAndGet() {
        Horse rysak = createHorse();
        RestTemplate template = new RestTemplate();
        ResponseEntity<Horse> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Horse.class,
                rysak.getId()
        );
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertNotNull(responseEntity.getBody());
    }

    private Horse createHorse() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Horse horse = prefillHorse();
        HttpEntity<Horse> entity = new HttpEntity<>(horse, headers);
        RestTemplate template = new RestTemplate();
        Horse createdHorse = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Horse.class
        ).getBody();
        Assert.assertNotNull(createdHorse);
        Assert.assertEquals("Rysak", createdHorse.getName());
        return createdHorse;
    }

    private Horse prefillHorse() {
        Horse horse = new Horse();
        horse.setName("Rysak");
        horse.setDescription("Fast");

        Mare  mare1 = new Mare();
        mare1.setName("Mashka");
        mare1.setDescription("Fire");

        Mare mare2 = new Mare();
        mare2.setName("Kashka");
        mare2.setDescription("Tasty");

        List<Mare> list = Arrays.asList(mare1, mare2);
        horse.setMares(list);
        return horse;
    }
}