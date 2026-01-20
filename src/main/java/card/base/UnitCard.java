package card.base;

import player.Player;

//You CAN modify the first line
public abstract class UnitCard extends Card {
    protected int power;
    protected int health;

    public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
        super(name, flavorText, bloodCost);
        setPower(power);
        setHealth(health);
    }

    public abstract int attackUnit(UnitCard u);

    public int attackPlayer(Player opponent) {
		/*
		 Hint:
			Use takeDamage(int)
			from Player class
		 */
        opponent.takeDamage(getPower());
        return getPower();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.getName() + "\tCost: " + this.getBloodCost() + "\t(POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
    }

    public void setPower(int power) {
        if (power < 0) {
            this.power = 0;
        } else {
            this.power = power;
        }
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = 0;
        }
    }

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health;
    }
}
