package dao;

import java.util.List;
import model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Arquivo;

public class ProdutoDaoTest {
    
    static ProdutoDao dao;
    
    public ProdutoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dao = new ProdutoDao();
        
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
     * Test of salvar method, of class ProdutoDao.
     */
    @Test
    public void testSalvar() throws Exception {
        Arquivo.limparArquivo(Arquivo.PRODUTO_DAT);
        System.out.println("salvar");
        Produto entidade = new Produto(1L, "Nome do produto 001", "Litro", 1.00, 12.50);
        dao.salvar(entidade);
        
        Produto p = dao.selecionar(1L);
        
        this.verificaDados(entidade, p);
        
    }

    /**
     * Test of alterar method, of class ProdutoDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Produto entidade = dao.selecionar(1L);
        entidade.setNome("alterei o nome do produto");
        entidade.setTipoEmbalagem("Tipo Embalagem 001");
        entidade.setQuantidadeEmbalagem(11.11);
        entidade.setValor(52.5D);

        dao.alterar(entidade);
        
        Produto p = dao.selecionar(1L);
        
        this.verificaDados(entidade, p);
    }

    private void verificaDados(Produto entidade, Produto p) {
        assertEquals("ID esta errado", entidade.getId(), p.getId());
        assertEquals("Nome esta errado", entidade.getNome(), p.getNome());
        assertEquals("Tipo de embalagem", entidade.getTipoEmbalagem(), p.getTipoEmbalagem());
        assertEquals("Quantidade", entidade.getQuantidadeEmbalagem(), p.getQuantidadeEmbalagem());
        assertEquals("Valor: ", entidade.getValor(), p.getValor());
    }

    /**
     * Test of deletar method, of class ProdutoDao.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        Produto entidade = dao.selecionar(1L);
        
        dao.deletar(entidade);
        
        Produto p = dao.selecionar(1L);
        
        assertEquals("valores nao correposnente ", false, p.isAtivo());
    }

    /**
     * Test of selecionar method, of class ProdutoDao.
     */
    @Test
    public void testSelecionar() throws Exception {
        System.out.println("selecionar");
        Long id = 1L;
        Produto result = dao.selecionar(id);
        assertEquals("Valores não estão certos", id, result.getId());
    }
 
    @Test
    public void testBuscarLista() throws Exception{
        System.out.println("buscar Lista");
        List<Produto> lista = dao.buscarLista(new Produto());
        
        lista.forEach((item)->{
            System.out.println("dao.ProdutoDaoTest.testBuscarLista() " + item.getNome());
        });
        
        assertEquals("total de itens não corresponde ", 2, lista.size());
        
    }
    
}
