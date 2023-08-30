import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarsDAO {
    private String url;
    private String username;
    private String password;
    public Connection jdbcConnection;
    public CarsDAO() {
        // Default constructor (no arguments)
    }
    public CarsDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    protected void connect() throws SQLException {
        // if (jdbcConnection == null || jdbcConnection.isClosed()) {
        //     try {
        //         Class.forName("com.mysql.jdbc.Driver");
        //     } catch (ClassNotFoundException e) {
        //         throw new SQLException(e);
        //     }
            jdbcConnection = DriverManager.getConnection(url, username, password);
        }
    // }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed())
            jdbcConnection.close();
    }

    public boolean insertCar(Cars c1) throws SQLException {

        String sql = "insert into skoda(name,type,fuel,price,seater) VALUES(?,?,?,?,?)";
        System.out.println(sql);
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        // statement.setInt(0, c1.getId());
        statement.setString(1, c1.getName());
        statement.setString(2, c1.getType());
        statement.setString(3, c1.getFuel());
        statement.setString(4, c1.getPrice());
        statement.setInt(5, c1.getSeater());

        boolean rowsCount = statement.executeUpdate() > 0;
        statement.close();
        disconnect();

        return rowsCount;
    }

    public List<Cars> listAllCars() throws SQLException {
        List<Cars> carList = new ArrayList<>();

        String sql = "select * from skoda";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            String fuel = resultSet.getString("fuel");
            String price = resultSet.getString("price");
            int seater = resultSet.getInt("seater");

            Cars c2 = new Cars(id, name, type, fuel, price, seater);
            carList.add(c2);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return carList;
    }

    public boolean deleteCar(Cars c3) throws SQLException{
        String sql = "DELETE FROM skoda where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, c3.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted; 
    }
    public boolean updateCar(Cars c4) throws SQLException{
        String sql="update skoda set name=?,type=?,fuel=?,price=?,seater=? where id=?";
        System.out.println(sql);
        connect();
// System.out.println(sql);
        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
       
        statement.setString(1, c4.getName());
        statement.setString(2, c4.getType());
        statement.setString(3, c4.getFuel());
        statement.setString(4, c4.getPrice());
        statement.setInt(5, c4.getSeater());
         statement.setInt(6, c4.getId());
        
        boolean rowsUpdated=statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowsUpdated;
    }
    public Cars getCar(int id) throws SQLException {
        Cars c5 = null;
        String sql = "SELECT * FROM skoda WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            String fuel = resultSet.getString("fuel");
            String price = resultSet.getString("price");
            int seater = resultSet.getInt("seater");
            c5 = new Cars(id, name,type,fuel,price,seater);
        }

        resultSet.close();
        statement.close();

        return c5;
    }
}
