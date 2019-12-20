import lombok.Data;

@Data
public class FacialHair {
    private boolean haveBeard;
    private boolean haveMustache;
    private String color;

    public FacialHair(){}

    public FacialHair(boolean haveBeard, boolean haveMustache, String color)
    {
        this.haveBeard = haveBeard;
        this.haveMustache = haveMustache;
        this.color = color;
    }
}
