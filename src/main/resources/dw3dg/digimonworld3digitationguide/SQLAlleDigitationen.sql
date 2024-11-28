SELECT Partner.Partnername, Digitation.Digitationsname, Digitationsstufe.Stufenname, Vordigitation1.Vordigitationsname AS Vordigitation1, Levelbedingung1.Level AS Level1, Vordigitation2.Vordigitationsname AS Vordigitation2, Levelbedingung2.Level AS Level2, Digitationsbedingung.Wertebedingung 
FROM Digitationsbedingung
JOIN Partner ON Digitationsbedingung.Partner_ID = Partner.Partner_ID
JOIN Digitation ON Digitationsbedingung.Digitation_ID = Digitation.Digitation_ID
JOIN Digitationsstufe ON Digitation.Digitationsstufe_ID = Digitationsstufe.Digitationsstufe_ID
JOIN Vordigitation AS Vordigitation1 ON Digitationsbedingung.Vordigitation1_ID = Vordigitation1.Vordigitation_ID
JOIN Levelbedingung AS Levelbedingung1 ON Digitationsbedingung.Levelbedingung1_ID = Levelbedingung1.Levelbedingung_ID
JOIN Vordigitation AS Vordigitation2 ON Digitationsbedingung.Vordigitation2_ID = Vordigitation2.Vordigitation_ID
JOIN Levelbedingung AS Levelbedingung2 ON Digitationsbedingung.Levelbedungung2_ID = Levelbedingung2.Levelbedingung_ID;