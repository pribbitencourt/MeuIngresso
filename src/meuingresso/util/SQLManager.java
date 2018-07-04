/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuingresso.util;

/**
 *
 * @author priscillabittencourt
 */
public class SQLManager {
    public String generateQueryCreateTable(String tableName, String tableBody) {
            return String.format("CREATE TABLE IF NOT EXISTS %s %s", tableName, tableBody);
    }
    public String generateQueryDelete(String tableName, String columnIdName) {
            return String.format("DELETE FROM %s WHERE %s = ?", tableName, columnIdName);
    }
    public String generateQuerySelectAll(String tableName) {
            return String.format("SELECT * FROM %s", tableName);
    }
    public String generateQuerySelectBy(String tableName, String columnName) {
            return String.format("SELECT * FROM %s WHERE %s = ?", tableName, columnName);
    }
    public String generateQuerySelectLastId(String tableName, String columnIdName) {
            return String.format("SELECT MAX(%s) AS %s FROM %s", columnIdName, "lastId", tableName);
    } 
}
