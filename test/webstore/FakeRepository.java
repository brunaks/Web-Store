package webstore;

import java.util.ArrayList;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
class FakeRepository implements Repository {

    private ArrayList<Customer> storedCustomers = new ArrayList<Customer>();
    private ArrayList<Product> storedProducts = new ArrayList<Product>();

    @Override
    public Customer getCustomerById(String id) {
        for (int i = 0; i < this.storedCustomers.size(); i++) {
            if (storedCustomers.get(i).getId().equalsIgnoreCase(id)) {
                return this.storedCustomers.get(i);
            }
        }
        throw new CustomerNotFound();
    }

    @Override
    public void saveCustomer(Customer customer) {
        for (int i = 0; i < storedCustomers.size(); i++) {
            if (customer == this.storedCustomers.get(i)) {
                return;
            }
        }
        this.storedCustomers.add(customer);
    }

    @Override
    public void saveProduct(Product product) {
        for (int i = 0; i < storedProducts.size(); i++) {
            if (product == this.storedProducts.get(i)) {
                return;
            }
        }
        this.storedProducts.add(product);
    }

    @Override
    public Product getProductById(String productId) {
        for (int i = 0; i < storedProducts.size(); i++) {
            if (productId.equalsIgnoreCase(this.storedProducts.get(i).getId())) {
                return this.storedProducts.get(i);
            }
        }
        throw new ProductNotFound();
    }
}
