package basepackage;

import java.io.IOException;
import java.util.HashMap;

/**
 * This class will manage the semester objects.
 * @author karmugilan
 */

public class SemManager
{
	private HashMap<String,Semester> semesters;//Stores semester objects mapped to the semester name.
	private String fileName;
	//private int howMany;
	
	public SemManager(String dep) throws IOException
	{
		semesters=new HashMap<String,Semester>();
		this.fileName=dep;
		//this.howMany=howMany;
		createSemObjects();
	}
	
	private void createSemObjects() throws IOException
	{
		CSVParser cv = new CSVParser(fileName+"data.csv");
		HashMap<String,HashMap<String,Float>> semestersInfo =cv.getSemesters();
		for(int k = 1; k<semestersInfo.size(); k++)
		{
			HashMap<String,Float> semInfo=semestersInfo.get("Semester "+ k);
			Semester sem = new Semester(semInfo);//create semester objects.
			semesters.put(sem.getName() , sem);//store the semester objects.
		}
		//System.out.println(semesters);
	}
	
	public float getCGPAForOneSem(int whatSem) 	//this method returns cgpa for the selected semester
	{
		String sem="Semester "+whatSem;
		Semester selectedSem = semesters.get(sem);
		return selectedSem.getCGPA();	//return the cgpa for selected semester.
	}
	

}
