package Start;

import javax.swing.UIManager;

import com.zm.view.Login;
/**
 * ����ϵͳ�����
 * @author ...
 *
 */
public class Main {
	public static void main(String[] args) {
		// ����ƻ������
		try{
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					UIManager.put("RootPane.setupButtonVisible", false);// �������ð�ť
				} catch (Exception e) {
					e.printStackTrace();
				}
		//�ӵ�½��ʼ
        new Login();
	}
}
