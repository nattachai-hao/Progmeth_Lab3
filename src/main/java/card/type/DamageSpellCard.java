package card.type;

import card.base.SpellCard;
import card.base.UnitCard;

//You CAN modify the first line
public class DamageSpellCard extends SpellCard {
    private int damage;

    public DamageSpellCard(String name, String flavorText, int bloodCost,
                           boolean isBurstSpeed, int damage) {
        super(name, flavorText, bloodCost, isBurstSpeed);
        setDamage(damage);
    }

    public void castSpell(UnitCard unitCard) {
        unitCard.setHealth(unitCard.getHealth() - getDamage());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 1) {
            this.damage = 1;
        } else {
            this.damage = damage;
        }
    }
}