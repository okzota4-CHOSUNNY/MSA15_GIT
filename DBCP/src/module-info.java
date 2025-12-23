/**
 * 
 */

module DBCP {
    requires java.sql;
    requires static java.transaction;
    requires org.apache.commons.dbcp2;
    requires org.apache.commons.pool2;
}