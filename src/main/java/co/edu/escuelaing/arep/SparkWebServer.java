package co.edu.escuelaing.arep;

import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
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
    private static Double sin(Request request){
        Double value = Double.valueOf(request.queryParams("value"));
        return Math.sin(value);
    }
    private static Double cos(Request request){
        Double value = Double.valueOf(request.queryParams("value"));
        return Math.cos(value);
    }
    private static boolean palindrome(Request request){
        String value = request.queryParams("value");
        StringBuilder input1 = new StringBuilder();
        input1.append(value);
        input1.reverse();
        return value.equals(input1);
    }
    private static float dimensions(Request request){
        float x = Float.parseFloat(request.queryParams("x"));
        float y = Float.parseFloat(request.queryParams("y"));
        float z = (float) Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        return z;
    }



}
