package si.alkimisticus.easybutterflyrecorder.db;

/**
 * Created by jernej on 12.1.2017.
 */

public class SpeciesDbTable {

    private String commonName;
    private String latinName;
    private String commonFamilyName;
    private String latinFamilyName;

    public SpeciesDbTable(String commonName, String latinName, String commonFamilyName, String latinFamilyName) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.commonFamilyName = commonFamilyName;
        this.latinFamilyName = latinFamilyName;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getCommonFamilyName() {
        return commonFamilyName;
    }

    public String getLatinFamilyName() {
        return latinFamilyName;
    }
}
