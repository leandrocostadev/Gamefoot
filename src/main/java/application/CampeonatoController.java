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
import modelo.ParticipacaoCampeonato;

public class CampeonatoController implements Initializable, OnChangeScreen {
	@FXML
	private TableView tabelaTimes;
	@FXML
	private TableColumn coluna_id;
	@FXML
	private TableColumn coluna_pos;
	@FXML
	private TableColumn coluna_time;
	@FXML
	private TableColumn coluna_jogos;
	@FXML
	private TableColumn coluna_vitorias;
	@FXML
	private TableColumn coluna_empates;
	@FXML
	private TableColumn coluna_derrotas;
	@FXML
	private TableColumn coluna_gols;
	@FXML
	private TableColumn coluna_golsContra;
	@FXML
	private TableColumn coluna_golsSaldo;
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

/*
		coluna_pos.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(
						tabelaTimes.getItems().indexOf(cellData.getValue()) + 1
				)
		);

		coluna_time.setCellValueFactory(cellData ->
				new ReadOnlyStringWrapper(
						cellData.getValue().getClube().getNome()
				)
		);

		coluna_id.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getPontos())
		);

		coluna_jogos.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getJogos())
		);

		coluna_vitorias.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getVitorias())
		);

		coluna_empates.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getEmpates())
		);

		coluna_derrotas.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getDerrotas())
		);

		coluna_gols.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getGolsPro())
		);

		coluna_golsContra.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getGolsContra())
		);

		coluna_golsSaldo.setCellValueFactory(cellData ->
				new ReadOnlyObjectWrapper<>(cellData.getValue().getGolsDiferenca())
		);*/

	}

	private void carregarTabela(long idCampeonato) {
		System.out.println("estou carregando a tabela");

		ParticipacaoCampeonatoDAO dao = new ParticipacaoCampeonatoDAO();

		ObservableList<ParticipacaoCampeonato> dados =
				FXCollections.observableArrayList(
						dao.buscarPorCampeonato(idCampeonato)
				);

		tabelaTimes.setItems(dados);
		System.out.println(tabelaTimes);
	}

}
