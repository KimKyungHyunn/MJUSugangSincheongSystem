package control;

import java.util.Vector;

import DAO.DAO;
import model.MDirectory;
import model.MModel;
import valueObject.VDirectory;

public class CDirectory {
	
	public Vector<VDirectory> getData(String filename) {
		DAO dataAccessObject = new DAO();
		Vector<MModel> mModels  = dataAccessObject.getModels(filename, MDirectory.class);		
		
		Vector<VDirectory> vDirectories = new Vector<VDirectory>();
		for(MModel mModel : mModels) {
			MDirectory mDirectory = (MDirectory)mModel;
			VDirectory vDirectory = new VDirectory(
				mDirectory.getName(),
				mDirectory.getFileName()
			);	
			vDirectories.add(vDirectory);
		}	
		return vDirectories;
	}
}
