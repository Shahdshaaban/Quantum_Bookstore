public class ShowCase extends Book{
    public ShowCase(String isbn, String title, int publishYear, double price) {
        super(isbn, title,publishYear, price);
    }
    @Override
    public boolean isPurchasable() {
        return false;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        throw new Exception("This Demo book is not for sale");

    }



}
