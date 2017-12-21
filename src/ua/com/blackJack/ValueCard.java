package ua.com.blackJack;

/**
 * Created by Mykhailo on 21/12/2017.
 */
public class ValueCard {

    public static CardValues getCardValueNumber(int number) {
        CardValues cardValues = CardValues.TWO;

        switch (number) {
            case 1: cardValues = CardValues.TWO; break;
            case 2: cardValues = CardValues.THREE; break;
            case 3: cardValues = CardValues.FOUR; break;
            case 4: cardValues = CardValues.FIVE; break;
            case 5: cardValues = CardValues.SIX; break;
            case 6: cardValues = CardValues.SEVEN; break;
            case 7: cardValues = CardValues.EIGHT; break;
            case 8: cardValues = CardValues.NINE; break;
            case 9: cardValues = CardValues.TEN; break;
            case 10: cardValues = CardValues.JACK; break;
            case 11: cardValues = CardValues.QUEEN; break;
            case 12: cardValues = CardValues.KING; break;
            case 13: cardValues = CardValues.ACE; break;
        }
        return cardValues;
    }

    public static CardValues getRandomCardValue() {
        int number = (int) (Math.random()*13)+1;
        return getCardValueNumber(number);
    }

    public static String getCardValue(CardValues cardValues) {
        String value;

        switch (cardValues) {
            case TWO: value = "2"; break;
            case THREE: value = "3"; break;
            case FOUR: value = "4"; break;
            case FIVE: value = "5"; break;
            case SIX: value = "6"; break;
            case SEVEN: value = "7"; break;
            case EIGHT: value = "8"; break;
            case NINE: value = "9"; break;
            case TEN: value = "10"; break;
            case JACK: value = "J"; break;
            case QUEEN: value = "Q"; break;
            case KING: value = "K"; break;
            case ACE: value = "A"; break;
            default: value = " "; break;
        }
        return value;
    }

    public static int getCardValueScore(CardValues cardValues) {
        int score = 0;
        switch (cardValues) {
            case TWO: score = 2; break;
            case THREE: score = 3; break;
            case FOUR: score = 4; break;
            case FIVE: score = 5; break;
            case SIX: score = 6; break;
            case SEVEN: score = 7; break;
            case EIGHT: score = 8; break;
            case NINE: score = 9; break;
            case TEN: score = 10; break;
            case JACK: score = 10; break;
            case QUEEN: score = 10; break;
            case KING: score = 10; break;
            case ACE: score = 11; break;
        }

        return score;
    }
}
