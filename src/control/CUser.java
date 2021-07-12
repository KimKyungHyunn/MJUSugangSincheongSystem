package control;

import DAO.DAO;
import model.MModel;
import model.MUser;
import valueObject.VUser;

public class CUser {

	public VUser getUser(String userId) {
		VUser vUser = null;
		
		DAO dataAccessObject = new DAO();
		MModel mModel = dataAccessObject.getAModel(userId, MUser.class, userId);
		if (mModel != null) {
			MUser mUser = (MUser)mModel;
			vUser = new VUser(mUser.getUserId(), mUser.getName(), mUser.getAddress());
		}
		return vUser;
	}

	public void createUser(String id, String name, String address) {
		DAO dataAccessObject = new DAO();
		VUser vuser = new VUser(id, name, address);
		dataAccessObject.createUser(vuser);
	}

}
