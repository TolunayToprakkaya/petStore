package com.example.petstore.controllers;

import com.example.petstore.factory.JsonFileLoader;
import com.example.petstore.seedwork.BaseIntegrationTest;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class CategoryControllerIntegrationTest extends BaseIntegrationTest{

    @Getter @Setter private String expectedJsonForFindAll;
    @Getter @Setter private String expectedJsonForFindOne;

    @Getter @Setter private String expectedJsonForDelete;
    @Getter @Setter private String expectedJsonForUpdate;
    @Getter @Setter private String expectedJsonForSave;

    @Test
    public void testFindAll() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = getTestRestTemplate().exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                String.class);
        assertEquals(getExpectedJsonForFindAll(), response.getBody());
    }

    @Test
    @Ignore
    public void testFindOne() throws Exception{
        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories/cee9aa58-4722-11e8-842f-0ed5f89f718b");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = getTestRestTemplate().exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                String.class);

        assertEquals(getExpectedJsonForFindOne(), response.getBody());
    }

    @Test
    public void testDelete(){
        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories/cee9aa58-4722-11e8-842f-0ed5f89f718b");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = getTestRestTemplate().exchange(
                builder.build().encode().toUri(),
                HttpMethod.DELETE,
                entity,
                String.class);

        HttpHeaders headersAfterDelete = new HttpHeaders();
        UriComponentsBuilder builderAfterDelete = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories");
        HttpEntity<?> entityAfterDelete = new HttpEntity<>(headersAfterDelete);
        HttpEntity<String> responseAfterDelete = getTestRestTemplate().exchange(
                builderAfterDelete.build().encode().toUri(),
                HttpMethod.GET,
                entityAfterDelete,
                String.class);

        assertEquals(getExpectedJsonForDelete(), responseAfterDelete.getBody());
    }

    @Test
    public void testUpdate(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories/cee9aa58-4722-11e8-842f-0ed5f89f718b");
        JsonObject json = JsonFileLoader.getJsonForFile("putUpdateCategory").getAsJsonObject();
        HttpEntity<String> entity = new HttpEntity<>(getGson().toJson(json), headers);

        Map<String, String> param = new HashMap<>();
        param.put("id", "cee9aa58-4722-11e8-842f-0ed5f89f718b");

        ResponseEntity<String> response = getTestRestTemplate().exchange(
                builder.build().encode().toUri().toString(),
                HttpMethod.PUT,
                entity,
                String.class,
                param);

        assert(response.getStatusCode().equals(HttpStatus.OK));

        HttpHeaders headersAfterUpdate = new HttpHeaders();
        UriComponentsBuilder builderAfterUpdate = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories");
        HttpEntity<?> entityAfterUpdate = new HttpEntity<>(headersAfterUpdate);
        HttpEntity<String> responseAfterUpdate = getTestRestTemplate().exchange(
                builderAfterUpdate.build().encode().toUri(),
                HttpMethod.GET,
                entityAfterUpdate,
                String.class);

        assertEquals(getExpectedJsonForUpdate(), responseAfterUpdate.getBody());
    }

    @Test
    @Ignore
    public void testPatch(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories/cee9aa58-4722-11e8-842f-0ed5f89f718b");
        JsonObject json = JsonFileLoader.getJsonForFile("patchUpdateCategory").getAsJsonObject();
        HttpEntity<String> entity = new HttpEntity<>(getGson().toJson(json), headers);

        Map<String, String> param = new HashMap<>();
        param.put("id", "cee9aa58-4722-11e8-842f-0ed5f89f718b");

        ResponseEntity<String> response = getTestRestTemplate().exchange(
                builder.build().encode().toUri().toString(),
                HttpMethod.PATCH,
                entity,
                String.class,
                param);

        assert (response.getStatusCode().equals(HttpStatus.OK));

        HttpHeaders headersAfterUpdate = new HttpHeaders();
        UriComponentsBuilder builderAfterUpdate = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories");
        HttpEntity<?> entityAfterUpdate = new HttpEntity<>(headersAfterUpdate);
        HttpEntity<String> responseAfterUpdate = getTestRestTemplate().exchange(
                builderAfterUpdate.build().encode().toUri(),
                HttpMethod.GET,
                entityAfterUpdate,
                String.class);

        assertEquals(getExpectedJsonForUpdate(), responseAfterUpdate.getBody());
    }


    @Test
    public void testCreateCategory(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories");
        JsonObject json = JsonFileLoader.getJsonForFile("saveCategory").getAsJsonObject();
        HttpEntity<String> entity = new HttpEntity<>(getGson().toJson(json), headers);

        ResponseEntity<String> response = getTestRestTemplate().exchange(
            builder.build().encode().toUri().toString(),
            HttpMethod.POST,
            entity,
            String.class);

        //assert (response.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));

        HttpHeaders headersAfterSave = new HttpHeaders();
        UriComponentsBuilder builderAfterSave = UriComponentsBuilder.fromHttpUrl("http://localhost:"+this.getPort()+"/api/v1/categories");
        HttpEntity<?> entityAfterSave = new HttpEntity<>(headersAfterSave);
        HttpEntity<String> responseAfterSave = getTestRestTemplate().exchange(
                builderAfterSave.build().encode().toUri(),
                HttpMethod.GET,
                entityAfterSave,
                String.class);

        assertEquals(getExpectedJsonForSave(), responseAfterSave.getBody());
    }

    @Before
    public void setup(){
        super.setup();
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            File file = new File(classLoader.getResource("response/CategoryControllerFindAllResponse").getFile());
            String raw = FileUtils.readFileToString(file, "utf-8");
            expectedJsonForFindAll = raw.replace("port", getPort());

            file = new File(classLoader.getResource("response/CategoryControllerFindOneResponse").getFile());
            raw = FileUtils.readFileToString(file, "utf-8");
            expectedJsonForFindOne = raw.replace("port", getPort());

            file = new File(classLoader.getResource("response/CategoryControllerDeleteResponse").getFile());
            raw = FileUtils.readFileToString(file, "utf-8");
            expectedJsonForDelete = raw.replace("port", getPort());

            file = new File(classLoader.getResource("response/CategoryControllerUpdateResponse").getFile());
            raw = FileUtils.readFileToString(file, "utf-8");
            expectedJsonForUpdate = raw.replace("port", getPort());

            file = new File(classLoader.getResource("response/CategoryControllerSaveResponse").getFile());
            raw = FileUtils.readFileToString(file, "utf-8");
            expectedJsonForSave = raw.replace("port", getPort());
        }catch (IOException ex){
            this.logger.error("exception on before running test: " + ex.getMessage());
        }
    }

}
