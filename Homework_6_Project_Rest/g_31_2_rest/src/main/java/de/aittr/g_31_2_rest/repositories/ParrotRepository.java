package de.aittr.g_31_2_rest.repositories;

import de.aittr.g_31_2_rest.domain.Parrot;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class ParrotRepository implements CrudRepository<Parrot> {
    private final String DB_DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private final String DB_ADDRESS = "jdbc:mysql://localhost:3306/";
    private final String DB_NAME = "31_2_parrots";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "ZaplKira1975!";
    //метод подключается к базе данных и возвращает обект
    private final String ID = "id";
    private final String COLOR = "color";
    private final String WEIGHT = "weight";

    private Connection getConnection() {
        try {
            Class.forName(DB_DRIVER_PATH);

            String dbUrl = String.format("%s%s?user=%s&password=%s",
                    DB_ADDRESS, DB_NAME, DB_USERNAME, DB_PASSWORD);
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Parrot save(Parrot obj) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            String query = String.format(Locale.US, "INSERT INTO parrot (color, weight) VALUES ('%s', %f);",
                    obj.getColor(), obj.getWeight());

            statement.executeUpdate(query);

            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Parrot> getAll() {
        try (Connection connection = getConnection()) {
            String query = "select * from parrot;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Parrot> parrots = new ArrayList<>();
            while (resultSet.next()) {
                //int id=resultSet.getInt(1);   1 вариант передать номер колонки.  лучше id
                int id = resultSet.getInt(ID); // 2  передать название колонки
                String color = resultSet.getNString(COLOR);
                double weight = resultSet.getDouble(WEIGHT);
                Parrot parrot= new Parrot(id,color,weight);
                parrots.add(parrot);
            }
            return parrots;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Parrot getById(int id) {
        try(Connection connection = getConnection()) {
            String query = String.format("select * from parrot where id =%d;",id);
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            Parrot parrot = null;
            while (resultSet.next()){
                String color =resultSet.getNString(COLOR);
                double weight= resultSet.getDouble(WEIGHT);
                parrot = new Parrot(id,color,weight);
            }
            return parrot;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Parrot obj) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            String query = String.format("UPDATE parrot SET color = '%s', weight = %f WHERE id = %d;",
                    obj.getColor(), obj.getWeight(), obj.getId());

            statement.executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            String query = String.format("DELETE FROM parrot WHERE id = %d;", id);

            statement.executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
