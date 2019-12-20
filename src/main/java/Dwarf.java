import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
public class Dwarf {
    private String name;
    private FacialHair facialHair;
    private List<Weapon> weapons = new LinkedList<Weapon>();
    private String lunch;
    @SerializedName("age")
    private int dwarfAge;

    public Dwarf()
    {
    }

    public Dwarf(String name, int dwarfAge)
    {
        this.name = name;
        this.dwarfAge = dwarfAge;
    }

    public void addWeapon(Weapon weapon)
    {
        this.weapons.add(weapon);
    }

    public void addWeapons(Collection<Weapon> weapons)
    {
        this.weapons.addAll(weapons);
    }
}
