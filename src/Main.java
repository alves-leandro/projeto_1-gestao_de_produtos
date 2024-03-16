import java.util.ArrayList;
import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import product.ProductController;
import product.ProductModel;

public class Main {
    public static void main(String[] args) {
        // Teste da aplicação
        ProductController controller = new ProductController();

        // Dados do produto
        String barcode = "123456789";
        String name = "Produto 1";
        int price = 1000;
        int stock = 50;

        try {
            // Adicionando produto ao sistema
            controller.create(new ProductModel(barcode, name, price, stock));
        } catch (NegativePriceException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }

        // Listando todos os produtos
        ArrayList<ProductModel> products = controller.read();
        System.out.println("Produtos cadastrados:");
        for (ProductModel product : products) {
            System.out.println(product.getName() + " - R$" + (product.getPriceInCents() / 100.0));
        }

        // Testando a busca de preço por código de barras
        try {
            int retrievedPrice = controller.retrievePrice(barcode);
            System.out.println("Preço do produto com código de barras " + barcode + ": R$" + (retrievedPrice / 100.0));
        } catch (NotFoundException e) {
            System.out.println("Produto não encontrado: " + e.getMessage());
        }
    }
}

/* 
 * Criação de Produtos: Permitir que o usuário adicione novos produtos ao sistema, com cada produto tendo um identificador único, nome, preço em centavos e quantidade em estoque.
 * Preço deve ser positivo: Ao fazer a criação de um produto, deve validar se o preço enviado é um valor positivo ou não.
 * Listagem de Produtos: Facilitar a visualização de todos os produtos disponíveis no sistema.
 * Busca de Preço do Produtos por Código de Barras: Oferecer uma funcionalidade de busca para localizar rapidamente o preço do produto pelo código de barras.
 */