package GUI1;

public class Square implements Shape {

    int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public void draw() {
        for (int i = 0; i< side; i++){
            for (int j = 0; j < side; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
