import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class DwarvesBand {
    List<Dwarf> dwarves = new LinkedList<Dwarf>();

    public void addDwarf(Dwarf tmpDwarf) {
        dwarves.add(tmpDwarf);
    }
}
