package br.sceweb.modelo;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.sceweb.servico.FabricaDeConexoes;

public class EmpresaDao {
	
	PreparedStatement ps;
	int codigoRetorno=0;
	public int adiciona(Empresa empresa){
	try(Connection conn = new FabricaDeConexoes().getConnection()){
		ps =(PreparedStatement) conn.prepareStatement
				("insert into empresa (cnpj,nomeDaEmpresa,nomeFantasia, endereco,telefone) values (?,?,?,?,?)");
		ps.setString(1,empresa.getCnpj());
		ps.setString(2,empresa.getNomeDaEmpresa());
		ps.setString(3,empresa.getNomeFantasia());
		ps.setString(4,empresa.getEndereco());
		ps.setString(5,empresa.getTelefone());
		codigoRetorno =ps.executeUpdate();
		ps.close();
			
	}catch (SQLException e){
		throw new RuntimeException(e);
	}
	return codigoRetorno;
	
	
	}
	
	
	/**public int exclui(String cnpj){
		PreparedStatement ps;
		int codigoRetorno =0;
		try(Connection conn =new )
	}
	
	/**Logger logger = Logger.getLogger(EmpresaDao.class);
		public int adiciona(Empresa empresa ){
			
			try(Connection conn= new FabricaDeConexoes().getConnection()){
				
			}catch (SQLException e ){
				throw new RuntimeException(e);
			}
		 //logger.info("chamou o metodo adiciona");
			return 1;			
		}**/
}

