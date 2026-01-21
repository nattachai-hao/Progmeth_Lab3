package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {
    private int debuffPower;

    public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
        super(name, flavorText, bloodCost, power, health);
        setDebuffPower(debuffPower);
    }

    public int attackUnit(UnitCard unitCard) {
        if (this.power > unitCard.getHealth()) {
            int realDamage = unitCard.getHealth();
            unitCard.setHealth(0);
            unitCard.setPower(unitCard.getPower() - getDebuffPower());
            return realDamage;
        } else {
            unitCard.setHealth(unitCard.getHealth() - this.power);
            unitCard.setPower(unitCard.getPower() - getDebuffPower());
            return this.power;
        }
    }

    public int getDebuffPower() {
        return debuffPower;
    }

    public void setDebuffPower(int debuffPower) {
        this.debuffPower = debuffPower;
    }
}
