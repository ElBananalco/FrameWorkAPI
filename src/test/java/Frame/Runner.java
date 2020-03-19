package Frame;
import java.io.IOException;
import java.util.ArrayList;


import junit.framework.TestCase;

public class Runner extends TestCase{
	
	   public static void main(String args[]) throws IOException {
			leer xlsx = new leer();
			TestMethods run = new TestMethods();
		
			ArrayList<TestData> ListaObjetosTestC = new ArrayList();;
			
			String URL = "https://restool-sample-app.herokuapp.com/api/";
			String  PATH ="employee";
			
			run.classSetup(URL, PATH);
			
			leer TC = new leer();	
			
			//se lee el archivo
	    	javax.swing.JFileChooser jF1= new javax.swing.JFileChooser();
	    	String ruta = "";
	    	try{
	    	if(jF1.showSaveDialog(null)==jF1.APPROVE_OPTION){
	    	ruta = jF1.getSelectedFile().getAbsolutePath();
	    	
	    	
	    	}
	    	}catch (Exception ex){
	    	ex.printStackTrace();
	    	}

	    
	    		ArrayList<String> sheets = new ArrayList();
	    	
	    	
	    		
	   
	    	
	    	
	    	//creamos una lista con los nombres de las hojas que son los TC y los mandamos junto con la ruta
		
			
			
			
	    	//se guardan los datos el excel a un arraylist
			ListaObjetosTestC=TC.obtenerObjetos(ruta);
			
			for(int x=1;x<ListaObjetosTestC.size();x++) {
				
				
				sheets.add(run.testCases(ListaObjetosTestC.get(x)));
				
			}
			System.out.println(sheets.toString());
			//se recorre el array list
			for(int x=1;x<ListaObjetosTestC.size();x++) {
				//System.out.println(ListaObjetosTestC.get(x).toString());
				
				run.executionFile(ListaObjetosTestC.get(x));
				
			}
		
		
		
			
			
			
			
	    }
	
	
}
