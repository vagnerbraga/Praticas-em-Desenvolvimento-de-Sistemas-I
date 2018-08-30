package dao;

import enumered.FormaPagamentoEnum;
import java.util.Date;
import model.ItemVenda;
import model.Venda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vagner
 */
public class VendaDaoTest {
    
    static VendaDao dao;
    
    public VendaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dao = new VendaDao();
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
     * Test of salvar method, of class VendaDao.
     */
    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Venda venda = new Venda();
        
        venda.setCliente(new ClienteDao().selecionar(1L));
        
        venda.setAtivo(true);
        venda.setData(new Date());
        venda.setFormaPagamento(FormaPagamentoEnum.A_PRAZO);
        venda.setQuantidadeDias(32);

        ItemVenda item = new ItemVenda();
        
        item.setProduto(new ProdutoDao().selecionar(1L));
        item.setQuantidade(5);
        
        venda.getItens().add(item);
        
        dao.salvar(venda);
       
        Venda novo = dao.selecionar(1L);
        
        assertEquals("cliente não esta correto", venda.getCliente().getId(), novo.getCliente().getId());
        
    }

    /**
     * Test of alterar method, of class VendaDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Venda entidade = null;
        VendaDao instance = new VendaDao();
        instance.alterar(entidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class VendaDao.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        Venda entidade = null;
        VendaDao instance = new VendaDao();
        instance.deletar(entidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecionar method, of class VendaDao.
     */
    @Test
    public void testSelecionar() throws Exception {
        System.out.println("selecionar");
        Long id = null;
        VendaDao instance = new VendaDao();
        Venda expResult = null;
        Venda result = instance.selecionar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addicionarItem method, of class VendaDao.
     */
    @Test
    public void testAddicionarItem() {
        System.out.println("addicionarItem");
        Venda venda = null;
        ItemVenda item = null;
        VendaDao instance = new VendaDao();
        instance.addicionarItem(venda, item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerItem method, of class VendaDao.
     */
    @Test
    public void testRemoverItem() {
        System.out.println("removerItem");
        Venda venda = null;
        ItemVenda item = null;
        VendaDao instance = new VendaDao();
        instance.removerItem(venda, item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
