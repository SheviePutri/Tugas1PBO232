import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cashier {
    private List<Item> items;

    public Cashier() {
        items = new ArrayList<>();
    }

    public void addItem(double price, String code, String name, int quantity) {
        items.add(new Item(code, name, price, quantity));
        System.out.println("Barang ditambahkan.");
    }

    public void removeItem(String code) {
        for (Item item : items) {
            if (item.getCode().equals(code)) {
                items.remove(item);
                System.out.println("Barang dihapus.");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    public void displayTransaction() {
        double total = 0.0;
        System.out.println("Daftar Item Transaksi:");
        System.out.println("Kode\tNama\tHarga\tJumlah\tSubtotal");
        for (Item item : items) {
            double subtotal = item.getPrice() * item.getStock();
            System.out.printf("%s\t%s\t%.2f\t%d\t%.2f%n", item.getCode(), item.getName(), item.getPrice(), item.getStock(), subtotal);
            total += subtotal;
        }
        System.out.printf("Total belanja: %.2f%n", total);
    }

    public void processPayment(Scanner scanner) {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getStock();
        }
        System.out.printf("Total pembayaran: %.2f%n", total);
        System.out.print("Masukkan jumlah uang yang dibayarkan: ");
        double payment = scanner.nextDouble();
        if (payment >= total) {
            double change = payment - total;
            System.out.printf("Kembali: %.2f%n", change);
        } else {
            System.out.println("Uang yang dibayarkan tidak cukup.");
        }
    }
}
