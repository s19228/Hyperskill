package jak_siac_panike_generator;

public class Main {

    public static void main(String[] args) {

        String [] tab1 = {"Ale numer...", "Potwierdzone info!", "Słow nie ma co oni wyprawiają!", "Puść dalej", "Szok nie mogę uwierzyć...", "A to już słyszałeś?"};
        String [] tab2 = {"wiarygodne źródło", "moja koleżanka", "mój kuzyn!", "syn sąsiada", "brat naszego proboszcza", "kmpel mojego szefa"};
        String [] tab3 = {"z Instytutu chorób zakaźnych", "przacuje w stukturach rządowych i", "oficer ABW", "lekarz - epidemiolog", "dziennikarz w tvp", "szkolny kolega Agaty Dudy, no wiesz, prezydentowej"};
        String [] tab4 = {"dał(a) cynk, że prezydent", "własnie pisze mi w mailu, ze", "wie na 100%, że sejm", "przysłała mi smsa, że ministerstwo zdrowia", "właśnie dostał(a) komunikat, zże sztab WP", "przypadkiem dowiedziała się, że premier"};
        String [] tab5 = {"jutro w nocy", "w ciągu 24 godzin", "za chwilę", "w najbliższych godzinach", "w najbliższą niedzielę", "na dniach"};
        String [] tab6 = {"wyśle wszystkich 60+ do ośrodków izolacyjnych", "zamknie wjazd do Warszawy", "nakzaże zamknięcie sklepów", "wprowadzi wojsko na ulice", "ma zakazać używania gotówki", "zablokuje konta bankowe i mozliwości wypłat gotówki"};

        int counter = 1;

        for (int i = 0; i < tab1.length ; i++){
            for (int j = 0; j < tab2.length; j++){
                for (int k = 0; k < tab3.length; k++){
                    for (int l = 0; l < tab4.length; l++){
                        for (int m = 0; m < tab5.length; m++){
                            for (int n = 0; n < tab6.length; n++){
                                System.out.println(counter+". "+ tab1[i] + " " + tab2[j] + " "+ tab3[k] + " " + tab4[l] + " "+ tab5[m] + " " + tab6[n] + ".");
                                counter++;
                            }
                        }
                    }
                }
            }
        }











    }


}
