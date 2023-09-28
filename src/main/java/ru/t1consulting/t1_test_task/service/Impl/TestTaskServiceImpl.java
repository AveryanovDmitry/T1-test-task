package ru.t1consulting.t1_test_task.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.t1consulting.t1_test_task.dto.CharactersCountValue;
import ru.t1consulting.t1_test_task.service.TestTaskService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TestTaskServiceImpl implements TestTaskService {
    @Override
    public String countCharacters(String str) {
        Map<Character, CharactersCountValue> mapChar = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (mapChar.containsKey(tmp)) {
                mapChar.get(tmp).incrementCount();
            } else {
                mapChar.put(tmp, new CharactersCountValue(tmp, 1));
            }
        }

        String result = new ArrayList<>(mapChar.values()).stream().sorted()
                .map(CharactersCountValue::toString)
                .collect(Collectors.joining(", "));

        log.info("Количество символов в строке {}", result);

        return result;
    }
}
