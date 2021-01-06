import java.io.FileInputStream;
import java.io.StringReader;
import java.util.*;

public class Country {

    String sign = "\\t";
    StringBuffer sb;
    StringTokenizer st;
    String [] arrOfWords;

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
    private String conr = "";

    public Country(String line){

/*        StringBuffer cont = new StringBuffer(line);
        try {
            StringReader in = new StringReader(line);
            int c;
            while ((c = in.read()) != -1) cont.append((char) c);
            in.close();
        } catch(Exception exc) {
            System.out.println(exc.toString());
            System.exit(1);
        }
        String s = cont.toString();
        System.out.println(s);

        st = new StringTokenizer(line, "\\t");
        int howManyTokens = st.countTokens();
        System.out.println(howManyTokens);

*/
        arrOfWords = new String[20];
        arrOfWords = line.split("\\t");
        this.iso2 = arrOfWords[0];
        this.name = arrOfWords[4];
        this.capital= arrOfWords[5];
        this.area= Double.valueOf(arrOfWords[6]);
        this.popul= Double.valueOf(arrOfWords[7]);
        this.contCode= arrOfWords[8];
        this.ccode= arrOfWords[9];
        this.cname= arrOfWords[10];
        this.lang= new ArrayList<>(Arrays.asList(arrOfWords[16].split(",")));
        //this.neighbours= Arrays.asList((arrOfWords[18]).split(","));
        //this.popDensity= arrOfWords[5];
        this.conr = "";

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
                ", conr='" + conr + '\'' +
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

    public String getConr() {
        return conr;
    }

    public void setConr(String conr) {
        this.conr = conr;
    }
}
