package android.start.change;


public class Currency {

    private String rate;
    private String currency;
    private String country;
    private int pic;


    public Currency(String country, String currency, String rate, int pic) {
        this.country = country;
        this.currency = currency;
        this.rate = rate;
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String name) {
        this.currency = currency;
    }

    public String getRate() {
        return rate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + pic;
    }
}