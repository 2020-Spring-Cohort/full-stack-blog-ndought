package org.wcci.blog.integrationTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void postsEndPointShouldBeOk() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/post", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void categoriesEndPointShouldBeOk() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/categories", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void tagsEndPointShouldBeOk() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/tags", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
