package card.type;

import card.base.SpellCard;
import card.base.UnitCard;

//You CAN modify the first line
public class BuffSpellCard extends SpellCard {
    private int powerIncrease;

    public BuffSpellCard(String name, String flavorText, int bloodCost,
                         boolean isBurstSpeed, int powerIncrease) {
        super(name, flavorText, bloodCost, isBurstSpeed);
    }

    public void castSpell(UnitCard unitCard) {
        unitCard.setPower(unitCard.getPower() + getPowerIncrease());
    }

    public int getPowerIncrease() {
        return powerIncrease;
    }

    public void setPowerIncrease(int powerIncrease) {
        if (powerIncrease < 1) {
            this.powerIncrease = 1;
        } else {
            this.powerIncrease = powerIncrease;
        }
    }
}