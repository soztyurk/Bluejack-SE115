import java.util.Random;

public class Destesi {
    private static final int DESTE_BOYUTU = 40;
    private Kart[] destesi;
    private int currentIndex;

    public Destesi() {
        this.destesi = new Kart[DESTE_BOYUTU];
        this.currentIndex = 0;
    }

    public void olusturVeKaristir() {
        String[] renkler = {"Mavi", "Sarı", "Kırmızı", "Yeşil"};

        int index = 0;
        for (String renk : renkler) {
            for (int numara = 1; numara <= 10; numara++) {
                destesi[index] = new Kart(renk, numara, false, false);
                index++;
            }
        }

        karistir();

        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int randIndex = rand.nextInt(DESTE_BOYUTU);
            destesi[randIndex] = new Kart(destesi[randIndex].getRenk(), destesi[randIndex].getNumara(),
                    rand.nextBoolean(), rand.nextBoolean());
        }
    }

    public Kart kartCek() {
        if (currentIndex < DESTE_BOYUTU) {
            return destesi[currentIndex++];
        }
        return null;
    }

    private void karistir() {
        Random rand = new Random();
        for (int i = 0; i < destesi.length; i++) {
            int randIndex = rand.nextInt(destesi.length);
            Kart temp = destesi[i];
            destesi[i] = destesi[randIndex];
            destesi[randIndex] = temp;
        }
    }
}