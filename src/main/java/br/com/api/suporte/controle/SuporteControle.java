package br.com.api.suporte.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.suporte.modelo.RespostaModelo;
import br.com.api.suporte.modelo.SuporteModelo;
import br.com.api.suporte.servico.SuporteServico;

@RestController
@CrossOrigin(origins = "*")
public class SuporteControle {

    @Autowired
    private SuporteServico ps;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Integer codigo){
        return ps.remover(codigo);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody SuporteModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody SuporteModelo pm){
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<SuporteModelo> listar(){
        return ps.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "API de suporte funcionando!";
    }
}
