package br.com.api.suporte.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.suporte.modelo.RespostaModelo;
import br.com.api.suporte.modelo.SuporteModelo;
import br.com.api.suporte.repositorio.SuporteRepositorio;

@Service
public class SuporteServico {
    
    @Autowired
    private SuporteRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    // METODO PARA LISTAR TODAS AS SOLICITAÇÕES DE SUPORTE
    public Iterable<SuporteModelo> listar(){
        return pr.findAll();
    }

    //METODO PARA CADASTRAR ou ALTERAR AS SOLICITAÇÕES
    public ResponseEntity<?> cadastrarAlterar(SuporteModelo pm, String acao){

        if(pm.getLocal().equals("")){
            rm.setMensagem("O campo local é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getDescric_problem().equals("")){
            rm.setMensagem("O campo descrição do problema é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<SuporteModelo>(pr.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<SuporteModelo>(pr.save(pm), HttpStatus.OK);
            }
            
        }

    }

    //METODO PARA REMOVER A SOLICITAÇÃO
    public ResponseEntity<RespostaModelo> remover(Integer codigo){
        
        pr.deleteById(codigo);

        rm.setMensagem("A solicitação foi removida com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
        
    }

}