import com.google.gson.*;
import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FacialHairSerializer implements JsonSerializer<FacialHair>, JsonDeserializer<FacialHair> {

    public JsonElement serialize(FacialHair src, Type type, JsonSerializationContext jsonSerializationContext) {
        if (!src.isHaveBeard() && !src.isHaveMustache())
            return new JsonPrimitive("is he really a dwarf?");
        List<String> list = new LinkedList<String>();

        if (src.isHaveBeard())
        {
            list.add("beard");
        }
        if (src.isHaveMustache())
        {
            list.add("mustache");
        }
        return new JsonPrimitive(new StringBuilder(src.getColor())
                .append(" ")
                .append(StringUtils.join(list, " and "))
                .toString());
    }

    public FacialHair deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        FacialHair facialHair = new FacialHair();
        String data = jsonElement.getAsString();
        List<String> list = Arrays.asList(data.split(" "));

        if(list.contains("beard")){
            facialHair.setHaveBeard(true);
        }
        if(list.contains("mustache")) {
            facialHair.setHaveMustache(true);
        }
        if(facialHair.isHaveBeard() || facialHair.isHaveMustache())
            facialHair.setColor(list.get(0));
        return facialHair;
    }
}
