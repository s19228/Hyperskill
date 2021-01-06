import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String params = input.substring(30);
        String[] arrOfParams = params.split("&");

        String password = "";
        StringBuilder pass = new StringBuilder();
        StringBuilder port = new StringBuilder();
        StringBuilder cookie = new StringBuilder();
        StringBuilder host = new StringBuilder();
        StringBuilder name = new StringBuilder();
        String nf = "not found";


        checkParams(arrOfParams, pass, port, cookie, host, name);

        generateMessage(params, pass, port, cookie, host, name, nf);

        for (String arrOfParam : arrOfParams) {
            if (!arrOfParam.contains("pass=") || pass.toString().contains(nf)) {
                continue;
            }
            password += pass;
            System.out.println("password : " + password);
            break;
        }
    }

    private static void checkParams(String[] arrOfParams, StringBuilder pass, StringBuilder port, StringBuilder cookie, StringBuilder host, StringBuilder name) {
        for (String arrOfParam : arrOfParams) {
            if (arrOfParam.contains("pass=")) {
                pass.append(arrOfParam.substring(5));
            }
            if (arrOfParam.contains("port=")) {
                port.append(arrOfParam.substring(5));
            }
            if (arrOfParam.contains("name=")) {
                name.append(arrOfParam.substring(5));
            }
            if (arrOfParam.contains("cookie=")) {
                cookie.append(arrOfParam.substring(7));
            }
            if (arrOfParam.contains("host=")) {
                host.append(arrOfParam.substring(5));
            }
        }
    }

    private static void generateMessage(String params, StringBuilder pass, StringBuilder port, StringBuilder cookie, StringBuilder host, StringBuilder name, String nf) {
        if (!params.contains("pass=") && params.contains("name=")) {
            displayMessage(nf, port.toString(), cookie.toString(), host.toString(), name.toString());
        } else if (!params.contains("pass=")) {
            System.out.println("port : " + port);
            if (cookie.toString().equals("")) {
                cookie.append(nf);
            }
            System.out.println("cookie : " + cookie);
            System.out.println("host : " + host);
        } else if (params.contains("pass=") && params.contains("name=")) {
            displayMessage(nf, port.toString(), cookie.toString(), host.toString(), name.toString());
            if (pass.toString().equals("")) {
                pass.append(nf);
            }
            System.out.println("pass : " + pass);
        } else {
            System.out.println("pass : " + pass);
            if (pass.toString().equals("")) {
                pass.append(nf);
            }
            System.out.println("port : " + port);
            if (cookie.toString().equals("")) {
                cookie.append(nf);
            }
            System.out.println("cookie : " + cookie);
            System.out.println("host : " + host);
        }
    }

    private static void displayMessage(String notFound, String port, String cookie, String host, String name) {
        System.out.println("port : " + port);
        System.out.println("name : " + name);
        if (cookie.equals("")) {
            cookie += notFound;
        }
        System.out.println("cookie : " + cookie);
        System.out.println("host : " + host);
    }
}