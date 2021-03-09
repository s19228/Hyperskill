class Problem {
    public static void main(String[] args) {

        int res = -1;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")){
                res = i;
            }
        }

        System.out.println(res);

    }
}