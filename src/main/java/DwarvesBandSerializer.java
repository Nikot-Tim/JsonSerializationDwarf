import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class DwarvesBandSerializer implements JsonSerializer<DwarvesBand> {
    public JsonElement serialize(DwarvesBand dwarvesBand, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        for(Dwarf dwarf:dwarvesBand.getDwarves()){
            jsonObject.add(dwarf.getName(),jsonSerializationContext.serialize(dwarf));
        }
        return jsonObject;
    }
}
