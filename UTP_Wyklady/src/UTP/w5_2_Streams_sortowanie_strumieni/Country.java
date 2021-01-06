package UTP.w5_2_Streams_sortowanie_strumieni;

import java.util.List;

public class Country {

    private String iso2;
    private String name;
    private String capital;
    private Double area;
    private Double popul;
    private String contCode;
    private String ccode;
    private String cname;
    private List<String> lang;
    private List<String> neighbours;
    private Double popDensity;
    private String cont = "";

    public Country(String line){
        // inicjalizacja pol z symboli wiersza line??
    }

    @Override
    public String toString() {
        return "Country{" +
                "iso2='" + iso2 + '\'' +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", area=" + area +
                ", popul=" + popul +
                ", contCode='" + contCode + '\'' +
                ", ccode='" + ccode + '\'' +
                ", cname='" + cname + '\'' +
                ", lang=" + lang +
                ", neighbours=" + neighbours +
                ", popDensity=" + popDensity +
                ", conr='" + cont + '\'' +
                '}';
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPopul() {
        return popul;
    }

    public void setPopul(Double popul) {
        this.popul = popul;
    }

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<String> getLang() {
        return lang;
    }

    public void setLang(List<String> lang) {
        this.lang = lang;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<String> neighbours) {
        this.neighbours = neighbours;
    }

    public Double getPopDensity() {
        return popDensity;
    }

    public void setPopDensity(Double popDensity) {
        this.popDensity = popDensity;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
}
