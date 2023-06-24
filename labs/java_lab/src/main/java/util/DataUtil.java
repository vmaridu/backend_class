package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataUtil {
    public static List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
    public static List<String> countries= new ArrayList<String>(Arrays.asList("India", "Australia", "England", "Newzealand", "SouthAfrica",
            "Bangladesh", "WestIndies", "Zimbabwe"));
    public static List<String> names = new ArrayList<String>(Arrays.asList("Teja", "Baby", "Sudhu", "Bala"));
    public static Map<Integer, String> namesMap = Map.of(1, "Teja M", 2, "Baby M", 3, "Sudhu M", 4, "Bala M",
            5, "Sunny M", 6, "Chitti M", 7, "Usha B", 8, "Sai M");


}
