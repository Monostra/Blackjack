package ua.com.blackJack;

/**
 * Created by Mykhailo on 21/12/2017.
 */
public class SuiteCard {

    public static CardSuits getCardSuiteNumber(int number) {
        CardSuits cardSuits = CardSuits.HEART;
        switch (number) {
            case 1:
                cardSuits = CardSuits.HEART;
                break;
            case 2:
                cardSuits = CardSuits.DIAMOND;
                break;
            case 3:
                cardSuits = CardSuits.CLUB;
                break;
            case 4:
                cardSuits = CardSuits.SPADE;
                break;
        }
        return cardSuits;
    }

    public static CardSuits getRandomCardSuite() {
        int number = (int)(Math.random()*4)+1;
        return getCardSuiteNumber(number);
    }

    public static String getCardSuiteSymbol(CardSuits cardSuits) {
        String symbol;

        switch (cardSuits) {
            case HEART: symbol = "♥"; break;
            case DIAMOND: symbol = "♦"; break;
            case CLUB: symbol = "♣"; break;
            case SPADE: symbol = "♠"; break;
            default: symbol = "";
        }
        return symbol;
    }

}
