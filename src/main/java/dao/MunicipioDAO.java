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
import modelo.Municipio;
import modelo.Provincia;

public class MunicipioDAO {

    private final String INSERT = "INSERT INTO municipio(nome, provincia_id) VALUES(?, ?)";
    private final String LIST_ALL = "SELECT m.id, m.nome, p.nome"
            + " FROM municipio m"
            + " INNER JOIN provincia p "
            + "ON m.provincia_id=p.id";

    private final String LIST_BY_NOME = "SELECT m.id, m.nome, p.nome"
            + " FROM municipio m"
            + " INNER JOIN provincia p "
            + "ON m.provincia_id=p.id"
            + "WHERE m.nome LIKE ?";

    private final String DELETE = "DELETE FROM municipio WHERE id =?";
    private final String EDIT = "UPDATE municipio SET nome = ?, provincia_id = ? WHERE id = ?";

    ConexaoDB conexao = new ConexaoDB();

    public void insert(Municipio municipio) {
        Connection conn;
        PreparedStatement ps;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, municipio.getNome());
            ps.setInt(2, municipio.getProvincia().getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados" + ex.getLocalizedMessage());

        }

    }

    public void update(Municipio municipio) {
        Connection conn;
        PreparedStatement ps;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(EDIT);
            ps.setString(1, municipio.getNome());
            ps.setInt(2, municipio.getProvincia().getId());
            ps.setInt(3, municipio.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados" + ex.getLocalizedMessage());

        }

    }
    
 public void delete(Municipio municipio) {
        Connection conn;
        PreparedStatement ps;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, municipio.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados" + ex.getLocalizedMessage());

        }

    }
    public List<Municipio> findAll() {
        List<Municipio> lista = new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(LIST_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {

                Municipio mun = new Municipio();
                mun.setId(rs.getInt("m.id"));
                mun.setNome(rs.getString("m.nome"));

                Provincia p = new Provincia();
                p.setNome(rs.getString("p.nome"));
                mun.setProvincia(p);
                lista.add(mun);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao Listar" + ex.getLocalizedMessage());
        }

        return lista;

    }

    public List<Municipio> findByNome(String nome) {
        List<Municipio> lista = new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(LIST_ALL);
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {

                Municipio mun = new Municipio();
                mun.setId(rs.getInt("m.id"));
                mun.setNome(rs.getString("m.nome"));

                Provincia p = new Provincia();
                p.setNome(rs.getString("p.nome"));
                mun.setProvincia(p);
                lista.add(mun);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao Listar" + ex.getLocalizedMessage());
        }

        return lista;

    }

}
