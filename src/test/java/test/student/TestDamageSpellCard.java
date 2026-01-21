package test.student;


import org.junit.jupiter.api.BeforeEach;

import card.base.SpellCard;
import card.type.DamageSpellCard;
import card.type.NormalUnitCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDamageSpellCard {
    NormalUnitCard unit;

    SpellCard spell0 = new DamageSpellCard("DSpell0", "-1", 1, true, 1);
    DamageSpellCard spell1 = new DamageSpellCard("DSpell1", "-1", 1, true, 1);
    DamageSpellCard spell2 = new DamageSpellCard("DSpell2", "-2", 1, true, 2);
    DamageSpellCard spell3 = new DamageSpellCard("DSpell3", "-3", 2, false, 3);
    DamageSpellCard spellN = new DamageSpellCard("DSpellN", "XX", -2, false, -1);

    @BeforeEach
    public void setUp() {
        unit = new NormalUnitCard("Tanky Unit", "I'm a tanky unit", 0, 2, 10);
    }

    //Fill Code Here!!!
    // 1.testConstructor
    @Test
    void testConstructor() {
        assertEquals("DSpell1", spell1.getName());
        assertEquals("-1", spell1.getFlavorText());
        assertEquals(1, spell1.getBloodCost());
        assertEquals(true, spell1.isBurstSpeed());
        assertEquals(1, spell1.getDamage());
    }

    @Test
    void testConstructorNegativeValue() {
        assertEquals("DSpellN", spellN.getName());
        assertEquals("XX", spellN.getFlavorText());
        assertEquals(0, spellN.getBloodCost());
        assertEquals(false, spellN.isBurstSpeed());
        assertEquals(1, spellN.getDamage());
    }
    // 2. testSetDamage
    @Test
    void testSetDamage() {
        assertEquals(2,spell2.getDamage());
        spell2.setDamage(100);
        assertEquals(100,spell2.getDamage());
        spell2.setDamage(0);
        assertEquals(1,spell2.getDamage());
        spell2.setDamage(-100);
        assertEquals(1,spell2.getDamage());
    }
    // 3.testCastSpell
    @Test
    void testCastSpell() {
        spell1.castSpell(unit);
        assertEquals(9,unit.getHealth());
        spell2.castSpell(unit);
        assertEquals(7,unit.getHealth());
        spell3.castSpell(unit);
        assertEquals(4,unit.getHealth());
    }
}


