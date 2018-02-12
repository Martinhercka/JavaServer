package sk.akademiasovy.world.resources;

import sk.akademiasovy.world.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/world")
public class World
{
    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountries() throws SQLException {
        MySQL mysql=new MySQL();
        List<String> list = mysql.getCountries();

        boolean b = false;

        String result = "{\"name\":[";
        for (String temp:list)
        {
            if(b==true)
            {
                result+=',';
            }
            else
                b=true;
            result+="\""+temp+"\"";

        }
        result+="]}";
        return result;

    }
}
