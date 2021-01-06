package GUI1;

public class Rectangle implements Shape {

    int sideA;
    int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public void draw() {
        for (int i = 0; i< sideB; i++){
            for (int j = 0; j < sideA; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
