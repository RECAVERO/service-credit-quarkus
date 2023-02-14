package com.nttdata.btask.service;

import com.nttdata.btask.interfaces.CreditService;
import com.nttdata.domain.contract.CreditRepository;
import com.nttdata.domain.models.CreditDto;
import com.nttdata.infraestructure.entity.Credit;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class CreditServiceImpl implements CreditService {
  private final CreditRepository creditRepository;

  public CreditServiceImpl(CreditRepository creditRepository) {
    this.creditRepository = creditRepository;
  }

  @Override
  public List<Credit> getListAllCredit() {
    return creditRepository.getListAllCredit();
  }

  @Override
  public Credit getByIdCredit(Long id) {
    return creditRepository.getByIdCredit(id);
  }

  @Override
  public Credit addCredit(CreditDto creditDto) {
    return creditRepository.addCredit(creditDto);
  }

  @Override
  public List<Credit> updateCredit(Long id, CreditDto creditDto) {
    return creditRepository.updateCredit(id, creditDto);
  }

  @Override
  public List<Credit> deleteCredit(Long id) {
    return creditRepository.deleteCredit(id);
  }
}
