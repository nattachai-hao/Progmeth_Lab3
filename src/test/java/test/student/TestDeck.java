package test.student;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import card.base.Card;
import card.type.BuffSpellCard;
import card.type.NormalUnitCard;
import deck.Deck;
import deck.InsertCardFailedException;
import deck.RemoveCardFailedException;

import static org.junit.jupiter.api.Assertions.*;

public class TestDeck {

    Deck deck1, deck2, deck3;

    NormalUnitCard NormalUnit1 = new NormalUnitCard("Normal Unit 1", "normal unit 1", 0, 1, 1);
    NormalUnitCard NormalUnit2 = new NormalUnitCard("Normal Unit 2", "normal unit 2", 2, 3, 4);
    BuffSpellCard BuffSpellCard1 = new BuffSpellCard("Buff Spell 1", "buff spell 1", 0, false, 1);
    BuffSpellCard BuffSpellCard2 = new BuffSpellCard("Buff Spell 2", "buff spell 2", 2, false, 4);

    Card[] cardList1 = {};

    Card[] cardList2 = {NormalUnit1, NormalUnit1, NormalUnit1, NormalUnit1, NormalUnit2, NormalUnit2, NormalUnit2, NormalUnit2};

    Card[] cardList3 = {NormalUnit1, NormalUnit1, NormalUnit2, NormalUnit2, BuffSpellCard1, BuffSpellCard1, BuffSpellCard2, BuffSpellCard2};

    @BeforeEach
    void setUp() {

        deck1 = new Deck("Test Deck 1", cardList1);


        deck2 = new Deck("Test Deck 2", cardList2);


        deck3 = new Deck("Test Deck 3", cardList3);
    }

    @Test
    void testConstructor() {
        assertEquals("Test Deck 1", deck1.getName());
        assertEquals(0, deck1.getDeckSize());
        for (int i = 0; i < deck1.getDeckSize(); i++) {
            assertEquals(cardList1[i], deck1.getDeckList()[i]);
        }

        assertEquals("Test Deck 2", deck2.getName());
        assertEquals(8, deck2.getDeckSize());
        for (int i = 0; i < deck2.getDeckSize(); i++) {
            assertEquals(cardList2[i], deck2.getDeckList()[i]);
        }

        assertEquals("Test Deck 3", deck3.getName());
        assertEquals(8, deck3.getDeckSize());
        for (int i = 0; i < deck3.getDeckSize(); i++) {
            assertEquals(cardList3[i], deck3.getDeckList()[i]);
        }

    }

    @Test
    void testInsertCard() {
        try {
            deck1.insertCard(BuffSpellCard1);
        } catch (InsertCardFailedException e) {
            fail("InsertCardFailedException deck1 throws error");
        }
        Card[] cardList1New = {BuffSpellCard1};
        assertEquals(1, deck1.getDeckSize());
        for (int i = 0; i < deck1.getDeckSize(); i++) {
            assertEquals(cardList1New[i], deck1.getDeckList()[i]);
        }

        try {
            deck3.insertCard(BuffSpellCard1);
        } catch (InsertCardFailedException e) {
            fail("InsertCardFailedException deck3 throws error");
        }
        Card[] cardList3New = {NormalUnit1, NormalUnit1, NormalUnit2, NormalUnit2, BuffSpellCard1, BuffSpellCard1, BuffSpellCard2, BuffSpellCard2, BuffSpellCard1};
        assertEquals(9, deck3.getDeckSize());
        for (int i = 0; i < deck3.getDeckSize(); i++) {
            assertEquals(cardList3New[i], deck3.getDeckList()[i]);
        }

    }

    @Test
    void testInsertCardMoreThan4Card() {
        for (int i = 0; i < 4; i++) {
            try {
                deck1.insertCard(BuffSpellCard1);
            } catch (InsertCardFailedException e) {
                fail("You insert too many " + BuffSpellCard1.getName() + " Card)");
            }
        }
        assertThrows(InsertCardFailedException.class, () -> {
            deck1.insertCard(BuffSpellCard1);
        });

    }


    //Fill Code Here!!!
    // 1.testRemoveCard
    @Test
    void testRemoveCard() {
        Deck testDeck = new Deck("testDeck", cardList2);
        try {
            Card checkCard = testDeck.removeCard(3);
            assertEquals(checkCard, deck2.getDeckList()[3]);
        } catch (RemoveCardFailedException e) {
            fail("You remove fail");
        }
        assertEquals(testDeck.getDeckSize(), 7);
        assertEquals(testDeck.getDeckList()[0], deck2.getDeckList()[0]);
        assertEquals(testDeck.getDeckList()[1], deck2.getDeckList()[1]);
        assertEquals(testDeck.getDeckList()[2], deck2.getDeckList()[2]);
        assertEquals(testDeck.getDeckList()[3], deck2.getDeckList()[4]);
        assertEquals(testDeck.getDeckList()[4], deck2.getDeckList()[5]);
        assertEquals(testDeck.getDeckList()[5], deck2.getDeckList()[6]);
        assertEquals(testDeck.getDeckList()[6], deck2.getDeckList()[7]);

        Deck testDeck2 = new Deck("testDeck", cardList3);
        try {
            Card checkCard = testDeck2.removeCard(0);
            assertEquals(checkCard, deck3.getDeckList()[0]);
            testDeck2.removeCard(1);
            testDeck2.removeCard(2);
        } catch (RemoveCardFailedException e) {
            fail("You remove fail");
        }
        assertEquals(testDeck2.getDeckSize(), 5);
        assertEquals(testDeck2.getDeckList()[0], deck3.getDeckList()[1]);
        assertEquals(testDeck2.getDeckList()[1], deck3.getDeckList()[3]);
        assertEquals(testDeck2.getDeckList()[2], deck3.getDeckList()[5]);
        assertEquals(testDeck2.getDeckList()[3], deck3.getDeckList()[6]);
        assertEquals(testDeck2.getDeckList()[4], deck3.getDeckList()[7]);
    }

    // 2.testNonExsistanceRemoveCard
    @Test
    void testRemoveNonExsistanceCard() {
        assertThrows(RemoveCardFailedException.class, () -> {
            deck1.removeCard(10);
        });

        Deck testDeck = new Deck("testDeck", cardList2);
        assertThrows(RemoveCardFailedException.class, () -> {
            testDeck.removeCard(100);
        });

        assertThrows(RemoveCardFailedException.class, () -> {
            deck2.removeCard(9);
        });
    }
}
