package com.nttdata.infraestructure.repository;

import com.nttdata.domain.contract.CreditRepository;
import com.nttdata.domain.models.CreditDto;
import com.nttdata.domain.models.ResponseDto;
import com.nttdata.infraestructure.entity.Credit;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ApplicationScoped
public class CreditRepositoryImpl implements CreditRepository {
  @Override
  public List<Credit> getListAllCredit() {
    return Credit.listAll();
  }

  @Override
  public Credit getByIdCredit(Long id) {
    return Credit.findById(id);
  }

  @Override
  @Transactional
  public Credit addCredit(CreditDto creditDto) {

    Credit credit = new Credit();

    credit.setNumberDocument(creditDto.getNumberDocument());
    credit.setBalanceStart(creditDto.getBalanceStart());
    credit.setBalanceEnd(creditDto.getBalanceEnd());
    credit.setShare(creditDto.getShare());
    credit.setAmount(creditDto.getAmount());
    credit.setDateStart(creditDto.getDateStart());
    credit.setDatePay(creditDto.getDatePay());
    credit.setCreated_datetime(this.getDateNow());
    credit.setUpdated_datetime(this.getDateNow());
    credit.setActive("S");
    credit.persist();
    return credit;
  }

  @Override
  @Transactional
  public List<Credit> updateCredit(Long id, CreditDto creditDto) {
    List<Credit> collect = new ArrayList<>();
    Credit creditOp = Credit.findById(id);

    if(creditOp == null){
      return collect;
    }else{
      if(creditOp.getActive().equals("S")){
        creditOp.setNumberDocument(creditDto.getNumberDocument());
        creditOp.setBalanceStart(creditDto.getBalanceStart());
        creditOp.setBalanceEnd(creditDto.getBalanceEnd());
        creditOp.setAmount(creditDto.getAmount());
        creditOp.setDateStart(creditDto.getDateStart());
        creditOp.setDatePay(creditDto.getDatePay());
        creditOp.setUpdated_datetime(this.getDateNow());
        creditOp.persist();
        collect.add(creditOp);
      }else{
        return collect;
      }
    }
    return collect;
  }

  @Override
  @Transactional
  public List<Credit> deleteCredit(Long id) {
    List<Credit> collect = new ArrayList<>();
    Credit creditOp = Credit.findById(id);

    if(creditOp == null){
      return collect;
    }else{
      creditOp.setUpdated_datetime(this.getDateNow());
      creditOp.setActive("N");
      creditOp.persist();
      collect.add(creditOp);
      return collect;
    }
  }

  private static String getDateNow(){
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return formatter.format(date).toString();
  }
}
