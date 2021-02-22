import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        double dotProduct = x1 * x2 + y1 * y2;
        double firstVectorLong = vecLong(x1, y1);
        double secondVectorLong = vecLong(x2, y2);
        double angle = dotProduct / (firstVectorLong * secondVectorLong);
        int result = (int) Math.toDegrees(Math.acos(angle));

        System.out.println(result);

    }

    static double vecLong(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}