package control;

import java.util.Vector;

import DAO.DAO;
import model.MLecture;
import model.MModel;
import valueObject.VLecture;

public class CLecture {
	
	public Vector<VLecture> getData(String filename) {
		DAO dataAccessObject = new DAO();
		Vector<MModel> mModels  = dataAccessObject.getModels(filename, MLecture.class);		
		
		Vector<VLecture> vLectures = new Vector<VLecture>();
		for(MModel mModel : mModels) {
			MLecture mLecture = (MLecture)mModel;
			VLecture vLecture = new VLecture(
					mLecture.getId(),
					mLecture.getName(),			
					mLecture.getProfessor(),
					mLecture.getGrade(),
					mLecture.getTime()
			);	
			vLectures.add(vLecture);
		}	
		return vLectures;
	}
}
