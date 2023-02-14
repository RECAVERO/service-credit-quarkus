package com.nttdata.application.rest;

import com.nttdata.btask.interfaces.CreditService;
import com.nttdata.domain.models.CreditDto;
import com.nttdata.domain.models.ResponseDto;
import com.nttdata.infraestructure.entity.Credit;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/credit")
public class CreditController {
  private final CreditService creditService;

  public CreditController(CreditService creditService) {
    this.creditService = creditService;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllCredit() {
    List<Credit> listCard = creditService.getListAllCredit()
        .stream()
        .filter(card ->card.getActive().equals("S"))
        .collect(Collectors.toList());
    return Response.ok(listCard).status(200).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getByIdCredit(@PathParam("id") Long id) {
    List<Credit> list = new ArrayList<>();
    Credit credit = creditService.getByIdCredit(id);
    list.add(credit);
    List<Credit> listCard = list.stream()
        .filter(c ->c.getActive().equals("S"))
        .collect(Collectors.toList());
    return Response.ok(listCard).status(200).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addCredit(CreditDto creditDto) {
    return Response.ok(creditService.addCredit(creditDto)).status(201).build();
  }

  @PUT
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateCredit(Long id, CreditDto creditDto) {
    ResponseDto responseDto = new ResponseDto();
    List<Credit> credit = this.creditService.updateCredit(id, creditDto);
    if(credit.size() == 0){
      responseDto.setStatus("204");
      responseDto.setMessage("customer not found");
      return Response.ok(responseDto).status(204).build();

    }else{
      responseDto.setStatus("200");
      responseDto.setMessage("Se proceso Correctamente");
      responseDto.setCredit(credit);
      return Response.ok(responseDto).build();
    }
  }

  @DELETE
  @Path("{id}")
  public Response deleteCredit(@PathParam("id") Long id) {
    ResponseDto responseDto = new ResponseDto();
    List<Credit> credit = this.creditService.deleteCredit(id);

    if(credit.size() == 0){
      responseDto.setStatus("204");
      responseDto.setMessage("Card not found");
      return Response.ok(responseDto).status(204).build();

    }else{
      responseDto.setStatus("200");
      responseDto.setMessage("Se proceso Correctamente");
      responseDto.setCredit(credit);
      return Response.ok(responseDto).build();
    }

  }
}
