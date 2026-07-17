package application;

import java.net.URL;
import java.util.ResourceBundle;

import interfaces.OnChangeScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class GruposController implements Initializable, OnChangeScreen {
	@FXML
	private TableView tabelaGrupoA;
	@FXML
	private TableColumn coluna_posA;
	@FXML
	private TableColumn coluna_timeA;
	@FXML
	private TableColumn coluna_pontosA;
	@FXML
	private TableColumn coluna_jogosA;
	@FXML
	private TableColumn coluna_vitoriasA;
	@FXML
	private TableColumn coluna_empatesA;
	@FXML
	private TableColumn coluna_derrotasA;
	@FXML
	private TableColumn coluna_golproA;
	@FXML
	private TableColumn coluna_golconA;
	@FXML
	private TableColumn coluna_saldoA;
	@FXML
	private TableView tabelaGrupoB;
	@FXML
	private TableColumn coluna_posB;
	@FXML
	private TableColumn coluna_timeB;
	@FXML
	private TableColumn coluna_pontosB;
	@FXML
	private TableColumn coluna_jogosB;
	@FXML
	private TableColumn coluna_vitoriasB;
	@FXML
	private TableColumn coluna_empatesB;
	@FXML
	private TableColumn coluna_derrotasB;
	@FXML
	private TableColumn coluna_golproB;
	@FXML
	private TableColumn coluna_golconB;
	@FXML
	private TableColumn coluna_saldoB;
	@FXML
	private TableView tabelaGrupoC;
	@FXML
	private TableColumn coluna_posC;
	@FXML
	private TableColumn coluna_timeC;
	@FXML
	private TableColumn coluna_pontosC;
	@FXML
	private TableColumn coluna_jogosC;
	@FXML
	private TableColumn coluna_vitoriasC;
	@FXML
	private TableColumn coluna_empatesC;
	@FXML
	private TableColumn coluna_derrotasC;
	@FXML
	private TableColumn coluna_golproC;
	@FXML
	private TableColumn coluna_golconC;
	@FXML
	private TableColumn coluna_saldoC;
	@FXML
	private TableView tabelaGrupoD;
	@FXML
	private TableColumn coluna_posD;
	@FXML
	private TableColumn coluna_timeD;
	@FXML
	private TableColumn coluna_pontosD;
	@FXML
	private TableColumn coluna_jogosD;
	@FXML
	private TableColumn coluna_vitoriasD;
	@FXML
	private TableColumn coluna_empatesD;
	@FXML
	private TableColumn coluna_derrotasD;
	@FXML
	private TableColumn coluna_golproD;
	@FXML
	private TableColumn coluna_golconD;
	@FXML
	private TableColumn coluna_saldoD;
	@FXML
	private TableView tabelaGrupoE;
	@FXML
	private TableColumn coluna_posE;
	@FXML
	private TableColumn coluna_timeE;
	@FXML
	private TableColumn coluna_pontosE;
	@FXML
	private TableColumn coluna_jogosE;
	@FXML
	private TableColumn coluna_vitoriasE;
	@FXML
	private TableColumn coluna_empatesE;
	@FXML
	private TableColumn coluna_derrotasE;
	@FXML
	private TableColumn coluna_golproE;
	@FXML
	private TableColumn coluna_golconE;
	@FXML
	private TableColumn coluna_saldoE;
	@FXML
	private TableView tabelaGrupoF;
	@FXML
	private TableColumn coluna_posF;
	@FXML
	private TableColumn coluna_timeF;
	@FXML
	private TableColumn coluna_pontosF;
	@FXML
	private TableColumn coluna_jogosF;
	@FXML
	private TableColumn coluna_vitoriasF;
	@FXML
	private TableColumn coluna_empatesF;
	@FXML
	private TableColumn coluna_derrotasF;
	@FXML
	private TableColumn coluna_golproF;
	@FXML
	private TableColumn coluna_golconF;
	@FXML
	private TableColumn coluna_saldoF;
	@FXML
	private TableView tabelaGrupoG;
	@FXML
	private TableColumn coluna_posG;
	@FXML
	private TableColumn coluna_timeG;
	@FXML
	private TableColumn coluna_pontosG;
	@FXML
	private TableColumn coluna_jogosG;
	@FXML
	private TableColumn coluna_vitoriasG;
	@FXML
	private TableColumn coluna_empatesG;
	@FXML
	private TableColumn coluna_derrotasG;
	@FXML
	private TableColumn coluna_golproG;
	@FXML
	private TableColumn coluna_golconG;
	@FXML
	private TableColumn coluna_saldoG;
	@FXML
	private TableView tabelaGrupoH;
	@FXML
	private TableColumn coluna_posH;
	@FXML
	private TableColumn coluna_timeH;
	@FXML
	private TableColumn coluna_pontosH;
	@FXML
	private TableColumn coluna_jogosH;
	@FXML
	private TableColumn coluna_vitoriasH;
	@FXML
	private TableColumn coluna_empatesH;
	@FXML
	private TableColumn coluna_derrotasH;
	@FXML
	private TableColumn coluna_golproH;
	@FXML
	private TableColumn coluna_golconH;
	@FXML
	private TableColumn coluna_saldoH;
	@FXML
    private Button bFaseAnt;
	@FXML
    private Button bFaseProx;
	
	
	@FXML
    void faseAnterior(ActionEvent event) {

    }

    @FXML
    void ProximaFase(ActionEvent event) {

    }
	
	@Override
	public void onScreenChanged(String newScreen, Object userData) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Main.addOnChangeScreenListener(this);
		
	}

}
