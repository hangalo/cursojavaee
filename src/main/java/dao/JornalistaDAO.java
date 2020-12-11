package dao;

import dbutil.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Jornalista;
import modelo.Municipio;

public class JornalistaDAO {

    private final String INSERT = "INSERT INTO jornalista (nome, sobrenome, casa, rua, bairro, distrito, credenciado , municipio_id) VALUES (?, ?, ?, ?, ?,?, ?, ?) ";
    private final String LIST_ALL = "SELECT j.id, j.nome, j.sobrenome, j.casa, j.rua, j.bairro, j.distrito, j.credenciado,  m.nome FROM jornalista j INNER JOIN municipio m ON j.municipio_id=m.id";

    private final String LIST_BY_NOME = "SELECT j.id, j.nome, j.sobrenome, j.casa, j.rua, j.bairro, j.distrito, j.credenciado,  m.nome FROM jornalista j INNER JOIN municipio m ON j.municipio_id=m.id WHERE j.nome LIKE ?";

    private final String DELETE = "DELETE FROM jornalista WHERE id =?";
    private final String EDIT = "UPDATE jornalista SET nome = ?, sobrenome =? , casa = ?, rua =?, bairro =?, distrito =?, credenciado =?, municipio_id =? WHERE id = ? ";

    ConexaoDB conexao = new ConexaoDB();

    //List<Jornalista> jornalistas = new ArrayList<>();
    public void guardar(Jornalista jornalista) {
        // jornalistas.add(jornalista);
        Connection conn;
        PreparedStatement ps;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, jornalista.getNome());
            ps.setString(2, jornalista.getSobrenome());
            ps.setString(3, jornalista.getCasa());
            ps.setString(4, jornalista.getRua());
            ps.setString(5, jornalista.getBairro());
            ps.setString(6, jornalista.getDistrito());
            ps.setBoolean(7, jornalista.isCredenciado());
            ps.setInt(8, jornalista.getMunicipio().getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados" + ex.getLocalizedMessage());

        }
    }

    public List<Jornalista> listarTodos() {
        List<Jornalista> jornalistas = new ArrayList<>();
        
         Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(LIST_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {

                Municipio mun = new Municipio();
                mun.setNome(rs.getString("m.nome"));
                Jornalista j = new Jornalista();
                j.setId(rs.getInt("j.id"));
                j.setNome(rs.getString("j.nome"));
                j.setSobrenome(rs.getString("j.sobrenome"));
                j.setCasa(rs.getString("j.casa"));
                j.setRua(rs.getString("j.rua"));
                j.setBairro(rs.getString("j.bairro"));
                j.setDistrito(rs.getString("j.distrito"));
                j.setCredenciado(rs.getBoolean("j.credenciado"));
                j.setMunicipio(mun);
              jornalistas.add(j);
                
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao Listar" + ex.getLocalizedMessage());
        }
        
        return jornalistas;
    }

    public void eliminar(Jornalista jornalista) {
        //jornalistas.remove(verificarExistencia(jornalista));
         Connection conn;
        PreparedStatement ps;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, jornalista.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados" + ex.getLocalizedMessage());

        }
    }

    public void actualizar(Jornalista jornalista) {
        // jornalistas.set(verificarExistencia(jornalista), jornalista);
        Connection conn;
        PreparedStatement ps;
        try {
            conn = conexao.ligarBB();
            ps = conn.prepareStatement(EDIT);
            ps.setString(1, jornalista.getNome());
            ps.setString(2, jornalista.getSobrenome());
            ps.setString(3, jornalista.getCasa());
            ps.setString(4, jornalista.getRua());
            ps.setString(5, jornalista.getBairro());
            ps.setString(6, jornalista.getDistrito());
            ps.setBoolean(7, jornalista.isCredenciado());
            ps.setInt(8, jornalista.getMunicipio().getId());
            ps.setInt(9, jornalista.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao inserir dados" + ex.getLocalizedMessage());

        }
    }

    public int verificarExistencia(Jornalista jornalista) {
        int retorno = -1;
        //  for (int i = 0; i < jornalistas.size(); i++) {
        //      if (jornalista.getNome().equals(jornalistas.get(i).getNome())) {
        //          retorno = i;
        //         break;
        //     }
        //  }
        return retorno;
    }

}
