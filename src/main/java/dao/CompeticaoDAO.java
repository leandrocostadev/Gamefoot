package dao;


import modelo.Clube;
import modelo.Competicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CompeticaoDAO {

    public Competicao buscarPorId(long id) {
        String sql = "SELECT * FROM competicao WHERE idcompeticao = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return montarCompeticao(rs);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar competicao", e);
        }
    }

    public ArrayList<Competicao> buscarTodos() {
        String sql = "SELECT * FROM competicao ORDER BY nome";
        ArrayList<Competicao> competicoesLista = new ArrayList<Competicao>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                competicoesLista.add(montarCompeticao(rs));
            }
            return competicoesLista;

        } catch(Exception e){
            throw new RuntimeException("Erro ao listar competições", e);
        }
    }

    public  ArrayList<Competicao> buscarPorNome(String nome) {
        String sql = "SELECT * FROM competicao WHERE nome = ?";
        ArrayList<Competicao> competicoesLista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                competicoesLista.add(montarCompeticao(rs));
            }
            return competicoesLista;

        } catch(Exception e){
            throw new RuntimeException("Erro ao procurar competições", e);
        }
    }

    public void editar(Competicao competicao) {
        String sql = """
                UPDATE competicao SET nome = ?, quantidade_clubes = ? WHERE idcompeticao = ?;
                """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, competicao.getNome());
            ps.setInt(5, competicao.getQuantidadeClubes());

            ps.executeUpdate();


        } catch(Exception e){
            throw new RuntimeException("Erro ao editar competição", e);
        }
    }

    public void remover(long id) {
        String sql = "DELETE FROM competicao WHERE idcompeticao = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setLong(1, id);
            ps.executeUpdate();


        } catch(Exception e){
            throw new RuntimeException("Erro ao remover competição", e);
        }

    }

    private Competicao montarCompeticao(ResultSet rs) throws Exception {
        return new Competicao(
                rs.getLong("idcompeticao"),
                rs.getString("nome"),
                rs.getInt("quantidade_clubes")
        );
    }
}
