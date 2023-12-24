public class Oyuncu {
    private String ad;
    private Kart[] tahta;
    private int toplamPuan;

    public Oyuncu(String ad) {
        this.ad = ad;
        this.tahta = new Kart[9];
        this.toplamPuan = 0;
    }

    public String getAd() {
        return ad;
    }

    public Kart[] getTahta() {
        return tahta;
    }

    public int getToplamPuan() {
        return toplamPuan;
    }

    public void kartEkle(Kart kart) {
        for (int i = 0; i < tahta.length; i++) {
            if (tahta[i] == null) {
                tahta[i] = kart;
                break;
            }
        }
    }

    public void temizle() {
        tahta = new Kart[9];
        toplamPuan = 0;
    }

    public boolean isBusted() {
        return toplamPuan > 20;
    }

    public void setToplamPuan(int toplamPuan) {
        this.toplamPuan = toplamPuan;
    }
}