import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Phone", "Electronics"),
            new Product(102, "Laptop", "Electronics"),
            new Product(110, "Shoes", "Fashion"),
            new Product(101, "Book", "Education"),
            new Product(108, "Keyboard", "Electronics"),
            new Product(115, "Chair", "Furniture")
        };

        // Sort the products array by productId before binary search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        int targetId = 110;

        long start = System.nanoTime();
        Product result = binarySearch(products, targetId);
        long end = System.nanoTime();

        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("Time taken by Binary Search: " + (end - start) + " ns");
    }
}
