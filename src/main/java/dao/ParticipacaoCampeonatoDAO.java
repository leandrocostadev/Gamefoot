package dao;

import modelo.Competicao;
import modelo.ParticipacaoCampeonato;
import modelo.Clube;

import java.sql.*;
import java.util.ArrayList;

public class ParticipacaoCampeonatoDAO {

    /* ================= CREATE ================= */

    public void inserir(ParticipacaoCampeonato p) {

        String sql = """
            INSERT INTO participacao_competicao
            (idclube, idcompeticao, jogos, vitorias, empates,
             derrotas, pontos, gols_pro, gols_contra, gols_diferenca)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, p.getClube().getId());
            ps.setLong(2, p.getCompeticao().getId());
            ps.setInt(3, p.getJogos());
            ps.setInt(4, p.getVitorias());
            ps.setInt(5, p.getEmpates());
            ps.setInt(6, p.getDerrotas());
            ps.setInt(7, p.getPontos());
            ps.setInt(8, p.getGolsPro());
            ps.setInt(9, p.getGolsContra());
            ps.setInt(10, p.getGolsDiferenca());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setId(rs.getLong(1));
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir participação", e);
        }
    }

    /* ================= READ ================= */

    public ParticipacaoCampeonato buscarPorId(long id) {

        String sql = """
            SELECT * FROM participacao_competicao
            WHERE idparticipacao_competicao = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return montarParticipacao(rs);
            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar participação", e);
        }
    }

    public ArrayList<ParticipacaoCampeonato> buscarPorCampeonato(long idCampeonato) {

        String sql = """
            SELECT * FROM participacao_competicao
            WHERE idcompeticao = ?
            ORDER BY pontos DESC, gols_diferenca DESC, gols_pro DESC
        """;

        ArrayList<ParticipacaoCampeonato> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, idCampeonato);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(montarParticipacao(rs));
            }
            return lista;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar participação por campeonato", e);
        }
    }

    public ArrayList<ParticipacaoCampeonato> buscarPorClube(long idClube) {

        String sql = """
            SELECT * FROM participacao_competicao
            WHERE idclube = ?
        """;

        ArrayList<ParticipacaoCampeonato> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, idClube);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(montarParticipacao(rs));
            }
            return lista;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar participação por clube", e);
        }
    }

    /* ================= UPDATE ================= */

    public void editar(ParticipacaoCampeonato p) {

        String sql = """
            UPDATE participacao_competicao SET
            jogos = ?, vitorias = ?, empates = ?, derrotas = ?,
            pontos = ?, gols_pro = ?, gols_contra = ?, gols_diferenca = ?
            WHERE idparticipacao_competicao = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getJogos());
            ps.setInt(2, p.getVitorias());
            ps.setInt(3, p.getEmpates());
            ps.setInt(4, p.getDerrotas());
            ps.setInt(5, p.getPontos());
            ps.setInt(6, p.getGolsPro());
            ps.setInt(7, p.getGolsContra());
            ps.setInt(8, p.getGolsDiferenca());
            ps.setLong(9, p.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar participação", e);
        }
    }

    /* ================= DELETE ================= */

    public void remover(long id) {

        String sql = """
            DELETE FROM participacao_competicao
            WHERE idparticipacao_competicao = ?
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover participação", e);
        }
    }

    /* ================= MAPPER ================= */

    private ParticipacaoCampeonato montarParticipacao(ResultSet rs) throws Exception {

        Clube clube = new ClubeDAO().buscarPorId(rs.getLong("idclube"));
        Competicao competicao =
                new CompeticaoDAO().buscarPorId(rs.getLong("idcompeticao"));

        return new ParticipacaoCampeonato(
                rs.getLong("idparticipacao_competicao"),
                clube,
                competicao,
                rs.getInt("jogos"),
                rs.getInt("vitorias"),
                rs.getInt("empates"),
                rs.getInt("derrotas"),
                rs.getInt("pontos"),
                rs.getInt("gols_pro"),
                rs.getInt("gols_contra"),
                rs.getInt("gols_diferenca")
        );
    }
}