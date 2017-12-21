package ua.com.blackJack;

/**
 * Created by Mykhailo on 21/12/2017.
 */
public class CardView {
    public static final int CARD_LINE_COUNT = 5;

    public void drawFrontCard(CardSuits cardSuits, CardValues cardValues, int line) {
        String cardSuit = SuiteCard.getCardSuiteSymbol(cardSuits);
        String cardValueLeft = getCardValue(cardValues, 1);
        String cardValueRight = getCardValue(cardValues, -1);

        switch (line) {
            case 0: System.out.print("+-----+"); break;
            case 1: System.out.print("|"+cardValueLeft+"   | "); break;
            case 2: System.out.print("|  "+cardSuit+"  | "); break;
            case 3: System.out.print("|   "+cardValueRight+"| "); break;
            case 4: System.out.print("+-----+ "); break;
        }
    }

    private String getCardValue(CardValues cardValues, int direction) {
        String value = "";
        if (cardValues != CardValues.TEN && direction < 0) {
            value += " ";
        }
        value += ValueCard.getCardValue(cardValues);
        if (cardValues != CardValues.TEN && direction > 0) {
            value += " ";
        }
        return value;
    }

    public void drawBackCard(int line) {
        switch (line) {
            case 0: System.out.print("+-----+ "); break;
            case 1: System.out.print("|*****| "); break;
            case 2: System.out.print("|*****| "); break;
            case 3: System.out.print("|*****| "); break;
            case 4: System.out.print("+-----+ "); break;
        }
    }

    public void drawEndLine() {
        System.out.println();
    }
}
