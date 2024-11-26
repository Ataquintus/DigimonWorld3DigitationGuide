package dw3dg.digimonworld3digitationguide.repos;

import dw3dg.digimonworld3digitationguide.model.Digitation;
import dw3dg.digimonworld3digitationguide.model.Partner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSteuerung {
    private Connection connection;

    public DBSteuerung(String dbpath) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbpath);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Partner> getPartner() {
        List<Partner> partnerList = new ArrayList<>();
        String query = "SELECT * FROM Partner";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Partner partner = new Partner(
                        rs.getString("Partnername"),
                        rs.getString("Quest")
                );
                partnerList.add(partner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partnerList;
    }

    public List<Digitation> getAllDigitation() {
        List<Digitation> digitationList = new ArrayList<>();
        String query = "SELECT * FROM (hier join einfügen)";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Digitation digitation = new Digitation(
                        rs.getString("Partnername"),
                        rs.getString("Digitationsname"),
                        rs.getString("Digitationsstufe"),
                        rs.getString("Vordigitation1"),
                        rs.getString("Level1"),
                        rs.getString("Vordigitation2"),
                        rs.getString("Level2"),
                        rs.getString("Wertebedingung")
                );
                digitationList.add(digitation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return digitationList;
    }

    public List<Digitation> getDigitation(String partnername, String digitationsname, String digitationsstufe, String vordigitation1, String vordigitation2) {
        List<Digitation> digitationList = new ArrayList<>();
        String query = "SELECT * FROM (hier join einfügen) WHERE Partnername = ? OR Digitationsname = ? OR Digitationsstufe = ? OR Vordigitation1 = ? OR Vordigitation2 = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, partnername);
            pstmt.setString(2, digitationsname);
            pstmt.setString(3, digitationsstufe);
            pstmt.setString(4, vordigitation1);
            pstmt.setString(5, vordigitation2);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Digitation digitation = new Digitation(
                        rs.getString("Partnername"),
                        rs.getString("Digitationsname"),
                        rs.getString("Digitationsstufe"),
                        rs.getString("Vordigitation1"),
                        rs.getString("Level1"),
                        rs.getString("Vordigitation2"),
                        rs.getString("Level2"),
                        rs.getString("Wertebedingung")
                );
                digitationList.add(digitation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return digitationList;
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
