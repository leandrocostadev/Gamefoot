package application;
	
import java.util.ArrayList;
import interfaces.OnChangeScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	private static Stage stage;
	private static BorderPane root = new BorderPane();

	private static Scene telaInicialScene;
	private static HBox menuFixoHBox;
	private static AnchorPane gerenciamentoPane = new AnchorPane();
	private static AnchorPane campeonatoPane = new AnchorPane();
	private static AnchorPane competicaoPane = new AnchorPane();
	private static AnchorPane procurarPane = new  AnchorPane();
	private static AnchorPane gruposPane = new AnchorPane();
	private static AnchorPane copaPane = new AnchorPane();
	

	
	private static Scene menuScene = new Scene(root, 900, 700);
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			Parent fxmlTelaInicial = FXMLLoader.load(getClass().getResource("/telas/TelaInicial.fxml"));
			telaInicialScene =  new Scene(fxmlTelaInicial);
			Parent fxmlMenuFixo = FXMLLoader.load(getClass().getResource("/telas/MenuFixo.fxml"));
			menuFixoHBox = new HBox(fxmlMenuFixo);
			Parent fxmlGerenciamento = FXMLLoader.load(getClass().getResource("/telas/GerenciamentoDoTime.fxml"));
			gerenciamentoPane = new AnchorPane(fxmlGerenciamento);
			Parent fxmlCampeonato = FXMLLoader.load(getClass().getResource("/telas/Campeonato.fxml"));
			campeonatoPane = new AnchorPane(fxmlCampeonato);
			Parent fxmlProcurar = FXMLLoader.load(getClass().getResource("/telas/Procurar.fxml"));
			procurarPane = new AnchorPane(fxmlProcurar);
			Parent fxmlGrupos = FXMLLoader.load(getClass().getResource("/telas/Grupos.fxml"));
			gruposPane = new AnchorPane(fxmlGrupos);
			Parent fxmlCompeticao = FXMLLoader.load(getClass().getResource("/telas/Competicao.fxml"));
			competicaoPane = new AnchorPane(fxmlCompeticao);
			Parent fxmlCopa = FXMLLoader.load(getClass().getResource("/telas/Copa.fxml"));
			copaPane = new AnchorPane(fxmlCopa);
			
			
			primaryStage.setResizable(false);
			primaryStage.setScene(telaInicialScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScreen(String screen, Object userData){
		switch(screen){
			case "menu":
				root.setTop(menuFixoHBox);
				root.setCenter(gerenciamentoPane);
				stage.setScene(menuScene);
				stage.centerOnScreen();
				notifyAllListeners("menu", userData);
				break;
			case "gerenciamento":
				root.setCenter(gerenciamentoPane);
				root.setLeft(null);
				
				notifyAllListeners("gerenciamento", userData);
				break;
			case "campeonato":
				root.setLeft(campeonatoPane);
				root.setCenter(competicaoPane);
				System.out.println("ativou case campeonato");
				notifyAllListeners("campeonato", userData);
				break;
			case "grupos":
				root.setLeft(gruposPane);
				root.setCenter(competicaoPane);
				notifyAllListeners("grupos", userData);
				break;
			case "procurar":
				root.setLeft(null);
				root.setCenter(procurarPane);
				notifyAllListeners("procurar", userData);
				break;
			case "copa":
				root.setLeft(copaPane);
				root.setCenter(competicaoPane);
				notifyAllListeners("copa", userData);
		}
	}
	
	public static void changeScreen(String screen){
		changeScreen(screen, null);
	}
	
	
	private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
	
	public static void addOnChangeScreenListener(OnChangeScreen newListener){
		listeners.add(newListener);
	}
	
	private static void notifyAllListeners(String newScreen, Object userData){
		for(OnChangeScreen l : listeners){
			l.onScreenChanged(newScreen, userData);
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
