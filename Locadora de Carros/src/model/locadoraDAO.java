
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utilitarios.Conexao;
import utilitarios.beanLocadora;



public class locadoraDAO {
    
    beanLocadora bl = new beanLocadora();
    
    private Connection con = Conexao.abrirConexao();
    
             
    public void registrarLocacao(beanLocadora bl){
        
        String sql = "insert into tbl_locacao (data_retirada, data_entrega, valor_diaria, marca_carro, nome_locatario)"
                + "values('" + bl.getData_retirada() + "', '" + bl.getData_entrega() + "', " + bl.getValor_diaria() + ", "
                + "'" + bl.getMarca_carro() + "', '" + bl.getNome_locatario() + "')";
        
       
        try{
        
            PreparedStatement ps = getCon().prepareStatement(sql);
           
            ps.executeUpdate();
           

            JOptionPane.showMessageDialog(null, "Locação registrada com sucesso!", "Registro de Locação", JOptionPane.INFORMATION_MESSAGE);
        
        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);

        } 
        
    }

    public void consultaLocacao (beanLocadora bl){
        
        String codigo = (JOptionPane.showInputDialog(null, "Informe o codigo respectivo a locacação: ", "Informar", JOptionPane.INFORMATION_MESSAGE));
        
        String sql = "SELECT * FROM TBL_LOCACAO WHERE cod_locacao = " + codigo + ";";   
          
         try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            rs.next();
            
            //beanLocadora recebendo os valores do bd
            bl.setMarca_carro(rs.getString("marca_carro"));
            bl.setCod_locacao(rs.getInt("cod_locacao"));
            bl.setData_retirada(rs.getString("data_retirada"));
            bl.setData_entrega(rs.getString("data_entrega"));
            bl.setValor_diaria(rs.getInt("valor_diaria"));
            bl.setNome_locatario(rs.getString("nome_locatario"));
            
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        } 

    } 
    
    public void alterarLocacao (beanLocadora bl) {
    
    String sql = "UPDATE TBL_LOCACAO SET DATA_RETIRADA = '" + bl.getData_retirada() + "', DATA_ENTREGA = '" + bl.getData_entrega() + "', MARCA_CARRO = '"
                    + bl.getMarca_carro() + "', VALOR_DIARIA = " + bl.getValor_diaria() + ", NOME_LOCATARIO = '" + bl.getNome_locatario() + "'"
            + " WHERE COD_LOCACAO =" + bl.getCod_locacao() + ";";
    
     try {
            
            PreparedStatement ps = con.prepareStatement(sql);
         
            ps.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Locação alterada com sucesso!", "Alterar Locação", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }
    
    }
    
    public void excluirLocacao (beanLocadora bl){
        
        try{
            
            String sql = "DELETE FROM TBL_LOCACAO WHERE COD_LOCACAO = " + bl.getCod_locacao() + ";";
            
            JOptionPane.showConfirmDialog(null, "Tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION);
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Locação excluída com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException e){
        
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);            
            
        }
        
    }
    
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
}
