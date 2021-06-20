package ru.fairness.spring.context.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fairness.spring.context.models.Product;
import ru.fairness.spring.context.repositories.ProductRepository;

import java.util.List;
import java.util.Scanner;

@Component()
public class App {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ведите команду...");
            String command = scanner.nextLine();

            switch (command) {
                case "all" -> {
                    List<Product> list = productRepository.getAll();
                    System.out.println("All products:");
                    StringBuilder sb = new StringBuilder();
                    list.forEach(sb::append);
                    System.out.println(sb.toString());
                }
                case "one" -> {
                    System.out.println("Print UUID...");
                    String uuid = scanner.nextLine();
                    Product product = productRepository.getOne(uuid);
                    System.out.println(product == null ? "Not found" : product.toString());
                }
                case "add" -> {
                    System.out.println("Print title...");
                    String title = scanner.nextLine();
                    System.out.println("Print cost...");
                    int cost = scanner.nextInt();
                    Product newProduct = productRepository.create(title, cost);
                    System.out.println(newProduct == null ? "Not success" : newProduct.toString());
                }
                case "update" -> {
                    System.out.println("Print UUID...");
                    String uuid = scanner.nextLine();
                    System.out.println("Print title...");
                    String title = scanner.nextLine();
                    System.out.println("Print cost...");
                    int cost = scanner.nextInt();
                    Product updatedProduct = productRepository.update(uuid, title, cost);
                    System.out.println(updatedProduct == null ? "Not success" : updatedProduct.toString());
                }
                case "delete" -> {
                    System.out.println("Print UUID...");
                    String uuid = scanner.nextLine();
                    System.out.println(productRepository.delete(uuid) ? "Success" : "Not success");
                }
                case "size" -> System.out.printf("Product count: %s%n", productRepository.size());
                case "avg" -> System.out.printf("Avg cost: %s%n", productRepository.avgCost());
                default -> System.out.println("Unexpected command");
            }
        }
    }
}
