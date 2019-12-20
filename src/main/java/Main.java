import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        DwarvesBand band = BandUtil.createBand();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Dwarf.class, new DwarfSerializer())
                .registerTypeAdapter(FacialHair.class, new FacialHairSerializer())
                .registerTypeAdapter(DwarvesBand.class, new DwarvesBandSerializer())
                .create();

        String json = gson.toJson(band);

        System.out.println(json);
    }
}
