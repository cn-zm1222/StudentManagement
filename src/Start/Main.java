package Start;

import javax.swing.UIManager;

import com.zm.view.Login;
/**
 * 程序系统主入口
 * @author ...
 *
 */
public class Main {
	public static void main(String[] args) {
		// 启用苹果主题
		try{
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					UIManager.put("RootPane.setupButtonVisible", false);// 隐藏设置按钮
				} catch (Exception e) {
					e.printStackTrace();
				}
		//从登陆开始
        new Login();
	}
}
