package com.nttdata.domain.contract;

import com.nttdata.domain.models.CreditDto;
import com.nttdata.infraestructure.entity.Credit;

import java.util.List;

public interface CreditRepository {
  List<Credit> getListAllCredit();
  Credit getByIdCredit(Long id);
  Credit addCredit(CreditDto creditDto);
  List<Credit> updateCredit(Long id, CreditDto creditDto);
  List<Credit> deleteCredit(Long id);
}
