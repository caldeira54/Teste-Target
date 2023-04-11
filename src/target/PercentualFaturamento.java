package target;

public class PercentualFaturamento {
    public static void main(String[] args) {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = sp + rj + mg + es + outros;

        System.out.println("SP " + (sp * 100) / total + "%");
        System.out.println("RJ " + (rj * 100) / total + "%");
        System.out.println("MG " + (mg * 100) / total + "%");
        System.out.println("ES " + (es * 100) / total + "%");
        System.out.println("Outros " + (outros * 100) / total + "%");
    }
}
