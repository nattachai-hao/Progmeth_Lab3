package deck;


import java.util.Arrays;

import card.base.Card;


public class Deck {
    protected String name;
    protected int deckSize;
    protected Card[] deckList;
    // TODO: constructor

    public Deck(String name, Card[] deckList) {
        setName(name);
        setDeckList(deckList);
        setDeckSize(deckList.length);
    }

    //You CAN modify the first line
    public int insertCard(Card card) throws InsertCardFailedException {
        int count = 0;
        //หาการ์ดซ้ำ
        for (Card e : deckList) {
            if (e.equals(card)) {
                count++;
            }
        }
        if (count >= 4)
            throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
        //FILL CODE HERE
        //You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
        //Must return new deckSize
        Card[] newDeck = Arrays.copyOf(deckList, deckList.length + 1);
        newDeck[newDeck.length - 1] = card;
        setDeckSize(newDeck.length);
        setDeckList(newDeck);
        return getDeckSize();
    }

    //You CAN modify the first line
    public Card removeCard(int slotNumber) throws RemoveCardFailedException {
        if (this.deckList.length <= slotNumber) {
            throw new RemoveCardFailedException("Number you insert exceed deck size");
        }
        if (this.deckList[slotNumber] == null) {
            throw new RemoveCardFailedException("There is no card in that slot");
        }
        //FILL CODE HERE
        //You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size (Added slot is empty)
        //Once card is removed, other card down the list must rearrange to the empty slot
        //Must return card that was removed
        Card[] newDeck = Arrays.copyOf(deckList, deckList.length + 1);
        Card removeCard = newDeck[slotNumber];
        for(int i = slotNumber; i < newDeck.length - 1; i++) {
            newDeck[i] = newDeck[i+1];
        }
        Card[] finalDeck = Arrays.copyOf(newDeck,newDeck.length - 1);
        setDeckList(finalDeck);
        setDeckSize(finalDeck.length);
        return removeCard;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("{").append(this.getName()).append("}")
                .append("(").append(this.getDeckSize()).append(" deck size)")
                .toString();
    }

    /* GETTERS & SETTERS */

    public String getName() {
        return name;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public Card[] getDeckList() {
        return deckList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public void setDeckList(Card[] deckList) {
        this.deckList = deckList;
    }
}
