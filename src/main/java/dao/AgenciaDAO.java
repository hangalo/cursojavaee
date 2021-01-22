package dao;

import dbutil.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Agencia;

public class AgenciaDAO {

    private String LISTA_TUDO = "SELECT * FROM agencia";
    private String INSERT = "INSERT INTO agencia (nome, telefone, email) VALUES(?,?,?)";

    ConexaoDB conexao = new ConexaoDB();

    public void insert(Agencia ag) {
        PreparedStatement ps;
        Connection conn;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, ag.getNome());
            ps.setString(2, ag.getTelefone());
            ps.setString(3, ag.getEmail());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir dados"+ex.getLocalizedMessage());
        }

    }

    public List<Agencia> findAll() {
        List<Agencia> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(LISTA_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Agencia ag = new Agencia();
                ag.setId(rs.getInt(1));
                ag.setNome(rs.getString(2));
                ag.setTelefone(rs.getNString(3));
                ag.setEmail(rs.getNString(4));
                lista.add(ag);
            }
        } catch (SQLException ex) {
            System.err.println("Erro na leitura de dados" + ex);
        }

        return lista;
    }
}
