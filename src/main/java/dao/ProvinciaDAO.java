/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Provincia;


public class ProvinciaDAO {
    private final String LIST_ALL="SELECT id, nome FROM provincia";

    ConexaoDB conexao = new ConexaoDB();

    public List<Provincia> findAll(){
    List<Provincia> lista = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps;
    ResultSet rs;
    try{
        conn = conexao.ligarBB();
        ps= conn.prepareStatement(LIST_ALL);
        rs = ps.executeQuery();
        
        while(rs.next()){
        Provincia prov = new Provincia();
        prov.setId(rs.getInt("id"));
        prov.setNome(rs.getString("nome"));
        lista.add(prov);
        }
    }catch(SQLException ex){
        System.err.println("Erro ao ler dados"+ex.getLocalizedMessage());
    }
    
    
    return lista;
    }

}
