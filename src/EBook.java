public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int publishYear, double price, String fileType) {
        super(isbn, title, publishYear, price);
        setFileType(fileType);
    }

    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        if (email == null || email.isEmpty()) {
            throw new Exception("Email is required to send this Ebook.");
        }

        System.out.println("Quantum book store: " + title + " Ebook sent to email: " + email);
        return price * quantity;
    }
}
