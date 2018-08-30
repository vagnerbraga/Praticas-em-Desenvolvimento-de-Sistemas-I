package dao;

import model.ControleEstoque;
import model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Arquivo;

public class ControleEstoqueDaoTest {
    
    static ControleEstoqueDao dao;
    public ControleEstoqueDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dao = new ControleEstoqueDao();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class ControleEstoqueDao.
     */
    @Test
    public void testSalvar() throws Exception {
        Arquivo.limparArquivo(Arquivo.ESTOQUE_DAT);
        System.out.println("salvar");

        Produto p = new ProdutoDao().selecionar(1L);
        
        ControleEstoque entidade = new ControleEstoque(p, 100.00);
        dao.salvar(entidade);
        
        ControleEstoque novo = new ControleEstoque();
        novo = dao.selecionar(1L);
        
        
        assertEquals("ID falhou", entidade.getProduto(), novo.getProduto());
        assertEquals("Quantidade falhou", entidade.getProduto(), novo.getProduto());

    }

    /**
     * Test of alterar method, of class ControleEstoqueDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        ControleEstoque entidade = dao.selecionar(1L);
        dao.alterar(entidade);
    }

    /**
     * Test of deletar method, of class ControleEstoqueDao.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        ControleEstoque entidade = dao.selecionar(1L);
        dao.deletar(entidade);
        
        entidade = dao.selecionar(1L);
        
        assertEquals("Objeto não inativado", false, entidade.isAtivo());
    }

    /**
     * Test of selecionar method, of class ControleEstoqueDao.
     */
    @Test
    public void testSelecionar() throws Exception {
        System.out.println("selecionar");
        Long id = 1L;
        ControleEstoque result = dao.selecionar(id);
        assertEquals("ID não correspnde com objto criado", id, result.getId());
    }
    
}
