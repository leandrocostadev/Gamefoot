package dao;

import modelo.Clube;

import java.sql.*;
import java.util.ArrayList;

public class ClubeDAO {

    public void inserir(Clube clube) {
        String sql = "INSERT INTO Clube (nome, escudo, " +
                "cor_primaria, cor_secundaria, reputacao) VALUES (?, ?, ?, ?, ?)";
        try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, clube.getNome());
            ps.setString(2, clube.getEscudo());
            ps.setString(3, clube.getCorPrimariaHex());
            ps.setString(4, clube.getCorSecundariaHex());
            ps.setInt(5, clube.getReputacao());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                clube.setId(rs.getInt(1));
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir clube", e);
        }
    }

    public Clube buscarPorId(long id) {
        String sql = "SELECT * FROM Clube WHERE idclube = ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return montarClube(rs);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clube", e);
        }
    }

    public ArrayList<Clube> buscarTodos() {
        String sql = "SELECT * FROM Clube ORDER BY nome";
        ArrayList<Clube> clubesLista = new ArrayList<Clube>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                clubesLista.add(montarClube(rs));
            }
            return clubesLista;

        } catch(Exception e){
            throw new RuntimeException("Erro ao listar clubes", e);
        }
    }

    public  ArrayList<Clube> buscarPorNome(String nome) {
        String sql = "SELECT * FROM Clube WHERE nome = ?";
        ArrayList<Clube> clubesLista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                clubesLista.add(montarClube(rs));
            }
            return clubesLista;

        } catch(Exception e){
            throw new RuntimeException("Erro ao procurar clubes", e);
        }
    }

    public void editar(Clube clube) {
        String sql = """
                UPDATE clube SET nome = ?, escudo = ?, cor_primaria = ?, 
                reputacao = ? WHERE idclube = ?;
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, clube.getNome());
            ps.setString(2, clube.getEscudo());
            ps.setString(3, clube.getCorPrimariaHex());
            ps.setString(4, clube.getCorSecundariaHex());
            ps.setInt(5, clube.getReputacao());

            ps.executeUpdate();


        } catch(Exception e){
            throw new RuntimeException("Erro ao editar clubes", e);
        }
    }

    public void remover(long id) {
        String sql = "DELETE FROM clube WHERE idclube = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setLong(1, id);
            ps.executeUpdate();


        } catch(Exception e){
            throw new RuntimeException("Erro ao remover clubes", e);
        }

    }

    private Clube montarClube(ResultSet rs) throws Exception {
        return new Clube(
                rs.getLong("idclube"),
                rs.getString("nome"),
                rs.getString("escudo"),
                rs.getString("cor_primaria"),
                rs.getString("cor_secundaria"),
                rs.getInt("reputacao")
        );
    }

}
