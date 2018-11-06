package controller;

import java.sql.Connection;
import model.locadoraDAO;
import utilitarios.Conexao;
import utilitarios.beanLocadora;


public class controller {
    
    Connection con = Conexao.abrirConexao();
    
    locadoraDAO ldao = new locadoraDAO();
    
    public void controllerCadastro(beanLocadora bl) {
    
        ldao.registrarLocacao(bl);
    
    }
    
    public void controllerConsulta (beanLocadora bl){
        
        ldao.consultaLocacao(bl);
        
    }
    
    public void controllerAlterar (beanLocadora bl){
        
        ldao.alterarLocacao(bl);
        
    }
    
    public void controllerExcluir (beanLocadora bl){
        
        ldao.excluirLocacao(bl);
    }
}

