package aula05.repositories.tests;

import aula05.contracts.IClienteRepository;
import aula05.entities.Cliente;
import aula05.factories.ConnectionFactory;
import aula05.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteRepositoryTest {

    // atributo
    private IClienteRepository clienteRepository;

    @BeforeEach
    void setUp() throws Exception{
        //inicializando o clienteRepository
        clienteRepository = new ClienteRepository(ConnectionFactory.getConnection());
    }


    @Test
    void testCreate() throws Exception{
        Cliente clienteIn = new Cliente(null, "Ana", "123.456.789-00", "ana@gmail.com");
        clienteRepository.create(clienteIn);

        //Critério: Após a gravação do cliente no repositório, o atributo id
        //deverá ter um valor gerado pelo método de gravação.
        assertTrue(clienteIn.getIdCliente() > 0);

        //Busca o cliente no repositório pelo id.
        Cliente clienteOut = clienteRepository.findById(clienteIn.getIdCliente());

        //Critério: Verificar se o cliente obtido na consulta é o mesmo que foi cadastrado.
        assertEquals(clienteIn, clienteOut);
    }

    @Test
    void testUpdate() throws Exception{
        Cliente clienteIn = new Cliente(null, "Ana", "123.456.789-00", "ana@gmail.com");
        clienteRepository.create(clienteIn);

        clienteIn.setNome("Ana Teste");
        clienteIn.setCpf("987.654.321-00");
        clienteIn.setNome("anateste@gmail.com");

        clienteRepository.update(clienteIn);

        Cliente clienteOut = clienteRepository.findById(clienteIn.getIdCliente());

        assertEquals(clienteIn, clienteOut);
    }

    @Test
    void testDelete() throws Exception{
        // Executando o processo de gravação
        Cliente clienteIn = new Cliente(null, "Ana", "123.456.789-00", "ana@gmail.com");
        clienteRepository.create(clienteIn);

        // excluindo o cliente
        clienteRepository.delete(clienteIn.getIdCliente());

        // Buscar o cliente no repositorio pelo id..
        Cliente clienteOut = clienteRepository.findById(clienteIn.getIdCliente());

        //Critério: o cliente obtido na consulta deve estar null..
        assertNull(clienteOut);
    }

    @Test
    void testFindAll() throws Exception{
        Cliente clienteIn = new Cliente(null, "Ana", "123.456.789-00", "ana@gmail.com");
        clienteRepository.create(clienteIn);

        List<Cliente> list = clienteRepository.findAll();

        Predicate<Cliente> byId = c -> c.getIdCliente().equals(clienteIn.getIdCliente());

        Cliente clienteOut = list.stream().filter(byId).findFirst().orElse(null);

        assertNotNull(clienteOut);
        assertEquals(clienteIn, clienteOut);
    }

    @Test
    void testFindById() throws Exception{
        Cliente clienteIn = new Cliente(null, "Ana", "123.456.789-00", "ana@gmail.com");
        clienteRepository.create(clienteIn);

        Cliente clienteOut = clienteRepository.findById(clienteIn.getIdCliente());

        assertNotNull(clienteOut);
        assertEquals(clienteIn, clienteOut);
    }
}
