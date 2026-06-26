package com.yms.persistence;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JsonStorage {
    //dir onde ficara salvo os jsons
    private static final String DATA_DIR = "data/";

    //Gson com suporte a LocalDateTime
    private static final Gson gson = criarGson();

    //criacao e config do gson (ensinar a entender LocalDateTime)
    private static Gson criarGson(){
        return new GsonBuilder()
                //salva o json formatado e identado
                .setPrettyPrinting()
                // registra o adaptador para LocalDateTime
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }

    //adaptador que ensina Gson o LocalDateTime <-> String
    private static class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime>{
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        //LocalDateTimer -> Json (2026-06-26T12:30:30)
        @Override
        public JsonElement serialize(LocalDateTime src, Type type, JsonSerializationContext context){
            return new JsonPrimitive(src.format(FORMATTER));
        }

        @Override
        //Json -> LocalDateTime
        public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context){
            return LocalDateTime.parse(json.getAsString(), FORMATTER);
        }
    }

    //Salva uma lista de objetos em um arquivo Json
    public static <T> void salvar(List<T> lista, String nomeArquivo){
        //garante que a pasta data/ existe, se nao, criar
        File dir = new File(DATA_DIR);
        if(!dir.exists()){
            dir.mkdirs();
        }

        //escreve o Json no arquivo
        //try-with-resources garante que o arquivo feche automaticamente
        try(Writer writer = new FileWriter(DATA_DIR + nomeArquivo)){
            gson.toJson(lista, writer);
        }catch(IOException e){
            System.err.println("Erro ao salvar arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    //Carrega uma lista de objetos a partir de Json
    public static <T> List<T> carregar(String nomeArquivo, Class<T> classe){
        File arquivo = new File(DATA_DIR + nomeArquivo);

        //se o arquivo ainda nao existe, retorna lista vazia (geralmente primeira execucao)
        if(!arquivo.exists()){
            return new ArrayList<>();
        }

        try(Reader reader = new FileReader(arquivo)){
            //Typetoken é necessario para Gson entender list<T> (T = caminhao -> List<Caminhao>)
            Type tipoLista = TypeToken.getParameterized(List.class, classe).getType();
            List<T> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        }catch (IOException e){
            System.err.println("Erro ao carregar arquivo " + nomeArquivo + " " + e.getMessage());
            return new ArrayList<>();
        }
    }

}


