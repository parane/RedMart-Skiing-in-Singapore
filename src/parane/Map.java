package parane;

/**
 * Created by Parani on 15/02/2018.
 */
public class Map {
    private Integer value;
    private Integer maxLength;
    private Integer drop;
    private Boolean isCalculated;
    private Integer i;
    private Integer j;
    private Integer length;
    private Map parentMap;

    public Map(Integer value, Integer maxLength, Integer drop, Boolean isCalculated, Integer i, Integer j, Integer length) {
        this.value = value;
        this.maxLength = maxLength;
        this.drop = drop;
        this.isCalculated = isCalculated;
        this.i = i;
        this.j = j;
        this.length = length;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getDrop() {
        return drop;
    }

    public void setDrop(Integer drop) {
        this.drop = drop;
    }

    public Boolean getCalculated() {
        return isCalculated;
    }

    public void setCalculated(Boolean calculated) {
        isCalculated = calculated;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Map getParentMap() {
        return parentMap;
    }

    public void setParentMap(Map parentMap) {
        this.parentMap = parentMap;
    }
}
