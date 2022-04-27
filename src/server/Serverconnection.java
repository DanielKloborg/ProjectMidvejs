package server;

import java.sql.*;
import java.util.ArrayList;

public class Serverconnection {
	private static Connection connection;

	public static void main(String[] args) {
		loadJdbcDriver();
		openConnection("HandboldDB");
		
		//Kommandorer
		insertNewTeam("Herning"); //Indsætter nyt hold (holdnavn)
		viewAllTeams(); //Viser alle hold
		//updateTeam("Herning",1,2,3,4); //Opdatere hold ved navnet (Holdnavn,vind,tab,uafgjorte,point)
		//insertNewKR(1, "Mål", "Herning", 58); //Laver ny rapport om kampen (kampid, haendelse, holdnavn, tidspunkt)
		//viewAllKR(); // Viser alle kamprapporter
		//viewKR(1); // Viser alt fra kamp nummer (Kampid)
		//viewOnlyTeams(); //Viser kun teamnavne i string array for liste visning
	}
  
  private static boolean loadJdbcDriver() {
    try {
      System.out.println("Loading JDBC driver...");
      
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      
      System.out.println("JDBC driver loaded");
      
      return true;
    }
    catch (ClassNotFoundException e) {
      System.out.println("Could not load JDBC driver!");
      return false;
    }
  }

  private static boolean openConnection(String databaseName) {
    String connectionString =
        "jdbc:sqlserver://localhost:1433;" +
        "instanceName=SQLEXPRESS;" +
        "databaseName=" + databaseName + ";" +
        "integratedSecurity=true;";

    connection = null;
    
    try {
      System.out.println("Connecting to database...");
      
      connection = DriverManager.getConnection(connectionString);
      
      System.out.println("Connected to database");
      
      return true;
    }
    catch (SQLException e) {
      System.out.println("Could not connect to database!");
      System.out.println(e.getMessage());
      
      return false;
    }
  }
  
  static void viewAllTeams() {
    try {
      String sql = "SELECT * FROM holdnavne";

      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(sql);

      	while (resultSet.next()) {
      		String holdNavnHolder = resultSet.getString("navn");
      		HoldObject hold = new HoldObject(resultSet.getString("navn"), resultSet.getInt("vind"), resultSet.getInt("tab"), resultSet.getInt("uafgjort"), resultSet.getInt("point"));
      		AddToArray arrayAdder = new AddToArray(resultSet.getString("navn"));
      		System.out.println( 
      				//"Holdnavn: " + hold.getHoldNavn() + ", Vind: " + hold.getVind() + ", Uafgjort: " + hold.getUafgjort() + ", Tab: " + hold.getTab()
      				arrayAdder.getHoldAL()
      				);
      	}
    }
    catch (SQLException e) {
    	e.printStackTrace();
    }
  }
  
  static void insertNewTeam(String navn) {
	  try {
		  Statement statement = connection.createStatement();
		  
		  String SQLString = "VALUES ('"+ navn +"',0,0,0,0)";
		  
		  statement.executeUpdate("INSERT INTO holdnavne " + SQLString);
	  }
	  catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  

  static void updateTeam(String navn, Integer vind, Integer tab, Integer uafgjort, Integer point) {
	  try {
		  Statement statement = connection.createStatement();
		  
		  String SQLString = "SET vind = " + vind + ", tab = " + tab + ", uafgjort = " + uafgjort + ", point = " + point + ". WHERE navn = '" + navn + "'";
		  
		  statement.executeUpdate("UPDATE holdnavne " + SQLString);
	  }
	  catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  
  static void viewOnlyTeams() {
	  try {
	  String sql = "SELECT * FROM holdnavne";
	  
	  ArrayList<String> holdAL = new ArrayList<String>();
	  
      Statement statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next()) {
      	String holdnavn = resultSet.getString("navn");
      	holdAL.add(holdnavn);
      }
      
      System.out.println("Holdnavne:" + holdAL);
      
	  }
	  catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  
  static void insertNewKR(Integer kampid, String haendelse, String holdnavnKR, Integer tidspunktKR) {
	  try {
		  Statement statement = connection.createStatement();
		  
		  String SQLString = "VALUES (" + kampid + ",'" + haendelse + "', '" + holdnavnKR + "', " + tidspunktKR +")";
		  
		  statement.executeUpdate("INSERT INTO kamprapport " + SQLString);
	  }
	  catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  
  static void viewAllKR() {
	    try {
	      String sql = "SELECT * FROM kamprapport";
	      
	      ArrayList<Integer> kampidAL = new ArrayList<Integer>();
	      ArrayList<String> haendelseAL = new ArrayList<String>();
	      ArrayList<String> holdnavnAL = new ArrayList<String>();
	      ArrayList<Integer> tidspunktAL = new ArrayList<Integer>();
	      
	      Statement statement = connection.createStatement();

	      ResultSet resultSet = statement.executeQuery(sql);

	      	while (resultSet.next()) {
	      		int kampidKR = resultSet.getInt("kampid");
	      		String haendelseKR = resultSet.getString("haendelse");
	      		String holdnavnKR = resultSet.getString("holdnavn");
	      		int tidspunktKR = resultSet.getInt("tidspunkt");

	      		kampidAL.add(kampidKR);
	      		haendelseAL.add(haendelseKR);
	      		holdnavnAL.add(holdnavnKR);
	      		tidspunktAL.add(tidspunktKR);
	
	      		
	      		System.out.println(
	      				/*kampidKR + ", " + haendelseKR + ", " + holdnavnKR + ", " + tidspunktKR + ", "*/
	      				"KampId: " + kampidAL + ", Hændelse: " + haendelseAL + ", Holdnavn: " + holdnavnAL + ", Tidspunkt: " + tidspunktAL
	      				);
	      	}
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	    }
	  }
  
  static void viewKR(Integer kampnr) {
	    try {
	      String sql = "SELECT * FROM kamprapport WHERE kampid = " + kampnr +"";
	      
	      ArrayList<Integer> kampidAL = new ArrayList<Integer>();
	      ArrayList<String> haendelseAL = new ArrayList<String>();
	      ArrayList<String> holdnavnAL = new ArrayList<String>();
	      ArrayList<Integer> tidspunktAL = new ArrayList<Integer>();
	      
	      Statement statement = connection.createStatement();

	      ResultSet resultSet = statement.executeQuery(sql);

	      while (resultSet.next()) {
	      	int kampidKR = resultSet.getInt("kampid");
	      	String haendelseKR = resultSet.getString("haendelse");
	      	String holdnavnKR = resultSet.getString("holdnavn");
	      	int tidspunktKR = resultSet.getInt("tidspunkt");
	      	
      		kampidAL.add(kampidKR);
      		haendelseAL.add(haendelseKR);
      		holdnavnAL.add(holdnavnKR);
      		tidspunktAL.add(tidspunktKR);

	      	System.out.println(
	      			/*kampidKR + ", " + haendelseKR + ", " + holdnavnKR + ", " + tidspunktKR + ", "*/
      				"KampId: " + kampidAL + ", Hændelse: " + haendelseAL + ", Holdnavn: " + holdnavnAL + ", Tidspunkt: " + tidspunktAL
      				);
	      }
	    }
	    catch (SQLException e) {
	    	e.printStackTrace();
	    }
	  }
}
