package org.example.EXAMEN_REPASO.Ficheros.API.solEjercicio5.Mi_Manera;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Prueba_api {
    // 17ed595d4f7147c0b95c7fb1cd9d50602595a3db1e839ae1beebe0782d9d1b12da45f178f
    //MD5 Hash 08fd5bb5cb81d1f89e8705f4f6cbaa78
    //SHA1 Hash b213042688435b5e53d01157cb2de8578a326454
    //FINAL= http://gateway.marvel.com/v1/public/characters?apikey=e839ae1beebe0782d9d1b12da45f178f&ts=1&hash=08fd5bb5cb81d1f89e8705f4f6cbaa78

    public static void main(String[] args) throws Exception{
        URL url=new URL("https://jsonplaceholder.typicode.com/users");
        HttpURLConnection cx=(HttpURLConnection) url.openConnection();
        cx.setRequestMethod("GET");

        InputStream strm=cx.getInputStream();
        byte[] arrStream=strm.readAllBytes();

        String cnt_JSON="";

        for(byte tmp: arrStream)
            cnt_JSON=cnt_JSON+(char) tmp;


        JSONArray json=new JSONArray(cnt_JSON);

        for(Object obj: json)
            System.out.println(new JSONObject(((JSONObject)obj).get("company").toString()));
    }





}
