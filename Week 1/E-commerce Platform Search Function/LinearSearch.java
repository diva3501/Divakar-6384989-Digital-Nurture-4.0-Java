public class LinearSearch {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
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

        int targetId = 110;

        long start = System.nanoTime();
        Product result = linearSearch(products, targetId);
        long end = System.nanoTime();

        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("Time taken by Linear Search: " + (end - start) + " ns");
    }
}
