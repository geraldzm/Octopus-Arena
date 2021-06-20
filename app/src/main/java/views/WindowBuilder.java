package views;

import Controllers.LoginController;
import model.ContextNode;

import java.util.function.Function;

public class WindowBuilder {

    private static void buildWindowAndShow(ContextNode node, Function<ContextNode, AppWindow> function) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                function.apply(node).showWindow();
            }
        });

        //delay
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Login buildLoginWindow(ContextNode node) {
        Login login = new Login(node);
        new LoginController(login);
        return login;
    }

    private static Signin buildSignInWindow(ContextNode node) {
        return new Signin(node);
    }

    private static Home buildHomeWindow(ContextNode node) {
        return new Home(node);
    }

    private static CheckIn buildCheckInWindow(ContextNode node) {
        return new CheckIn(node);
    }

    private static ScoreBoard buildScoreBoardWindow(ContextNode node) {
        return new ScoreBoard(node);
    }

    private static GameWindow buildGameWindow(ContextNode node) {
        return new GameWindow(node);
    }

    public static void buildWindowAndShow(ContextNode node, WindowID id) {

        switch (id) {
            case LOGIN: buildWindowAndShow(node, WindowBuilder::buildLoginWindow); break;
            case SINGIN: buildWindowAndShow(node, WindowBuilder::buildSignInWindow); break;
            case HOME: buildWindowAndShow(node, WindowBuilder::buildHomeWindow); break;
            case CHECK_IN: buildWindowAndShow(node, WindowBuilder::buildCheckInWindow); break;
            case SCORE_BOARD: buildWindowAndShow(node, WindowBuilder::buildScoreBoardWindow); break;
            case GAME: buildWindowAndShow(node, WindowBuilder::buildGameWindow); break;
        }

    }

}
