package solutions;

/**
 * Created by mismirno on 3/7/2016.
 */
public class CakeType implements Comparable<CakeType> {

    int weight;
    int value;

    /**
     * Constructs a CakeType object
     *
     * @param weight weight of a cake of the given type, can be 0
     * @param value  monetary value of a cake of the given type, can be 0
     */
    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    /**
     * Compares cakes by their value/weight ratio
     */
    public int compareTo(CakeType otherType) {
        //First take care about possible 0 in the denominator of the ratio
        if (this.weight == 0 && otherType.weight == 0) {
            return 0;
        }
        if (this.weight == 0) {
            return value == 0 ? -1 : 1;
        }
        if (otherType.weight == 0) {
            return -1;
        }
        return Double.compare(this.value * 1.0 / this.weight,
                otherType.value * 1.0 / otherType.weight);
    }

    @Override
    public String toString() {
        return "CakeType{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
