package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.io.File;
import java.io.RandomAccessFile;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Main extends Application {
	
	public RandomAccessFile raf;
		int i = 0;
		Employee[] abArray ;
		final static int CLASSNAME_SIZE = 32;
		final static int FIRSTNAME_SIZE = 32;
		final static int LASTNAME_SIZE = 32;
		final static int SSN_SIZE = 24;
		final static int GROSSSALES_SIZE = 24;
		final static int COMMISSIONRATE_SIZE = 12;
		final static int BASESALARY_SIZE = 12;
		final static int WEEKLYSALARY_SIZE = 12;
		final static int WAGE_SIZE = 12;
		final static int HOURS_SIZE = 3;
		final static int RECORD_SIZE = 198;
		
		//TEXTFİELDS
		TextField tfFN     = new TextField();
		TextField tfLN     = new TextField();
		TextField tfSSN    = new TextField();
		TextField tfSEARCH = new TextField();
		TextField tfGS     = new TextField();
		TextField tfCR     = new TextField();
		TextField tfBS     = new TextField();
		TextField tfWS     = new TextField();
		TextField tfW      = new TextField();
		TextField tfH      = new TextField();
		
		//BUTTONS
		Button btAdd       = new Button("Add");
		Button btSearchSSN = new Button("Search by SSN");
		Button btUpdateSSN = new Button ("Update by SSN");
		Button btClean     = new Button ("Clean textFields");
		
		//LABELS
		Label lbFN = new Label ("First Name");
		Label lbLN = new Label ("Last Name");
		Label lbSSN = new Label ("SSN");
		Label lbSEARCH = new Label("Search/Update SSN");
		Label lbGS = new Label ("Gross Sales");
		Label lbCR = new Label ("Commission Rate");
		Label lbBS = new Label ("Base Salary");
		Label lbWS = new Label ("Weekly Salary");
		Label lbW = new Label ("Wage");
		Label lbH = new Label ("Hours");
		Label lbSALARY = new Label ("SALARY");
		Label lbCET = new Label ("Choose Employee Type");
		
		
		//COMBO BOX
		 String Employee_Type[] = {"Salaried Employee" , "Hourly Employee" , "Commission Employee" , "Base Plus Commission Employee" , "None"};
		  ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(Employee_Type));
		public Main() {
			try {
				raf = new RandomAccessFile("address.dat","rw");
				abArray = new Employee[1000];
			}
			catch(IOException ex) {
				ex.printStackTrace();
				System.exit(1);
			}
		}
	  @Override 
	  
	  
	  public void start(Stage primaryStage)throws Exception {
		  
		  
		  Image image = new Image("icon.jpg");
		  primaryStage.getIcons().add(image);
		  primaryStage.setTitle("EMPLOYEE SALARY CALCULATOR");
		  tfFN.setPrefColumnCount(15);
		  tfLN.setPrefColumnCount(15);
		  tfSSN.setPrefColumnCount(15);
		  tfSEARCH.setPrefColumnCount(15);
		  tfGS.setPrefColumnCount(15);
		  tfCR.setPrefColumnCount(15);
		  tfBS.setPrefColumnCount(15);
		  tfWS.setPrefColumnCount(15);
		  tfW.setPrefColumnCount(15);
		  tfH.setPrefColumnCount(15);
		  
		  //pane p1
		  GridPane p1 = new GridPane();
		  p1.setAlignment(Pos.CENTER);
		  p1.setHgap(6);
		  p1.setVgap(6);
		  
		  p1.add(lbFN, 0, 0);
		  p1.add(tfFN, 1, 0);
		  
		  p1.add(lbLN, 0, 1);
		  p1.add(tfLN, 1, 1);
		  
		  p1.add(lbSSN, 0, 2);
		  p1.add(tfSSN, 1, 2);
		  
		  p1.add(lbSEARCH, 0, 3);
		  p1.add(tfSEARCH, 1, 3);
		  
		  p1.add(lbSALARY, 0, 5);
		  
		  p1.add(lbGS, 10, 0);
		  p1.add(tfGS, 11, 0);
		  
		  p1.add(lbCR, 10, 1);
		  p1.add(tfCR, 11, 1);
		  
		  p1.add(lbBS, 10, 2);
		  p1.add(tfBS, 11, 2);
		  
		  p1.add(lbWS, 10, 3);
		  p1.add(tfWS, 11, 3);
		  
		  p1.add(lbW, 10, 4);
		  p1.add(tfW, 11, 4);
		  
		  p1.add(lbH, 10, 5);
		  p1.add(tfH, 11, 5);
		  
		  
		  HBox pButton = new HBox(4);
		  pButton.getChildren().addAll(btAdd,btSearchSSN,btUpdateSSN,btClean);
		  pButton.setAlignment(Pos.CENTER);
		  
	
		 
		  HBox pCombox = new HBox(lbCET,combo_box);
		  pCombox.setAlignment(Pos.CENTER);
		  pCombox.setSpacing(10);
		  pCombox.setPrefHeight(100);
		  String P;
		  String SE = "Salaried Employee" ;
		  String HE = "Hourly Employee"   ;
		  String CE = "Commission Employee" ;
		  String BPCE = "Base Plus Commission Employee";
		  BorderPane borderPane = new BorderPane();
		  borderPane.setCenter(p1);
		  borderPane.setBottom(pButton);
		  borderPane.setTop(pCombox);
		  Scene scene = new Scene(borderPane,750,350);
		  primaryStage.setScene(scene);
		  primaryStage.show();
		  combo_box.setValue("Select a Type");
		  tfSSN.setText("0");
		  tfSSN.setDisable(true);
		  
		  btClean.setOnAction(q->{
			  tfFN.setText("");
			  tfLN.setText("");
			  tfSEARCH.setText("");
			  tfGS.setText("");
			  tfBS.setText("");
			  tfWS.setText("");
			  tfW.setText("");
			  tfH.setText("");
			  tfCR.setText("");
			  lbSALARY.setText("SALARY");	
		
		  });
		  
		  btSearchSSN.setOnAction(event->{
			  int secilen = Integer.parseInt(tfSEARCH.getText().toString());
			  System.out.println(abArray[secilen].getFirstName());
			  System.out.println(abArray[secilen].getClass().toString());
			  if(abArray[secilen].getClass().toString().equals("class application.HourlyEmployee")) {
				  HourlyEmployee temp = (HourlyEmployee)abArray[secilen];
				  abArray[secilen]=temp;
				  tfFN.setText(temp.getFirstName().toString());
				  tfLN.setText(temp.getLastName().toString());
				  tfW.setText(String.valueOf(temp.getWage()));
				  tfH.setText(String.valueOf(temp.getHours()));
				  tfGS.setText("");
				  tfBS.setText("");
				  tfWS.setText("");
				  tfCR.setText("");
				  lbSALARY.setText("SALARY : "+Double.toString(abArray[secilen].getPaymentAmount()));
				  tfGS.setDisable(true);
				  tfCR.setDisable(true);
			  	  tfBS.setDisable(true);
			  	  tfWS.setDisable(true);
			  	  tfW.setDisable(false);
			  	  tfH.setDisable(false); 
			  	btUpdateSSN.setOnAction(t->{
					 temp.setFirstName(tfFN.getText().toString());
					 temp.setLastName(tfLN.getText().toString());
					 temp.setHours(Double.parseDouble(tfH.getText().toString()));
					 temp.setWage(Double.parseDouble(tfW.getText().toString()));
					 abArray[secilen] = temp;
					 System.out.println(abArray[secilen].toString());
				  });
			  	  combo_box.setValue("Hourly Employee");
			  }else if(abArray[secilen].getClass().toString().equals("class application.CommissionEmployee")) {
				  CommissionEmployee temp = (CommissionEmployee)abArray[secilen];
				  tfFN.setText(temp.getFirstName());
				  tfLN.setText(temp.getLastName());
				  tfCR.setText(String.valueOf(temp.getCommissionRate()));
				  tfGS.setText(String.valueOf(temp.getGrossSales()));
				  tfBS.setText("");
				  tfWS.setText("");
				  tfW.setText("");
				  tfH.setText("");
				  lbSALARY.setText("SALARY : "+Double.toString(abArray[secilen].getPaymentAmount()));
				  tfGS.setDisable(false);
				  tfCR.setDisable(false);
				  tfBS.setDisable(true);
				  tfWS.setDisable(true);
				  tfW.setDisable(true);
				  tfH.setDisable(true);
				  btUpdateSSN.setOnAction(tt->{
					 temp.setFirstName(tfFN.getText().toString());
					 temp.setLastName(tfLN.getText().toString());
					 temp.setGrossSales(Double.parseDouble(tfGS.getText().toString()));
					 temp.setCommissionRate(Double.parseDouble(tfCR.getText().toString()));
					 abArray[secilen] = temp;
					 System.out.println(abArray[secilen].toString());
				  });
				  combo_box.setValue("Commission Employee");
			  }else if(abArray[secilen].getClass().toString().equals("class application.BasePlusCommissionEmployee")) {
				  BasePlusCommissionEmployee temp = (BasePlusCommissionEmployee)abArray[secilen];
				  tfFN.setText(temp.getFirstName());
				  tfLN.setText(temp.getLastName());
				  tfCR.setText(String.valueOf(temp.getCommissionRate()));
				  tfGS.setText(String.valueOf(temp.getGrossSales()));
				  tfBS.setText(String.valueOf(temp.getBaseSalary()));
				  tfWS.setText("");
				  tfW.setText("");
				  tfH.setText("");
				  lbSALARY.setText("SALARY : "+Double.toString(abArray[secilen].getPaymentAmount()));
				  tfGS.setDisable	(false);
	  			  tfCR.setDisable	(false);
	  			  tfBS.setDisable	(false);
	  			  tfWS.setDisable	(true);
	  			  tfW.setDisable	(true);
	  			  tfH.setDisable	(true);
	  			  btUpdateSSN.setOnAction(pp->{
	  				 temp.setBaseSalary(Double.parseDouble(tfBS.getText().toString()));
	  				 temp.setCommissionRate(Double.parseDouble(tfCR.getText().toString()));
	  				 temp.setFirstName(tfFN.getText().toString());
	  				 temp.setGrossSales(Double.parseDouble(tfGS.getText().toString()));
	  				 temp.setLastName(tfLN.getText().toString());
	  				 abArray[secilen] = temp;
	  				 System.out.println(abArray[secilen].toString());
	  			  });
	  			combo_box.setValue("Base Plus Commission Employee");
			  }else if(abArray[secilen].getClass().toString().equals("class application.SalariedEmployee")) {
				  SalariedEmployee temp = (SalariedEmployee)abArray[secilen];
				  tfFN.setText(temp.getFirstName());
				  tfLN.setText(temp.getLastName());
				  tfWS.setText(String.valueOf(temp.getWeeklySalary()));
				  tfGS.setText("");
				  tfBS.setText("");
				  tfW.setText("");
				  tfH.setText("");
				  tfCR.setText("");
				  lbSALARY.setText("SALARY : "+Double.toString(abArray[secilen].getPaymentAmount()));
				  tfWS.setDisable(false);
				  tfH.setDisable(true);
				  tfGS.setDisable(true);
				  tfCR.setDisable(true);
				  tfBS.setDisable(true);
				  tfW.setDisable(true);
				  btUpdateSSN.setOnAction(yy->{
					 
					 temp.setFirstName(tfFN.getText().toString());
					 temp.setLastName(tfLN.getText().toString());
					 temp.setWeeklySalary(Integer.parseInt(tfWS.getText().toString()));
					 abArray[secilen] = temp;
					 System.out.println(abArray[secilen].toString());
					
				  });
				  combo_box.setValue("Salaried Employee");
			  }
			  
			  
		  });
		  
		  
		  
		  combo_box.setOnAction(k->{
			  if(combo_box.getValue().toString() == "None") {
					//enable
					  tfGS.setDisable(false);
					  tfCR.setDisable(false);
					  tfBS.setDisable(false);
					  tfWS.setDisable(false);
					  tfW.setDisable(false);
					  tfH.setDisable(false);
				  }
			  
			  if(combo_box.getValue().toString() == "Salaried Employee") {
				  //enable
				  tfWS.setDisable(false);
				  tfH.setDisable(true);
				  tfGS.setDisable(true);
				  tfCR.setDisable(true);
				  tfBS.setDisable(true);
				  tfW.setDisable(true);
				  
				 
					  btAdd.setOnAction(p->{
						  try {
							writeAddressToFile(raf.length());
							 System.out.println("Current file length is " + raf.length());
						} catch (IOException e) {
							e.printStackTrace();
						}
							String  numberSSN = String.valueOf(i);
							 abArray[i] = new SalariedEmployee(tfFN.getText(),tfLN.getText(),numberSSN,Integer.parseInt(tfWS.getText().toString()));
							 lbSALARY.setText("SALARY : "+Double.toString(abArray[i].getPaymentAmount()));
							 i++;
								numberSSN = String.valueOf(i);
								tfSSN.setText(numberSSN);
								System.out.println(abArray[i-1].toString());
								//lbSALARY.setText("Salary = "+Double.toString(abArray[i].getPaymentAmount()));
							
							 
						  });
				  
			  }
			  
			  if(combo_box.getValue().toString() == "Commission Employee") {
					//enable
					  tfGS.setDisable(false);
					  tfCR.setDisable(false);
					  tfBS.setDisable(true);
					  tfWS.setDisable(true);
					  tfW.setDisable(true);
					  tfH.setDisable(true);
					  btAdd.setOnAction(l->{
						  try {
								writeAddressToFile(raf.length());
								 System.out.println("Current file length is " + raf.length());
							} catch (IOException e) {
								e.printStackTrace();
							}
						  String numberSSN = String.valueOf(i);
						 
						  abArray[i] = new CommissionEmployee(tfFN.getText().toString(),tfLN.getText().toString(),numberSSN,Double.parseDouble(tfGS.getText().toString()),Double.parseDouble(tfCR.getText().toString()));
						  lbSALARY.setText("SALARY : "+Double.toString(abArray[i].getPaymentAmount()));
						  System.out.println("calisti");
							i++;
							numberSSN = String.valueOf(i);
							tfSSN.setText(numberSSN);
							System.out.println(abArray[i-1].toString());
					  });
				  }
			  
			  
			  if(combo_box.getValue().toString() == "Hourly Employee") {
				  		tfGS.setDisable(true);
				  		tfCR.setDisable(true);
				  		tfBS.setDisable(true);
				  		tfWS.setDisable(true);
				  		tfW.setDisable(false);
				  		tfH.setDisable(false); 
				btAdd.setOnAction(m->{		
					 try {
							writeAddressToFile(raf.length());
							 System.out.println("Current file length is " + raf.length());
						} catch (IOException e) {
							e.printStackTrace();
						}
					String numberSSN = String.valueOf(i);
					abArray[i] = new HourlyEmployee(tfFN.getText().toString(),tfLN.getText().toString(),numberSSN,Double.parseDouble(tfW.getText().toString()),Double.parseDouble(tfH.getText().toString()));
					lbSALARY.setText("SALARY : "+Double.toString(abArray[i].getPaymentAmount()));
					System.out.println(abArray[i].toString());
					i++;
					numberSSN = String.valueOf(i);
					tfSSN.setText(numberSSN);
				});
				 
			  }
			  if(combo_box.getValue().toString() == "Base Plus Commission Employee") {
							tfGS.setDisable	(false);
			  				tfCR.setDisable	(false);
			  				tfBS.setDisable	(false);
			  				tfWS.setDisable	(true);
			  				tfW.setDisable	(true);
			  				tfH.setDisable	(true);
			  		btAdd.setOnAction(f->{		
			  			 try {
								writeAddressToFile(raf.length());
								 System.out.println("Current file length is " + raf.length());
							} catch (IOException e) {
								e.printStackTrace();
							}
						String numberSSN = String.valueOf(i);
						abArray[i] = new BasePlusCommissionEmployee(tfFN.getText().toString(),tfLN.getText().toString(),numberSSN,Double.parseDouble(tfGS.getText().toString()),Double.parseDouble(tfCR.getText().toString()),Double.parseDouble(tfBS.getText().toString()));
						lbSALARY.setText("SALARY : "+Double.toString(abArray[i].getPaymentAmount()));
						System.out.println(abArray[i].toString());
						i++;
						numberSSN = String.valueOf(i);
						tfSSN.setText(numberSSN);
						System.out.println(abArray[i-1].toString());
					});
			  }
		  });
	  }
	  		


	  public void writeAddressToFile(long position) {
			try {
				raf.seek(position);
				FileOperations.writeFixedLengthString(combo_box.getValue().toString(), CLASSNAME_SIZE, raf) ;
				FileOperations.writeFixedLengthString(tfFN.getText().toString(), FIRSTNAME_SIZE, raf)		;	
				FileOperations.writeFixedLengthString(tfLN.getText().toString(), LASTNAME_SIZE, raf) 		;
				FileOperations.writeFixedLengthString(tfSSN.getText().toString(), SSN_SIZE, raf)     		;
				FileOperations.writeFixedLengthString(tfGS.getText().toString(), GROSSSALES_SIZE, raf)		;
				FileOperations.writeFixedLengthString(tfCR.getText().toString(), COMMISSIONRATE_SIZE, raf)	;
				FileOperations.writeFixedLengthString(tfBS.getText().toString(), BASESALARY_SIZE, raf)		;
				FileOperations.writeFixedLengthString(tfWS.getText().toString(), WEEKLYSALARY_SIZE, raf)	;
				FileOperations.writeFixedLengthString(tfW.getText().toString(), WAGE_SIZE, raf)				;
				FileOperations.writeFixedLengthString(tfH.getText().toString(), HOURS_SIZE, raf)			;
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	  
	  public void readFileFillArray(Employee[]secilen,long position) throws IOException {
		  raf.seek(position);
		  String CN = FileOperations.readFixedLengthString(CLASSNAME_SIZE, raf);
		  String FN = FileOperations.readFixedLengthString(FIRSTNAME_SIZE, raf).trim();
		  String LN = FileOperations.readFixedLengthString(LASTNAME_SIZE, raf).trim();
		  String SSN =FileOperations.readFixedLengthString(SSN_SIZE,raf).trim();
		  int intSSN =Integer.parseInt(SSN);
		  String GS = FileOperations.readFixedLengthString(GROSSSALES_SIZE,raf).trim();
		  double doubleGS = Double.parseDouble(GS);
		  String CR = FileOperations.readFixedLengthString(COMMISSIONRATE_SIZE,raf);
		  double doubleCR = Double.parseDouble(CR);
		  String BS = FileOperations.readFixedLengthString(BASESALARY_SIZE,raf).trim();
		  double doubleBS = Double.parseDouble(BS);
		  String WS = FileOperations.readFixedLengthString(WEEKLYSALARY_SIZE,raf).trim();
		  int intWS = Integer.parseInt(WS);
		  String W = FileOperations.readFixedLengthString(WAGE_SIZE,raf).trim();
		  Double doubleW = Double.parseDouble(W);
		  String H = FileOperations.readFixedLengthString(HOURS_SIZE,raf).trim();
		  double doubleH = Double.parseDouble(H);	  
		  
		  if(CN.equals("Salaried Employee")) {
			  Employee temp = new SalariedEmployee(FN,LN,SSN,intWS);
			  secilen[intSSN] = temp;
		  }else if (CN.equals("Hourly Employee")) {
			  Employee temp = new HourlyEmployee(FN,LN,SSN,doubleW,doubleH);
			  secilen[intSSN] = temp;
		  }else if(CN.equals("Commission Employee")) {
			  Employee temp = new CommissionEmployee(FN,LN,SSN,doubleGS,doubleH);
			  secilen[intSSN] = temp ;
		  }else if(CN.equals("Base Plus Commission Employee")) {
			  Employee temp = new BasePlusCommissionEmployee(FN,LN,SSN,doubleGS,doubleCR,doubleBS);
			  secilen[intSSN] = temp;
		  }
	  }
	  
	  public static void main(String[] args) { 
		  
	    launch(args);
	  }
	}