import java.util.Scanner;

public class Oyun {
    private Destesi destesi;
    private Oyuncu oyuncu;
    private Oyuncu bilgisayar;

    public Oyun() {
        this.destesi = new Destesi();
        this.oyuncu = new Oyuncu("Oyuncu");
        this.bilgisayar = new Oyuncu("Bilgisayar");
        destesi.olusturVeKaristir();
    }

    public void oyunuBaslat() {
        for (int i = 0; i < 5; i++) {
            oyuncu.kartEkle(destesi.kartCek());
            bilgisayar.kartEkle(destesi.kartCek());
        }

        oyunuOyna();
    }

    private void oyunuOyna() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Kart cekilenKart = destesi.kartCek();
            if (cekilenKart == null) {
                System.out.println("Oyun destesinde kart kalmadı. Oyun berabere.");
                break;
            }

            System.out.println("Çekilen kart: " + cekilenKart);

            System.out.println("Toplam puan: " + oyuncu.getToplamPuan());
            System.out.print("Ayakta kalmak için (A) veya kart oynamak için (K) yazın: ");
            String hamle = scanner.nextLine();

            if (hamle.equalsIgnoreCase("A")) {
                System.out.println("Ayakta kalındı.");
                break;
            } else if (hamle.equalsIgnoreCase("K")) {
                System.out.println("Hangi kartı oynamak istiyorsunuz? (1-5): ");
                int kartNo = scanner.nextInt();
                scanner.nextLine();

                if (kartNo >= 1 && kartNo <= 9 && oyuncu.getTahta()[kartNo - 1] != null) {
                    cekilenKart = oyuncu.getTahta()[kartNo - 1];
                    oyuncu.getTahta()[kartNo - 1] = null;
                } else {
                    System.out.println("Geçersiz kart numarası. Geçerli bir kart seçin.");
                    continue;
                }
            } else {
                System.out.println("Geçersiz hamle. Ayakta kalmak için (A) veya kart oynamak için (K) yazın.");
                continue;
            }

            oyuncu.kartEkle(cekilenKart);

            if (cekilenKart.isFlip()) {
                System.out.println("Flip kart kullanıldı. Kartın işareti değiştirildi.");
            } else if (cekilenKart.isDouble()) {
                System.out.println("Double kart kullanıldı. Kartın değeri iki katına çıkarıldı.");
            }

            oyuncu.setToplamPuan(oyuncu.getToplamPuan() + cekilenKart.getNumara());

            if (oyuncu.isBusted()) {
                System.out.println("Oyuncu bust oldu. Bilgisayar kazandı!");
                break;
            }

            System.out.println("Şu anki puan durumu: Oyuncu " + oyuncu.getToplamPuan() + " - Bilgisayar " + bilgisayar.getToplamPuan());
            System.out.println();
        }

        if (oyuncu.getToplamPuan() <= 20 && bilgisayar.getToplamPuan() <= 20) {
            if (oyuncu.getToplamPuan() > bilgisayar.getToplamPuan()) {
                System.out.println("Oyunu kazandınız! Tebrikler!");
            } else if (oyuncu.getToplamPuan() < bilgisayar.getToplamPuan()) {
                System.out.println("Maalesef, bilgisayar kazandı.");
            } else {
                System.out.println("Oyun berabere. İki oyuncu da aynı puana sahip.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Oyun oyun = new Oyun();
        oyun.oyunuBaslat();
    }
}