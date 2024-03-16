/* 
Deve conter apenas um atributo chamado products. Esse atributo só pode ser acessado dentro 
do controller. Ele deve ser um ArrayList que começa vazio.
*/ 

package product;

import java.util.ArrayList;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;

public class ProductController {
    private ArrayList<ProductModel> products;

    public ProductController() {
        this.products = new ArrayList<>();
    }

    // Método para criar um novo produto
    public void create(ProductModel payload) throws NegativePriceException {
        if (payload.getPriceInCents() < 0) {
            throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
        }

        this.products.add(payload);
        System.out.println("Produto '" + payload.getName() + "' adicionado.");
    }

    // Método para listar todos os produtos
    public ArrayList<ProductModel> read() {
        return this.products;
    }

    // Método para buscar o preço do produto por código de barras
    public int retrievePrice(String barCode) throws NotFoundException {
        for (ProductModel product : this.products) {
            if (product.getBarCode().equals(barCode)) {
                return product.getPriceInCents();
            }
        }
        throw new NotFoundException("Produto com código de barras '" + barCode + "' não encontrado.");
    }
}
