package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {
    private int buffPower;
    private int buffHealth;

    public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
        super(name, flavorText, bloodCost, power, health);
        setBuffPower(buffPower);
        setBuffHealth(buffHealth);
    }

    public int attackUnit(UnitCard unitCard) {
        if (this.power > unitCard.getHealth()) {
            int realDamage = unitCard.getHealth();
            unitCard.setHealth(0);
            return realDamage;
        } else {
            unitCard.setHealth(unitCard.getHealth() - this.power);
            return this.power;
        }
    }

    public void buffUnit(UnitCard[] alliesCard) {
        for (int i = 0; i < alliesCard.length; i++) {
            if (alliesCard[i].equals(null)) continue;
            alliesCard[i].setPower(alliesCard[i].getPower() + getBuffPower());
            alliesCard[i].setHealth(alliesCard[i].getHealth() + getBuffHealth());
        }
    }

    public int getBuffPower() {
        return buffPower;
    }

    public int getBuffHealth() {
        return buffHealth;
    }

    public void setBuffPower(int buffPower) {
        this.buffPower = buffPower;
    }

    public void setBuffHealth(int buffHealth) {
        this.buffHealth = buffHealth;
    }

    @Override
    public String toString() {
        return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() +
                " | POW Inc: " + this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
    }

}