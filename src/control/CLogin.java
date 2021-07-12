package control;

import java.io.IOException;

import DAO.DAO;
import model.MLogin;
import model.MModel;
import valueObject.VLogin;

public class CLogin {
	
	public String message;
	
	public boolean validate(VLogin vLogin) {
		boolean bLoginSuccess = false;
		
		DAO dataAccessObject = new DAO();
		MModel mModel = dataAccessObject.getAModel("userId", MLogin.class, vLogin.getUserId());
		
		if (mModel != null) {
			MLogin mLogin = (MLogin) mModel;
			if (vLogin.getPassword().contentEquals(mLogin.getPassword())) {
				bLoginSuccess = true;
			} else {
				// password mismatch
			}
		} else {
			// no userId - ȸ�� ���� �ȵ� Ȥ�� ���̵� �� �� �Է�
		}
		return bLoginSuccess;
	}

	public void createAccount(String idText, String passwordText) {
		DAO dataAccessObject = new DAO();
		VLogin vlogin = new VLogin(idText, passwordText);
		try {
			dataAccessObject.createAccount(vlogin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
