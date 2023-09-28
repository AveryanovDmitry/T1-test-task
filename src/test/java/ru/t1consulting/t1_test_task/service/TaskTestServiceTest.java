package ru.t1consulting.t1_test_task.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class TaskTestServiceTest {
    private final TestTaskService testTaskService;

    @Test
    void countCharacters() {
        assertThat("\"a\": 5, \"c\": 3, \"b\": 1")
                .isEqualTo(testTaskService.countCharacters("aaaaabccc"));

        assertThat("\"S\": 2, \"G\": 1, \"o\": 3")
                .isNotEqualTo(testTaskService.countCharacters("sgosoo"));

        assertThat("\"o\": 3, \"S\": 2, \"G\": 1")
                .isEqualTo(testTaskService.countCharacters("SGoSoo"));

        assertThat("\"a\": 2, \"b\": 2, \"c\": 2, \"d\": 2")
                .isEqualTo(testTaskService.countCharacters("aaccddbb"));
    }
}
