package co.edu.escuelaing.arep;

import spark.Request;

public class HttpServer {
    public static Double sin(Request request){
        Double value = Double.valueOf(request.queryParams("value"));
        return Math.sin(value);
    }
    public static Double cos(Request request){
        Double value = Double.valueOf(request.queryParams("value"));
        return Math.cos(value);
    }
    public static boolean palindrome(Request request){
        String value = request.queryParams("value");
        StringBuilder input1 = new StringBuilder();
        input1.append(value);
        input1.reverse();
        return value.equals(input1);
    }
    public static float dimensions(Request request){
        float x = Float.parseFloat(request.queryParams("x"));
        float y = Float.parseFloat(request.queryParams("y"));
        float z = (float) Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        return z;
    }

    public static String getPage() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <script href=\"/resources/styles.css\"></script>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Función Seno:</h2>\n" +
                "        <form action=\"/sin\">\n" +
                "            <label for=\"name\">Número:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"0\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"Sin()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsgSin\"></div>"+
                "<script> function Sin() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsgSin\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/sin?value=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }" +
                "</script> "+
                "<h2>Función Coseno:</h2>\n" +
                "        <form action=\"/cos\">\n" +
                "            <label for=\"name\">Número:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"0\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"Cos()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsgCos\"></div>"+
                "<script> function Cos() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsgCos\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/cos?value=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }" +
                "</script> "+
                "<h2>Palindromos:</h2>\n" +
                "        <form action=\"/palindrome\">\n" +
                "            <label for=\"name\">Palabra:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"reconocer\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"Palindrome()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsgPalin\"></div>"+
                "<script> function Palindrome() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsgPalin\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/palindrome?value=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }" +
                "</script> "+
                "<h2>Magnitud de un vector:</h2>\n" +
                "        <form action=\"/dimensions\">\n" +
                "            <label for=\"name\">X:</label><br>\n" +
                "            <input type=\"text\" id=\"X\" name=\"name\" value=\"0\"><br><br>\n" +
                "            <label for=\"name\">Y:</label><br>\n" +
                "            <input type=\"text\" id=\"Y\" name=\"name\" value=\"0\"><br><br>\n" +

                "            <input type=\"button\" value=\"Submit\" onclick=\"Dimensions()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsgDimen\"></div>"+
                "<script> function Dimensions() {\n" +
                "                let X = document.getElementById(\"X\").value;\n" +
                "                let Y = document.getElementById(\"Y\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsgDimen\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/dimensions?x=\"+X+\"&y=\"+Y);\n" +
                "                xhttp.send();\n" +
                "            }" +
                "</script> "+
                "</body>\n" +
                "</html>";
        return html;
    }
}
