package com.griechel.restservice.persistance;

import com.griechel.restservice.dagger.modules.ApplicationModule;
import com.griechel.restservice.types.Foo;
import com.griechel.restservice.types.ImmutableFoo;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.*;
import java.util.Optional;

public class DatabaseController {

    // DB fields
    private static final String ID = "id";
    private static final String FOO = "foo";

    private static final String GET_FOO = "SELECT * FROM test WHERE id = ?";
    private static final String INSERT_FOO =
            "INSERT INTO test(" + String.join(",", ID, FOO) + ") VALUES(?,?)";
    private final String dbUrl;

    @Inject
    public DatabaseController(@Named(ApplicationModule.DB_URL) String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void storeRecord(Foo record) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_FOO)) {

            pstmt.setString(1, record.getId());
            pstmt.setString(2, record.getBar());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Could not store quote record", e);
        }
    }

    public Optional<Foo> getRecord(String id) {
        try (Connection conn = getConnection()) {
            PreparedStatement statement = conn.prepareStatement(GET_FOO);
            statement.setString(1, id);

            ResultSet results = statement.executeQuery();
            return Optional.ofNullable(results).map(this::fromSqlRecord);
        } catch (SQLException e) {
            throw new RuntimeException("Could not query for record by id", e);
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            throw new RuntimeException("Could not connect to sqlite", e);
        }
    }

    private Foo fromSqlRecord(ResultSet resultsSet) {
        try {
            return ImmutableFoo.builder().id(resultsSet.getString(ID)).bar(resultsSet.getString(FOO)).build();
        } catch (SQLException e) {
            throw new RuntimeException("Could not deserialize SQL record to object", e);
        }
    }
}
