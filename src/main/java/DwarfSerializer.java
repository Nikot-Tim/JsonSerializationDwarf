import com.google.gson.*;

import java.lang.reflect.Type;

public class DwarfSerializer implements JsonSerializer<Dwarf> {
    public JsonElement serialize(Dwarf dwarf, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.addProperty("age", dwarf.getDwarfAge());
        result.add("facialHair", jsonSerializationContext.serialize(dwarf.getFacialHair()));

        JsonArray weapons = new JsonArray();
        for(Weapon weapon : dwarf.getWeapons()) {
            weapons.add(
                    weapon instanceof UniqueWeapon ?
                            jsonSerializationContext.serialize(weapon) :
                            new JsonPrimitive(weapon.getType())
            );
        }
        result.add("weapons", weapons);
        return result;
    }
}
