package ru.t1consulting.t1_test_task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1consulting.t1_test_task.service.TestTaskService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestTaskController {
    private final TestTaskService testTaskService;

    @GetMapping
    public String getCountCharactersInString(@RequestParam(name = "string") String str) {
        log.info("Запрос на получение количества символов в строке {}", str);
        return testTaskService.countCharacters(str);
    }
}
