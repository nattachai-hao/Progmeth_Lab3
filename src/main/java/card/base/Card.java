package card.base;

//You CAN modify the first line
public abstract class Card implements Cloneable {
    protected String name;
    protected String flavorText;
    protected int bloodCost;

    /// You can modify code below ///
    public Card(String name, String flavorText, int bloodCost) {
        this.name = name;
        this.flavorText = flavorText;
        if(bloodCost < 0) {
            this.bloodCost = 0;
        }else {
            this.bloodCost = bloodCost;
        }
    }

    public abstract String toString();

    public String getName() {
        return name;
    }

    public int getBloodCost() {
        return bloodCost;
    }

    public String getFlavorText() {
        return flavorText;
    }

    /// You can modify code above ///

    public boolean equals(UnitCard other) {
        return this.getName().equals(other.getName());
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}