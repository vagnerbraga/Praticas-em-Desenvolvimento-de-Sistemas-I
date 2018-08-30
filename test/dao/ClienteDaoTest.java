package dao;

import model.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Arquivo;

/**
 *
 * @author vagner
 */
public class ClienteDaoTest {
    
    static ClienteDao dao;
    public ClienteDaoTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        dao = new ClienteDao();
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
     * Test of salvar method, of class ClienteDao.
     */
    @Test
    public void testSalvar() throws Exception {
        Arquivo.limparArquivo(Arquivo.CLIENTE_DAT);
        System.out.println("salvar");
        Cliente entidade = new Cliente();
        entidade.setNome("Vagner");
        entidade.setRg("123");
        entidade.setCpf("456");
        
        dao.salvar(entidade);
        
        Cliente novo = dao.selecionar(1L);
                
        assertEquals("ID falhou", entidade.getId(), novo.getId());
        assertEquals("Nome falhou", entidade.getNome(), novo.getNome());
        assertEquals("RG falhou", entidade.getRg(), novo.getRg());
        assertEquals("CPF falhou", entidade.getCpf(), novo.getCpf());
    }

    /**
     * Test of alterar method, of class ClienteDao.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Cliente entidade = dao.selecionar(1L);
        
        entidade.setNome("Murilo");
        entidade.setRg("1111");
        entidade.setCpf("222");
        
        dao.alterar(entidade);
        
        Cliente novo = dao.selecionar(1L);

        assertEquals("Nome não alterado alterado", entidade.getNome(), novo.getNome());
        assertEquals("RG não alterado alterado", entidade.getRg(), novo.getRg());
        assertEquals("CPF não alterado alterado", entidade.getCpf(), novo.getCpf());
    }

    /**
     * Test of deletar method, of class ClienteDao.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        Cliente entidade = dao.selecionar(1L);
        
        dao.deletar(entidade);
        
        Cliente novo = dao.selecionar(1L);
        
        assertEquals("Ativo teria que ficar como false", false, novo.isAtivo());
        
    }

    /**
     * Test of selecionar method, of class ClienteDao.
     */
    @Test
    public void testSelecionar() throws Exception {
        System.out.println("selecionar");
        Long id = 1L;
        Cliente result = dao.selecionar(id);

        assertEquals("Cliente com o mesmo ID", id, result.getId());
    }
    
}
