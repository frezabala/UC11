
import com.mycompany.exerciciosestoque.Estoque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FRELIANNYSISMELIALOP
 */
public class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    public void EstoqueNovo() {
        estoque = new Estoque();
    }

    @AfterEach
    public void ClearEstoque() {
        estoque.limparEstoque();
    }

    @Test
    public void testAdicionarProdutoNovo() {
        estoque.AdicionarProduto("Produto A", 10);
        assertEquals(10, estoque.consultarQuantidade("Produto A"));
    }
    
     @Test
    public void testAdicionarProdutoExistente() {
        estoque.AdicionarProduto("arroz", 10);
        estoque.AdicionarProduto("arroz", 5);
        assertEquals(15, estoque.consultarQuantidade("arroz"));
    }

    @Test
    public void testRemoverProdutoComSuceso() {
        estoque.AdicionarProduto("Produto A", 10);
        estoque.removeProduto("Produto A", 5);
        assertEquals(5, estoque.consultarQuantidade("Produto A"));
    }

    @Test
    public void testRemoverProdutoInexistente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            estoque.removeProduto("Produto Inexistente", 1);
        });
        assertEquals("Produto não encontrado.", exception.getMessage());
    }

    @Test
    public void testRemoverQuantidadeMaiorQueDisponivel() {
        estoque.AdicionarProduto("Produto A", 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            estoque.removeProduto("Produto A", 10);
        });
        assertEquals("Quantidade a remover é maior que a disponível.", exception.getMessage());
    }
    
        @Test
    public void testConsultarQuantidadeProduto() {
        estoque.AdicionarProduto("banana", 50);
        assertEquals(50, estoque.consultarQuantidade("banana"));
    }

    @Test
    public void testConsultarQuantidadeProdutoInexistente() {
        assertEquals(0, estoque.consultarQuantidade("banana"));
    }

    @Test
    public void testProdutoMaisEstocado() {
        estoque.AdicionarProduto("Produto A", 10);
        estoque.AdicionarProduto("Produto B", 20);
        assertEquals("Produto B", estoque.produtoMaisEstocado());
    }

    @Test
    public void testLimparEstoque() {
        estoque.AdicionarProduto("Produto A", 10);
        estoque.limparEstoque();
        assertEquals(0, estoque.consultarQuantidade("Produto A"));
    }

}
