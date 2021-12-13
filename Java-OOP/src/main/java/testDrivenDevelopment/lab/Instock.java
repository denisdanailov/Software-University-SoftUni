package testDrivenDevelopment.lab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> inventory;

    public Instock() {
        this.inventory = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.inventory.size();
    }

    @Override
    public boolean contains(Product product) {
        for (Product item : inventory) {
            if (item.getLabel().equals(product.getLabel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
        inventory.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean isInStock = false;

        for (Product item : this.inventory) {
            if (item.getLabel().equals(product)) {
                int currQuantity = item.getQuantity();

                int remainingQuantity = currQuantity - quantity;
                item.setQuantity(Math.max(remainingQuantity, 0));

                isInStock = true;
            }
        }

        if (!isInStock) {
            throw new IllegalArgumentException("Product not in stock: " + product);
        }
    }

    @Override
    public Product find(int index) {
        Product product = null;

        if (this.inventory.size() > index) {
            product = this.inventory.get(index);
        } else {
            throw new IndexOutOfBoundsException(String.format("Index %d not in bounds.", index));
        }

        return product;
    }

    @Override
    public Product findByLabel(String label) {
        Product product = null;

        for (Product item : this.inventory) {
            if (item.getLabel().equals(label)) {
                product = item;
            }
        }

        if (product == null) {
            throw new IllegalArgumentException("Product not in stock. Label: " + label);
        }

        return product;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (this.inventory.size() >= count) {
            return this.inventory.stream()
                    .sorted((a, b) -> a.getLabel().compareTo(b.getLabel()))
                    .limit(count)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.inventory.stream()
                .filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted((a, b) -> Double.compare(b.getPrice(), a.price))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.inventory.stream()
                .filter(e -> e.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count <= this.inventory.size()) {
            return this.inventory.stream()
                    .sorted((a, b) -> Double.compare(b.getPrice(), a.price))
                    .limit(count)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.inventory.stream()
                .filter(e -> e.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.inventory.iterator();
    }
}
