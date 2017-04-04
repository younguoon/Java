package chap07.Referance;

public class ClothingInfo {
	String code;       
    String name;       
    String material;   
    Season season;        
    ClothingInfo(String code, String name, String material, Season season) {
        this.code = code;
        this.name = name;
        this.material = material;
        this.season = season;
    }
}
