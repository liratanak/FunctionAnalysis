package main;

import gui.FunctionFrame;

import javax.swing.SwingUtilities;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    new FunctionFrame("Function Analysis") ;
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {
				new FunctionFrame("Function Analysis") ;
			}
		}) ;
		
	}

}
