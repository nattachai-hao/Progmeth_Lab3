package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {

    public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
        super(name, flavorText, bloodCost, power, health);
    }

    public int attackUnit(UnitCard unitCard) {
        if (this.power > unitCard.getHealth()) {
            unitCard.setHealth(0);
            return unitCard.getHealth();
        } else {
            unitCard.setHealth(unitCard.getHealth() - this.power);
            return this.power;
        }
    }
}

