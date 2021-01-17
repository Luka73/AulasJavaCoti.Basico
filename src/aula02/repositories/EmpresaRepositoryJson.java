package aula02.repositories;

import aula02.entities.Empresa;
import aula02.interfaces.IEmpresaRepository;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.HashMap;

public class EmpresaRepositoryJson implements IEmpresaRepository {

    @Override
    public void exportarDados(Empresa empresa) throws Exception {
        HashMap<String, Object> item = new HashMap<>();
        item.put("idEmpresa", empresa.getIdEmpresa());
        item.put("razaoSocial", empresa.getRazaoSocial());
        item.put("cnpj", empresa.getCnpj());

        JSONObject json = new JSONObject(item);

        FileWriter file = new FileWriter("C:\\Projects\\AulasJavaCoti.Basico\\src\\aula02\\files\\empresa.json");
        file.write(json.toJSONString());
        file.flush();
        file.close();
    }
}
