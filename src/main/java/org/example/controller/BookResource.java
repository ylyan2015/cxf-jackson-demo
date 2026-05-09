package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.Book;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Slf4j
@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    // ================================
    // method 1: only JSON（use Book）
    // ================================
    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean setOwnerJson(
            @PathParam("id") String id,
            Book book
    ) {
        log.info("JSON request → id: {}, book: {}", id, book);
        return true;
    }

    // ================================
    // method 2: handle form(form-urlencoded + form-data)
    // ================================
    @POST
    @Path("/{id}")
    @Consumes({
            MediaType.APPLICATION_FORM_URLENCODED,
            MediaType.MULTIPART_FORM_DATA
    })
    public boolean setOwnerForm(
            @PathParam("id") String id,
            MultivaluedMap<String, String> form
    ) {
        Book book = new Book();
        book.setName(form.getFirst("name"));
        book.setPublisher(form.getFirst("publisher"));

        log.info("request → id: {}, book: {}", id, book);
        return true;
    }
}