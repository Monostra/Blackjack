package ua.com.blackJack;

/**
 * Created by Mykhailo on 21/12/2017.
 */
public class Card {
    private CardSuits cardSuits;
    private CardValues cardValues;
    private CardView cardView = new CardView();
    private boolean visible = false;

    public Card(CardSuits cardSuits, CardValues cardValues) {
        this.cardSuits = cardSuits;
        this.cardValues = cardValues;
    }

    public Card(CardSuits cardSuits, CardValues cardValues, boolean visible) {
        this.cardSuits = cardSuits;
        this.cardValues = cardValues;
        this.visible = visible;
    }

    public void drawCard(int line) {
        if (visible) {
            cardView.drawFrontCard(cardSuits, cardValues, line);
        } else {
            cardView.drawBackCard(line);
        }
    }

    public void drawEndLine() {
        cardView.drawEndLine();
    }

    public boolean equals(Card card) {
        if (this == card) return true;
        if (card == null) return false;
        if (getClass() != card.getClass()) return false;
        Card other = (Card) card;
        if (cardSuits != other.cardSuits) return false;
        if (cardValues != other.cardValues) return false;
        if (visible != other.visible) return false;

        return true;
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    public CardValues getCardValues() {
        return cardValues;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
