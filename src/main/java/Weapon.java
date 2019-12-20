import lombok.Data;

@Data
public class Weapon {
    private String type;

    public Weapon()
    {
        // do nothing
    }

    public Weapon(String type)
    {
        this.type = type;
    }
}
