package GUI3;

// nasza klasa School Subject
// większość zawartości klasy może zostać wygenerowana automatycznie
// w tym celu w Eclipse należy kliknąć prawym przyciskiem myszy wewnątrz klasy i wybrać opcję Source
// w IntelliJ podobny efekt można uzyskać przy pomocy opcji Generate
public class SchoolSubject {

    private String name;
    private int grade;

    public SchoolSubject(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "SchoolSubject [name=" + name + ", grade=" + grade + "]";
    }

}
