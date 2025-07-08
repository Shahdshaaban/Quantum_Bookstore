public class PaperBook extends Book{
    private int stock;

    public PaperBook(String isbn, String title, int publishYear, double price, int stock) {
        super(isbn, title, publishYear, price);
        setStock(stock);
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reduceStock (int quantity) throws Exception{
        if (stock < quantity) {
            throw new Exception("Quantum book store: Not enough stock for" + title);
        }
        stock -= quantity;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        if (stock < quantity) {
            throw new Exception("Not enough stock for " + title);
        }
        if (address == null || address.isEmpty()) {
            throw new Exception("Address is required for PaperBook.");
        }

        stock -= quantity;
        System.out.println("Quantum book store: " + title + " book sent to address: " + address);
        return price * quantity;

    }

}
