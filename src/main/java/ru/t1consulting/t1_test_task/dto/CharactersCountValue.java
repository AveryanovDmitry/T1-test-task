package ru.t1consulting.t1_test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CharactersCountValue implements Comparable<CharactersCountValue> {
    private final char character;
    private int count;

    public void incrementCount() {
        count += 1;
    }

    @Override
    public int compareTo(CharactersCountValue o) {
        int res = o.getCount() - this.count;
        if (res == 0) {
            return this.character - o.character;
        }
        return res;
    }

    @Override
    public String toString() {
        return String.format("\"%s\": %d", character, count);
    }

    @Override
    public int hashCode() {
        return character;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        CharactersCountValue guest = (CharactersCountValue) obj;
        return character == guest.getCharacter();
    }
}
