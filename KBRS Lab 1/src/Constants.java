import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String[] KEYS = {"KEY", "KEYC", "KEYCI", "KEYCIP", "KEYCIPH", "KEYCIPHE", "KEYCIPHER", "SPECIALKEY"};
    public static final String[] STRINGS = {"Hurricane Irma was an extremely powerful and catastrophic Cape Verde type hurricane, the most intense observed in the Atlantic since\n" +
            "Dean in 2007. It was also the most intense Atlantic hurricane to strike the United States since Katrina in 2005, and the first major\n" +
            "hurricane to make landfall in the state of Florida since Wilma in 2005. The ninth named storm, fourth hurricane, and second major\n" +
            "hurricane of the 2017 Atlantic hurricane season, Irma caused widespread and catastrophic damage throughout its long lifetime,\n" +
            "particularly in parts of the northeastern Caribbean and the Florida Keys.",
            "Irma developed on August 30, 2017 near the Cape Verde Islands, from a tropical wave that had moved off the west African " +
                    "coast three days prior.[1][2][3] Under favorable conditions, Irma rapidly intensified shortly after formation," +
                    " becoming a Category 2 hurricane on the Saffir–Simpson scale within a mere 24 hours. It became a Category 3 hurricane" +
                    " (and therefore a major hurricane) shortly afterward; however, the intensity fluctuated between Categories 2 and 3 for" +
                    " the next several days due to a series of eyewall replacement cycles. On September 4, Irma resumed intensifying, " +
                    "becoming a Category 5 hurricane by early the next day. On September 6, Irma reached its peak intensity with 185 mph " +
                    "(295 km/h) winds and a minimum pressure of 914 hPa (27.0 inHg), making it the strongest tropical cyclone worldwide so" +
                    " far in 2017",
            " Another eyewall replacement cycle caused Irma to weaken back to a Category 4 hurricane, but the storm" +
                    " attained Category 5 status for a second time while making landfall in Cuba. After dropping to Category 3 intensity due" +
                    " to land interaction, the storm re-intensified to Category 4 as it crossed warm waters between Cuba and the Florida Keys" +
                    " before making landfall on Cudjoe Key with maximum sustained winds of 130 mph (215 km/h). Irma dropped back to Category" +
                    " 3 by the time it made a second Florida landfall on Marco Island. Irma weakened to a Category 2 hurricane later that day" +
                    ", the first time it weakened below major hurricane status in over a week, and eventually dissipated off the coast of" +
                    " New England.",
            "The storm caused catastrophic damage in Barbuda, Saint Barthélemy, Saint Martin, Anguilla and the Virgin Islands as a " +
                    "Category 5 hurricane.[4][5] As of September 15, the hurricane has caused at least 82 deaths, including 43 in the" +
                    " Caribbean and 39 in the United States.[6]",
            "The National Hurricane Center (NHC) began monitoring a tropical wave over western Africa on August 26.[7] This wave" +
                    " moved off the coast of the continent late on August 27. Throughout the next two days, showers and thunderstorms" +
                    " associated with the wave became better organized and gradually coalesced into a low pressure area, as the" +
                    " system passed just south of and then through the Cape Verde Islands on August 29,[8] with the NHC stating that" +
                    " any significant organization of the disturbance would result in the classification of a tropical depression.",
            "Further organization over the next 24 hours or so led to classification of the disturbance as Tropical Storm Irma, at" +
                    " 15:00 UTC on August 30, based on scatterometer data and satellite estimates.[10] With warm sea surface" +
                    " temperatures and low wind shear, strengthening was anticipated, with the only hindrance being slightly cooler " +
                    "waters and drier air.",
            "The nascent storm began developing upper-level poleward outflow as an anticyclone became established over the system," +
                    " with banding features becoming increasingly evident in satellite images.[11] Early on August 31, shortly after" +
                    " the development of a central dense overcast (CDO) and an eye feature, Irma rapidly intensified beginning at" +
                    " 09:00 UTC on August 31, with winds increasing from 70 mph (110 km/h) to 115 mph (185 km/h) in only 12 hours.",
            "On September 2, a ship passed 60 mi (90 km) to the west of the center of Irma, recording maximum winds of 45 mph" +
                    " (70 km/h), which indicated that the eye of Irma remained compact.[13][14] A strengthening subtropical ridge " +
                    "over the central North Atlantic pushed Irma from a western to southwestern direction on September 2 and " +
                    "3.[15][16][17][18] The first aircraft reconnaissance mission departed from Barbados on the afternoon of September" +
                    " 3, discovering an eye 29 mi (47 km) in diameter and surface winds of 115 mph (185 km/h)."};
    public static final Map<Character, Double> FREQ_MAP;

    static {
        FREQ_MAP = new HashMap<>();
        FREQ_MAP.put('A', 0.08167);
        FREQ_MAP.put('B', 0.01492);
        FREQ_MAP.put('C', 0.02782);
        FREQ_MAP.put('D', 0.04253);
        FREQ_MAP.put('E', 0.12702);
        FREQ_MAP.put('F', 0.0228);
        FREQ_MAP.put('G', 0.02015);
        FREQ_MAP.put('H', 0.06094);
        FREQ_MAP.put('I', 0.06966);
        FREQ_MAP.put('J', 0.00153);
        FREQ_MAP.put('K', 0.00772);
        FREQ_MAP.put('L', 0.04025);
        FREQ_MAP.put('M', 0.02406);
        FREQ_MAP.put('N', 0.06749);
        FREQ_MAP.put('O', 0.07507);
        FREQ_MAP.put('P', 0.01929);
        FREQ_MAP.put('Q', 0.00095);
        FREQ_MAP.put('R', 0.05987);
        FREQ_MAP.put('S', 0.06327);
        FREQ_MAP.put('T', 0.09056);
        FREQ_MAP.put('U', 0.02758);
        FREQ_MAP.put('V', 0.00978);
        FREQ_MAP.put('W', 0.0236);
        FREQ_MAP.put('X', 0.0015);
        FREQ_MAP.put('Y', 0.01974);
        FREQ_MAP.put('Z', 0.00074);
    }

    public static final int NUMBER_OF_LETTERS = 26;
}
