package application;

import java.net.URL;
import java.util.ResourceBundle;

import dao.ParticipacaoCampeonatoDAO;
import interfaces.OnChangeScreen;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import modelo.Clube;
import modelo.ParticipacaoCampeonato;

public class CampeonatoController implements Initializable, OnChangeScreen {
	@FXML
	private TableView<ParticipacaoCampeonato> tabelaCampeonato;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaPontos;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaPosicao;
	@FXML
	private TableColumn<ParticipacaoCampeonato, String> colunaClube;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaJogos;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaVitorias;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaEmpates;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaDerrotas;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaGolsPro;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaGolsContra;
	@FXML
	private TableColumn<ParticipacaoCampeonato, Integer> colunaDiferenca;
	@Override
	public void onScreenChanged(String newScreen, Object userData) {
		// TODO Auto-generated method stub
		System.out.println("esta ativando onScreenChanged");
		carregarTabela(1);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("esta ativando initialize");
		Main.addOnChangeScreenListener(this);


		colunaPosicao.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(
						tabelaCampeonato.getItems().indexOf(cellData.getValue()) + 1
				)
		);

		colunaClube.setCellValueFactory(cellData ->
				new ReadOnlyStringWrapper(
						cellData.getValue().getClube().getNome()
				)
		);

		colunaPontos.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getPontos())
		);

		colunaJogos.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getJogos())
		);

		colunaVitorias.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getVitorias())
		);

		colunaEmpates.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getEmpates())
		);

		colunaDerrotas.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getDerrotas())
		);

		colunaGolsPro.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getGolsPro())
		);

		colunaGolsContra.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getGolsContra())
		);

		colunaDiferenca.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getGolsDiferenca())
		);

	}

	private void carregarTabela(long idCampeonato) {
		System.out.println("estou carregando a tabela");

		ParticipacaoCampeonatoDAO dao = new ParticipacaoCampeonatoDAO();

		ObservableList<ParticipacaoCampeonato> dados =
				FXCollections.observableArrayList(
						dao.buscarPorCampeonato(idCampeonato)
				);

		tabelaCampeonato.setItems(dados);
		System.out.println(tabelaCampeonato);
	}

}
