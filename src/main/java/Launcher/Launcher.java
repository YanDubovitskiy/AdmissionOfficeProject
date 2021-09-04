package Launcher;

import Dialog.Dialog;
import Logic.Util;

import java.sql.SQLException;

public class Launcher {
    public static void main(String[] args) throws SQLException {
        Util util = new Util();
        util.getConnection();
        Dialog.interaction();
    }
}
