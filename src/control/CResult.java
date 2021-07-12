package control;

import java.util.Vector;

import DAO.DAO;
import model.MLecture;
import model.MModel;
import valueObject.VLecture;

public class CResult {

	public CResult() {

	}

	public void save(String fileName, Vector<VLecture> vLectures) {
		DAO dataAccessObject = new DAO();
		dataAccessObject.saveResult(fileName, vLectures);
	}

	public Vector<VLecture> get(String fileName) {
		DAO dataAccessObject = new DAO();
		Vector<MModel> mModels = dataAccessObject.getModels(fileName, MLecture.class);
		Vector<VLecture> vLectures = new Vector<VLecture>();

		for (MModel mModel : mModels) {
			MLecture mLecture = (MLecture) mModel;
			VLecture vLecture = new VLecture(mLecture.getId(), mLecture.getName(), mLecture.getProfessor(),
					mLecture.getGrade(), mLecture.getTime());
			vLectures.add(vLecture);
		}
		return vLectures;
	}
}
