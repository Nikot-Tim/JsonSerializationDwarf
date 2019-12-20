import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

public class DwarvesBandSerializer implements JsonSerializer<DwarvesBand>, JsonDeserializer<DwarvesBand> {
    public JsonElement serialize(DwarvesBand dwarvesBand, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        for(Dwarf dwarf:dwarvesBand.getDwarves()){
            jsonObject.add(dwarf.getName(),jsonSerializationContext.serialize(dwarf));
        }
        return jsonObject;
    }

    public DwarvesBand deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        DwarvesBand dwarvesBand = new DwarvesBand();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Dwarf dwarf = jsonDeserializationContext.deserialize(entry.getValue(), Dwarf.class);
            dwarf.setName(entry.getKey());
            dwarvesBand.addDwarf(dwarf);
        }
        return dwarvesBand;
    }
}
