package ua.com.blackJack;

/**
 * Created by Mykhailo on 21/12/2017.
 */
public class Playground {
    public final static int PC = 0;
    public final static int USER = 1;

    Card[][] playground = new  Card[26][2];

    public void newGame() {
        clearPlayGame();
        addCards(PC);
        addCards(USER);
    }

    private void clearPlayGame() {
        for (int i = 0; i < playground.length; i++) {
            playground[i][PC] = null;
            playground[i][USER] = null;
        }
    }

    private void addCards(int userId) {
        for (int i = 0; i < playground.length; i++) {
            playground[i][userId] = getRandomCard();
        }
    }

    private Card getRandomCard() {
        Card card;
        while (true) {
            CardSuits RcardSuits = SuiteCard.getRandomCardSuite();
            CardValues RcardValues = ValueCard.getRandomCardValue();
            Card randCard = new Card(RcardSuits, RcardValues);
            if (!isCardOnPlayground(randCard)) {
                card = randCard;
                break;
            }
        }
        return card;
    }

    private boolean isCardOnPlayground(Card randCard) {
        boolean flag = false;

        for (int i = 0; i < playground.length; i++) {
            for (int j = 0; j < playground[i].length; j++) {
                if (randCard.equals(playground[i][j]) && playground[i][j] != null) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public void drawCard(int cardsShaowCount, int userId) {
        for (int i = 0; i < CardView.CARD_LINE_COUNT; i++) {
            for (int j = 0; j < cardsShaowCount; j++) {
                playground[j][userId].drawCard(i);
            }
            playground[0][userId].drawEndLine();
        }
    }

    public void showNextCard(int userId) {
        for (int i = 0; i < playground.length; i++) {
            if (!playground[i][userId].isVisible()) {
                playground[i][userId].setVisible(true);
                break;
            }
        }
    }

    public int getCountCardOnPlayground(int userId) {
        int cardCount = 0;
        for (int i = 0; i < playground.length; i++) {
            if (playground[i][userId].isVisible()) {
                cardCount++;
            } else {
                break;
            }
        }
        return cardCount;
    }

    public int calculateScore(int userId) {
        int score = 0;

        for (int i = 0; i < playground.length; i++) {
            if (playground[i][userId].isVisible()) {
                score += ValueCard.getCardValueScore(playground[i][userId].getCardValues());
            } else {
                break;
            }
        }
        return score;
    }

    public void showScore(int userId) {
        for (int i = 0; i < playground.length; i++) {
            if (playground[i][userId].isVisible()) {
                if (i != 0) {
                    System.out.print(" + ");
                }
                System.out.print(ValueCard.getCardValueScore(playground[i][userId].getCardValues()));
            } else {
                break;
            }
        }
        if (playground[1][userId].isVisible()) {
            System.out.print(" = " + calculateScore(userId));
        }
        System.out.println();
    }

    public void exit() {
        System.exit(0);
    }

}
