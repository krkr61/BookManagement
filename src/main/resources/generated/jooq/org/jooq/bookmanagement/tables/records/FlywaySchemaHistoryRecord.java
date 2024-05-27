/*
 * This file is generated by jOOQ.
 */
package org.jooq.bookmanagement.tables.records;


import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.bookmanagement.tables.FlywaySchemaHistory;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FlywaySchemaHistoryRecord extends UpdatableRecordImpl<FlywaySchemaHistoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.flyway_schema_history.installed_rank</code>.
     */
    public void setInstalledRank(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_rank</code>.
     */
    public Integer getInstalledRank() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.flyway_schema_history.version</code>.
     */
    public void setVersion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.version</code>.
     */
    public String getVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.flyway_schema_history.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.flyway_schema_history.type</code>.
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.type</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.flyway_schema_history.script</code>.
     */
    public void setScript(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.script</code>.
     */
    public String getScript() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.flyway_schema_history.checksum</code>.
     */
    public void setChecksum(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.checksum</code>.
     */
    public Integer getChecksum() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.flyway_schema_history.installed_by</code>.
     */
    public void setInstalledBy(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_by</code>.
     */
    public String getInstalledBy() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.flyway_schema_history.installed_on</code>.
     */
    public void setInstalledOn(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_on</code>.
     */
    public LocalDateTime getInstalledOn() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.flyway_schema_history.execution_time</code>.
     */
    public void setExecutionTime(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.execution_time</code>.
     */
    public Integer getExecutionTime() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.flyway_schema_history.success</code>.
     */
    public void setSuccess(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.flyway_schema_history.success</code>.
     */
    public Boolean getSuccess() {
        return (Boolean) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord() {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);
    }

    /**
     * Create a detached, initialised FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord(Integer installedRank, String version, String description, String type, String script, Integer checksum, String installedBy, LocalDateTime installedOn, Integer executionTime, Boolean success) {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);

        setInstalledRank(installedRank);
        setVersion(version);
        setDescription(description);
        setType(type);
        setScript(script);
        setChecksum(checksum);
        setInstalledBy(installedBy);
        setInstalledOn(installedOn);
        setExecutionTime(executionTime);
        setSuccess(success);
        resetChangedOnNotNull();
    }
}
