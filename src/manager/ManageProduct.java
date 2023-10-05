package manager;

import model.Product;

import java.util.ArrayList;

public class ManageProduct implements Imanager<Product> {
    ArrayList<Product>listProduct = new ArrayList<>();
    @Override
    public void add(Product product) {
        listProduct.add(product);

    }

    @Override
    public boolean edit(int id, Product product) {
        int index = findById(id);
        if (id == -1){
            return false;
        }
        listProduct.set(index,product);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int index = findById(id);
        if (index == -1){
            return false;
        }
        listProduct.remove(index);
        return true;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId()== id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int findByType(int type) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getType()== type){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Product> findAll() {
        return listProduct;
    }
}
