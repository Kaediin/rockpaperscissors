package model;

import java.util.Arrays;

public enum Hand {
    ROCK("R"), PAPER("P"), SCISSORS("S");

    private final String value;

    Hand(String value) {
        this.value = value;
    }

    /**
     * Matches the letter given to a hand enum. This method is case-insensitive.
     * @param letter: Any letter given
     * @return Hand enum or null if invalid
     */
    public static Hand getHandByLetter(String letter) {
        Hand[] values = Hand.values();
        if (Arrays.stream(values).noneMatch(val -> val.value.equalsIgnoreCase(letter))) {
            return null;
        }

        for (int i = 0; i < Hand.values().length; i++) {
            if (Hand.values()[i].value.equalsIgnoreCase(letter)) {
                return Hand.values()[i];
            }
        }
        return null;
    }
}
