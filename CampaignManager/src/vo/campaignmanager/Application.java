package vo.campaignmanager;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import vo.campaignmanager.windows.CampaignManager;

public class Application {

	/**
	 * @param args
	 */

	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				CampaignManager fenetre = new CampaignManager();
			    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    fenetre.setVisible(true);
			}	
		});
	    

		
		
	    
	}

}
