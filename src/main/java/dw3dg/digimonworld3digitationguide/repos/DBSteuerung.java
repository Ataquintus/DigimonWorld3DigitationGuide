package dw3dg.digimonworld3digitationguide.repos;

import dw3dg.digimonworld3digitationguide.model.Digitationsbedingung;
import dw3dg.digimonworld3digitationguide.model.Guide;
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

    public List<Digitationsbedingung> getAllDigitationsbedingung() {
        List<Digitationsbedingung> digitationsbedingungList = new ArrayList<>();
        String query = "SELECT Partner.Partnername, " +
                "Digitation.Digitationsname, " +
                "Digitationsstufe.Stufenname, " +
                "Vordigitation1.Vordigitationsname AS Vordigitation1, " +
                "Levelbedingung1.Level AS Level1, " +
                "Vordigitation2.Vordigitationsname AS Vordigitation2, " +
                "Levelbedingung2.Level AS Level2, " +
                "Digitationsbedingung.Wertebedingung " +
                "FROM Digitationsbedingung " +
                "JOIN Partner ON Digitationsbedingung.Partner_ID = Partner.Partner_ID " +
                "JOIN Digitation ON Digitationsbedingung.Digitation_ID = Digitation.Digitation_ID " +
                "JOIN Digitationsstufe ON Digitation.Digitationsstufe_ID = Digitationsstufe.Digitationsstufe_ID " +
                "JOIN Vordigitation AS Vordigitation1 ON Digitationsbedingung.Vordigitation1_ID = Vordigitation1.Vordigitation_ID " +
                "JOIN Levelbedingung AS Levelbedingung1 ON Digitationsbedingung.Levelbedingung1_ID = Levelbedingung1.Levelbedingung_ID " +
                "JOIN Vordigitation AS Vordigitation2 ON Digitationsbedingung.Vordigitation2_ID = Vordigitation2.Vordigitation_ID " +
                "JOIN Levelbedingung AS Levelbedingung2 ON Digitationsbedingung.Levelbedingung2_ID = Levelbedingung2.Levelbedingung_ID";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Digitationsbedingung digitationsbedingung = new Digitationsbedingung(
                        rs.getString("Partnername"),
                        rs.getString("Digitationsname"),
                        rs.getString("Stufenname"),
                        rs.getString("Vordigitation1"),
                        rs.getString("Level1"),
                        rs.getString("Vordigitation2"),
                        rs.getString("Level2"),
                        rs.getString("Wertebedingung")
                );
                digitationsbedingungList.add(digitationsbedingung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return digitationsbedingungList;
    }

    public List<Digitationsbedingung> getDigitationsbedingung(String partnername, String digitationsname, String digitationsstufe, String vordigitation1, String vordigitation2) {
        List<Digitationsbedingung> digitationsbedingungList = new ArrayList<>();
        String query = "SELECT Partner.Partnername, " +
                "Digitation.Digitationsname, " +
                "Digitationsstufe.Stufenname, " +
                "Vordigitation1.Vordigitationsname AS Vordigitation1, " +
                "Levelbedingung1.Level AS Level1, " +
                "Vordigitation2.Vordigitationsname AS Vordigitation2, " +
                "Levelbedingung2.Level AS Level2, " +
                "Digitationsbedingung.Wertebedingung " +
                "FROM Digitationsbedingung " +
                "JOIN Partner ON Digitationsbedingung.Partner_ID = Partner.Partner_ID " +
                "JOIN Digitation ON Digitationsbedingung.Digitation_ID = Digitation.Digitation_ID " +
                "JOIN Digitationsstufe ON Digitation.Digitationsstufe_ID = Digitationsstufe.Digitationsstufe_ID " +
                "JOIN Vordigitation AS Vordigitation1 ON Digitationsbedingung.Vordigitation1_ID = Vordigitation1.Vordigitation_ID " +
                "JOIN Levelbedingung AS Levelbedingung1 ON Digitationsbedingung.Levelbedingung1_ID = Levelbedingung1.Levelbedingung_ID " +
                "JOIN Vordigitation AS Vordigitation2 ON Digitationsbedingung.Vordigitation2_ID = Vordigitation2.Vordigitation_ID " +
                "JOIN Levelbedingung AS Levelbedingung2 ON Digitationsbedingung.Levelbedingung2_ID = Levelbedingung2.Levelbedingung_ID " +
                "WHERE Partnername LIKE ? AND Digitationsname LIKE ? AND Stufenname LIKE ? AND (Vordigitation1 LIKE ? OR Vordigitation2 LIKE ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, partnername);
            if (digitationsname.equals("Keine") || digitationsname.equals("null")) {
                pstmt.setString(2, "%");
            } else {
                pstmt.setString(2, digitationsname);
            }
            if (digitationsstufe.equals("Keine") || digitationsstufe.equals("null")) {
                pstmt.setString(3, "%");
            } else {
                pstmt.setString(3, digitationsstufe);
            }
            if (vordigitation1.equals("Keine") || vordigitation1.equals("null")){
                pstmt.setString(4, "%");
                pstmt.setString(5, "%");
            } else {
                pstmt.setString(4, vordigitation1);
                pstmt.setString(5, vordigitation2);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Digitationsbedingung digitationsbedingung = new Digitationsbedingung(
                        rs.getString("Partnername"),
                        rs.getString("Digitationsname"),
                        rs.getString("Stufenname"),
                        rs.getString("Vordigitation1"),
                        rs.getString("Level1"),
                        rs.getString("Vordigitation2"),
                        rs.getString("Level2"),
                        rs.getString("Wertebedingung")
                );
                digitationsbedingungList.add(digitationsbedingung);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return digitationsbedingungList;
    }

    public List<Partner> getAllPartner() {
        List<Partner> allQuests = new ArrayList<>();
        String query = "SELECT * FROM Partner";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Partner partner = new Partner(
                        rs.getInt("Partner_ID"),
                        rs.getString("Partnername"),
                        rs.getString("Quest")
                );
                allQuests.add(partner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allQuests;
    }

    public Partner getPartner(String partner) {
        String query = "SELECT * FROM Partner WHERE Partnername = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, partner);
            ResultSet rs = pstmt.executeQuery();
            return new Partner(
                    rs.getInt("Partner_ID"),
                    rs.getString("Partnername"),
                    rs.getString("Quest")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Guide getGuide(Integer akt) {
        String query = "SELECT * FROM Guide WHERE GUIDE_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, akt.toString());
            ResultSet rs = pstmt.executeQuery();
            Guide guide = new Guide(
                    rs.getInt("Guide_ID"),
                    rs.getString("Guide")
            );
            return guide;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Guide> getFullGuide() {
        List<Guide> fullGuide = new ArrayList<>();
        String query = "SELECT * FROM Guide";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Guide guide = new Guide(
                        rs.getInt("Guide_ID"),
                        rs.getString("Guide")
                );
                fullGuide.add(guide);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fullGuide;
    }

    public List<String> getAllDigitation() {
        List<String> digitationList = new ArrayList<>();
        String query = "SELECT * FROM Digitation";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                digitationList.add(rs.getString("Digitationsname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return digitationList;
    }

    public List<String> getAllDigitationsstufe() {
        List<String> stufenList = new ArrayList<>();
        String query = "SELECT * FROM Digitationsstufe";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                stufenList.add(rs.getString("Stufenname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stufenList;
    }

    public List<String> getAllVordigitation() {
        List<String> vordigitationList = new ArrayList<>();
        String query = "SELECT * FROM Vordigitation";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                vordigitationList.add(rs.getString("Vordigitationsname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vordigitationList;
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
