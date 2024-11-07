import java.util.Scanner;
public class JobLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisestage ettevõtte nimi: ");
        String ettevote = scanner.nextLine();
        System.out.println("Sisestage esindaja ametikoht: ");
        String esindajaAmetikoht = scanner.nextLine();
        System.out.println("Sisestage ettevõte esindaja nimi: ");
        String esindajaNimi = scanner.nextLine();
        System.out.println("Palun sisestage ametikoht kuhu kandideerite: ");
        String ametikoht = scanner.nextLine();
        System.out.println("Palun sisestage nõuded kandidaadile: ");
        String noudedKandidaadile = scanner.nextLine();
        System.out.println("Palun sisestage miks sobite sellele töökohale: ");
        String miksMina = scanner.nextLine();

        System.out.println("Lugupeetud "+ ettevote + esindajaAmetikoht +" " + esindajaNimi +
                "\n" +
                "Soovin kandideerida Teie väljakuulutatud "+ ametikoht +"ametikohale.\n" +
                "\n" +
                "Kuigi kirjale lisatud CV annab ülevaate minu varasemast töökogemusest, haridusest, täiendõppest ja tööks vajalikest oskustest, tõin välja töökuulutuses olevad nõudmised ja vastavad oskused nendel aladel:\n" +
                "\n" +
                "• "+ noudedKandidaadile +
                "\n" +
                "Leian, et lisaks töökuulutuses toodud nõuete täitmisele, olen sellele ametikohale sobiv kandidaat, sest "+ miksMina +"\n" +
                "\n" +
                "Olen meeleldi nõus vastama tekkivatele küsimustele Teile sobival ajal e-maili joosep.kallaste@gmail.com või telefoni +372 53326899 teel! Ootan Teiega kohtumist, et rääkida põhjalikumalt pakutavast ametikohast ja põhjustest, miks leian, et olen Teie ettevõttesse sobiv inimene.\n" +
                "\n" +
                "Lugupidamisega\n" +
                "Joosep-Gre Kallaste");

    }
}
