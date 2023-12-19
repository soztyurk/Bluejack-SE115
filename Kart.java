import java.util.Random;

public class Kart {
    private String renk;
    private int numara;
    private boolean isFlip;
    private boolean isDouble;

    public Kart(String renk, int numara, boolean isFlip, boolean isDouble) {
        this.renk = renk;
        this.numara = numara;
        this.isFlip = isFlip;
        this.isDouble = isDouble;
    }

    public String getRenk() {
        return renk;
    }

    public int getNumara() {
        return numara;
    }

    public boolean isFlip() {
        return isFlip;
    }

    public boolean isDouble() {
        return isDouble;
    }

    @Override
    public String toString() {
        String kartStr = renk + " " + numara;
        if (isFlip) {
            kartStr += " (Flip)";
        } else if (isDouble) {
            kartStr += " (x2)";
        }
        return kartStr;
    }

    public static Kart kartOlustur() {
        Random rand = new Random();
        String[] renkler = {"Mavi", "Sarı", "Kırmızı", "Yeşil"};
        String renk = renkler[rand.nextInt(renkler.length)];
        int numara = rand.nextInt(10) + 1;
        boolean isFlip = rand.nextBoolean();
        boolean isDouble = rand.nextBoolean();
        return new Kart(renk, numara, isFlip, isDouble);
    }
}