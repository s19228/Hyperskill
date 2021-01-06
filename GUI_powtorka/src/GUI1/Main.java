package GUI1;

public class Main {

    public static void main(String[] args) {

        CompanyAccount ca1 = new CompanyAccount(100000.50);

        ca1.deposit(123.45);
        ca1.charge();
        ca1.withdraw(2345.99);

        System.out.println(ca1);

        System.out.println("-------------------------------------------");

        IndividualAccount ia1 = new IndividualAccount(100000.50);

        ia1.deposit(123.45);
        ia1.charge();
        ia1.withdraw(2345.99);

        System.out.println(ia1);

        //System.out.println("Roznica" + (ia1 - ca1));

        System.out.println("--------------------------------------------");

        Account [] accountsList = new Account[]{ca1 , ia1};

        Account.showAccountList(accountsList);

        Shape sq1 = new Square(4);
        sq1.draw();

        System.out.println("---------------------------");

        Rectangle re1 = new Rectangle(7,2);
        re1.draw();


        Account uniqueAccount = new Account(6565) {
            public void charge() {
                balance -= 25;
            }
        };

        uniqueAccount.withdraw(560);
        uniqueAccount.charge();
        System.out.println(uniqueAccount);

        Shape sq2 = new Square(3);
        Shape rec2 = new Rectangle(3, 3);

        Shape tri = new Shape() {
            private int height = 5;

            public void draw() {
                for (int wiersz = 1; wiersz < height; wiersz++) {
                    for (int znak = 0; znak < wiersz; znak++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        };

        tri.draw();

        Shape trap = new Trapezoid(1,9,16);
        trap.draw();


        Lamp lamp1 = new Lamp();
        lamp1.turnOn();
        lamp1.turnOff();

        System.out.println("*****************");

        Lamp lamp2 = new Lamp("on");

        lamp2.turnOn();
        lamp2.turnOff();
        lamp2.turnOff();

        System.out.println("******************");

        Swithable device = new Lamp();
        device.turnOn();
        System.out.println("-------------------");
        Lamp lamp = new Lamp();
        Lamp.runDevice(lamp);

        System.out.println();
        Traktor t = new Traktor();
        t.turnOn();
        t.turnOff();

        Traktor.wlaczTraktora(t);


        Rectangle rec3 = new Rectangle(2,3);
        rec3.draw();

        Shape fig = new Shape() {
            int a = 5;
            @Override
            public void draw() {
                for (int i = 0; i< a; i++){
                    for (int j = 0; j < a; j++){
                        System.out.print('*');
                    }
                    System.out.println();
                }
            }
        };

        fig.draw();


        ArrayStack as = new ArrayStack(100);

        System.out.println(as.empty());

        as.push(12);
        as.push(13);




    }
}
