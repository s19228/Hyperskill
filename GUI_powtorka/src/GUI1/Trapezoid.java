package GUI1;

// Stwórzmy klasę reprezentującą trapez równoramienny o nazwie Trapezoid
public class Trapezoid implements Shape {

    // Klasa trapez powinna zawierać pola reprezentujące długość obu podstaw i wysokość
    private int widthA;     // Długość krótszej podstawy
    private int widthB;     // Długość dłuższej podstawy
    private int height;

    // Pola powinny być ustawiane w konstruktorze klasy
    public Trapezoid(int widthA, int widthB, int height) {
        // Co należy uczynić, aby w poniższych liniach można było pominąć słowo kluczowe this?
        this.widthA = Math.min(widthA, widthB);
        this.widthB = Math.max(widthA, widthB);
        this.height = height;
    }

    // Oczywiście musimy przesłonić metodę abstrakcyjną draw
    public void draw() {
        // Algorytm na rysowanie trapezu równoramiennego można podzielić na trzy kroki
        // 1. Narysowanie linii należącej do trójkąta prostąktnego
        // 2. Narysowanie linii należącej do prostokąta
        // 3, Narysowanie linii należącej do trójkąta prostokątnego
        // Wszystkie kroki należy powtórzyć tyle razy ile wynosi wysokość trapezu

        // Obliczmy długość podstawy trójkąta
        int dlugoscPodstawy = (widthB - widthA) / 2;

        // Obliczmy o ile musimy zwiększać liczbę * w trójkątach dla każdej linii
        double ileDodac = ((double)dlugoscPodstawy / (height - 1));

        // Powtarzanie rysowania dla kolejnych linii
        for (int y = 0; y < height; y++) {

            // Obliczmy liczbę * w obecnej linii dla trójkątów
            int ileZnakowWLinii = (int)Math.round(y * ileDodac);

            // Rysowanie pierwszego trójkąta sprowadza się do wstawienia spacji uzupełnionych gwiazdkami
            for (int x = 0; x < dlugoscPodstawy - ileZnakowWLinii; x++) {
                System.out.print(" ");
            }
            for (int x = 0; x < ileZnakowWLinii; x++) {
                System.out.print("*");
            }

            // Szerokość prostokąta odpowiada krótszej podstawie trapezu
            for (int x = 0; x < widthA; x++) {
                System.out.print("*");
            }

            // Rysowanie drugiego trójkąta ogranicza sie do samych *
            for (int x = 0; x < ileZnakowWLinii; x++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

}