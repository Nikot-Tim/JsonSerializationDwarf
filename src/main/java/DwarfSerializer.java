import com.google.gson.*;

import java.lang.reflect.Type;

public class DwarfSerializer implements JsonSerializer<Dwarf>, JsonDeserializer<Dwarf> {
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

    public Dwarf deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Dwarf dwarf = new Dwarf();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        dwarf.setDwarfAge(jsonObject.get("age").getAsInt());
        dwarf.setFacialHair((FacialHair) jsonDeserializationContext.deserialize(jsonObject.get("facialHair"), FacialHair.class));
        JsonArray jsonArray = jsonObject.getAsJsonArray("weapon");
        for(JsonElement weapon : jsonArray) {
            if(weapon.isJsonPrimitive()) {
                dwarf.addWeapon(new Weapon(weapon.getAsString()));
            } else {
                dwarf.addWeapon((UniqueWeapon) jsonDeserializationContext.deserialize(weapon, UniqueWeapon.class));
            }
        }
        return dwarf;
    }
}
