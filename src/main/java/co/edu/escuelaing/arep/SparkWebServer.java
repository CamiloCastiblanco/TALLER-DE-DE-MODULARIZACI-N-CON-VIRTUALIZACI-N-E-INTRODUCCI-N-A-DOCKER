package co.edu.escuelaing.arep;
import static co.edu.escuelaing.arep.HttpServer.*;
import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        HttpServer server = new HttpServer();
        port(getPort());
        get("hello", (req,res) -> HttpServer.getPage());
        get("sin", (req,res) -> sin(req));
        get("cos", (req,res) -> cos(req));
        get("palindrome", (req,res) -> palindrome(req));
        get("dimensions", (req,res) -> dimensions(req));
    }
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }


}
