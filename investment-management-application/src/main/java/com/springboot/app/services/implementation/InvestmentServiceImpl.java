package com.springboot.app.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.dao.InvestmentDao;
import com.springboot.app.dto.AddEntityResponseDto;
import com.springboot.app.dto.FundsDto;
import com.springboot.app.dto.HoldingsDto;
import com.springboot.app.dto.InvestorsDto;
import com.springboot.app.dto.AddEntityRequestDto;
import com.springboot.app.dto.TotalMarketValueResponseDto;
import com.springboot.app.dto.TotalMarketValueRequestDto;
import com.springboot.app.entities.Funds;
import com.springboot.app.entities.FundsHoldings;
import com.springboot.app.entities.Holdings;
import com.springboot.app.entities.Investors;
import com.springboot.app.enums.LevelEnum;
import com.springboot.app.exceptions.FundsException;
import com.springboot.app.exceptions.InvalidInputException;
import com.springboot.app.exceptions.InvestorException;
import com.springboot.app.services.InvestmentService;
import com.springboot.app.services.FundService;
import com.springboot.app.services.InvestorService;

@Service
public class InvestmentServiceImpl implements InvestmentService {

	@Autowired
	private InvestmentDao investmentDao;

	@Autowired
	private InvestorService investorService;

	@Autowired
	private FundService fundService;

	@Override
	public AddEntityResponseDto addEntity(AddEntityRequestDto requestDto) {
		AddEntityResponseDto addEntityResponse = new AddEntityResponseDto();
		if (requestDto.getLevel() == LevelEnum.Level0.getValue()) {
			Optional<Investors> investorData = Optional.ofNullable((Investors) investmentDao.getNodebyName(requestDto.getParent(), "investorsName", Investors.class));
			Optional<Funds> fundData = Optional.ofNullable((Funds) investmentDao.getNodebyName(requestDto.getChild(), "fundsName", Funds.class));
			List<Funds> funds = null;
			List<Investors> investors = new ArrayList<>();
			
			Funds fund = null;
			if (!fundData.isPresent()) {
				fund = new Funds();
				fund.setFundsName(requestDto.getChild());
			} else {
				fund = fundData.get();
			}
			
			Investors investor = null;
			if (!investorData.isPresent()) {
				investor = new Investors();
				investor.setInvestorsName(requestDto.getParent());
			} else {
				investor = investorData.get();
			}
			
			if (investor.getFunds() == null)
				funds = new ArrayList<Funds>();
			else
				funds = investor.getFunds();
			
			investors.add(investor);
			fund.setInvestors(investors);
			funds.add(fund);
			investor.setFunds(funds);
			Investors savedInvestors = (Investors) investmentDao.saveOrUpdateObject(investor);
			addEntityResponse.setInvestor(new InvestorsDto(savedInvestors.getInvestorsId(), savedInvestors.getInvestorsName()));
			Set<FundsDto> fundsSet = new HashSet<>();
			if(savedInvestors.getFunds() != null && savedInvestors.getFunds().size()>0) {
				savedInvestors.getFunds().stream().forEach(s->fundsSet.add(new FundsDto(s.getFundsId(), s.getFundsName())));
			}
			addEntityResponse.setFunds(fundsSet);

		} else if (requestDto.getLevel() == LevelEnum.Level1.getValue()) {
			Optional<Funds> fundData = Optional.ofNullable((Funds) investmentDao.getNodebyName(requestDto.getParent(), "fundsName", Funds.class));
			Optional<Holdings> holdingsData = Optional.ofNullable((Holdings) investmentDao.getNodebyName(requestDto.getChild(), "holdingsName", Holdings.class));
			List<FundsHoldings> fundsholding = null;
			FundsHoldings fundsHoldings = new FundsHoldings();
			
			Funds fund = null;
			if (!fundData.isPresent()) {
				fund = new Funds();
				fund.setFundsName(requestDto.getParent());
			} else {
				fund = fundData.get();
			}
			
			Holdings holdings = null;
			if (!holdingsData.isPresent()) {
				holdings = new Holdings();
				holdings.setHoldingsName(requestDto.getChild());
				holdings.setHoldingValue(requestDto.getHoldingValue());
			} else {
				holdings = holdingsData.get();
			}
			
			if (fund.getFundsHoldings() == null || fund.getFundsHoldings().size() == 0)
				fundsholding = new ArrayList<FundsHoldings>();
			else
				fundsholding = fund.getFundsHoldings();

			fundsHoldings.setFunds(fund);
			fundsHoldings.setQuantity(requestDto.getEdge());
			fundsHoldings.setHoldings(holdings);
			fundsholding.add(fundsHoldings);
			fund.setFundsHoldings(fundsholding);
			holdings.setFundsHoldings(fundsholding);
			investmentDao.saveOrUpdateObject(holdings);
			Funds savedFunds = (Funds) investmentDao.saveOrUpdateObject(fund);
			Set<FundsDto> fundsSet = new HashSet<>();
			Set<HoldingsDto> holdingsSet = new HashSet<>();
			if(savedFunds != null && savedFunds.getFundsHoldings() != null &&  savedFunds.getFundsHoldings().size()>0) {
				savedFunds.getFundsHoldings().stream().forEach(s-> {fundsSet.add(new FundsDto(s.getFunds().getFundsId(), s.getFunds().getFundsName()));
																	holdingsSet.add(new HoldingsDto(s.getHoldings().getHoldingsId(), s.getHoldings().getHoldingsName()));
																	});
			}
			addEntityResponse.setFunds(fundsSet);
			addEntityResponse.setHoldings(holdingsSet);
			
		} else if (requestDto.getLevel() == LevelEnum.Level2.getValue()) {
			Optional<Funds> fundData = Optional.ofNullable((Funds) investmentDao.getNodebyName(requestDto.getParent(), "fundsName", Funds.class));
			Optional<Holdings> holdingsData = Optional.ofNullable((Holdings) investmentDao.getNodebyName(requestDto.getChild(), "holdingsName", Holdings.class));
			List<FundsHoldings> fundsholding = null;
			FundsHoldings fundsHoldings = new FundsHoldings();
			
			Funds fund = null;
			if (!fundData.isPresent()) {
				fund = new Funds();
				fund.setFundsName(requestDto.getParent());
			} else {
				fund = fundData.get();
			}
			
			Holdings holdings = null;
			if (!holdingsData.isPresent()) {
				holdings = new Holdings();
				holdings.setHoldingsName(requestDto.getChild());
				holdings.setHoldingValue(requestDto.getHoldingValue());
			} else {
				holdings = holdingsData.get();
			}
			if (fund.getFundsHoldings() == null || fund.getFundsHoldings().size() == 0)
				fundsholding = new ArrayList<FundsHoldings>();
			else
				fundsholding = fund.getFundsHoldings();

			fundsHoldings.setFunds(fund);
			fundsHoldings.setQuantity(requestDto.getEdge());
			fundsHoldings.setHoldings(holdings);
			fundsholding.add(fundsHoldings);
			fund.setFundsHoldings(fundsholding);
			investmentDao.saveOrUpdateObject(holdings);
			investmentDao.saveOrUpdateObject(fund);
			Funds savedFunds = (Funds) investmentDao.saveOrUpdateObject(fund);
			Set<FundsDto> fundsSet = new HashSet<>();
			Set<HoldingsDto> holdingsSet = new HashSet<>();
			if(savedFunds != null && savedFunds.getFundsHoldings() != null &&  savedFunds.getFundsHoldings().size()>0) {
				savedFunds.getFundsHoldings().stream().forEach(s-> {fundsSet.add(new FundsDto(s.getFunds().getFundsId(), s.getFunds().getFundsName()));
																	holdingsSet.add(new HoldingsDto(s.getHoldings().getHoldingsId(), s.getHoldings().getHoldingsName()));
																	});
			}
			addEntityResponse.setFunds(fundsSet);
			addEntityResponse.setHoldings(holdingsSet);
			
		}
		return addEntityResponse;
	}

	@Override
	public TotalMarketValueResponseDto getTotalMarketValue(TotalMarketValueRequestDto totalMarketValueRequestDto)
			throws InvalidInputException, InvestorException, FundsException {
		TotalMarketValueResponseDto responseDto = new TotalMarketValueResponseDto();
		Investors investors = null;
		Funds funds = null;

		if (totalMarketValueRequestDto.getInvestorsId() == null && totalMarketValueRequestDto.getFundsId() == null) {
			throw new InvalidInputException("Kindly add Investors Id or Funds Id");
		}

		if (totalMarketValueRequestDto.getInvestorsId() != null) {
			Optional<Investors> investorsData = investorService.getInvestorsById(totalMarketValueRequestDto.getInvestorsId());
			if (investorsData.isPresent()) {
				investors = investorsData.get();
				double totalMarketValueByInvestors = investorService.getTotalMarketValue(
						totalMarketValueRequestDto.getInvestorsId(),
						totalMarketValueRequestDto.getExclusionHoldingList() == null ? new ArrayList<Integer>() : totalMarketValueRequestDto.getExclusionHoldingList());
				responseDto.setTotalMarketValueByInvestor(totalMarketValueByInvestors);
			} else {
				if (totalMarketValueRequestDto.getFundsId() == null) {
					throw new InvestorException("Kindly enter a valid Investors Id");
				}
			}
		}

		if (totalMarketValueRequestDto.getFundsId() != null) {
			Optional<Funds> fundsData = fundService.getFundsById(totalMarketValueRequestDto.getFundsId());
			if (fundsData.isPresent()) {
				funds = fundsData.get();
				double totalMarketValueByFunds = fundService.getTotalMarketValue(
						totalMarketValueRequestDto.getFundsId(), totalMarketValueRequestDto.getExclusionHoldingList() == null ? new ArrayList<Integer>() : 
							totalMarketValueRequestDto.getExclusionHoldingList());
				responseDto.setTotalMarketValueByFunds(totalMarketValueByFunds);
			} else {
				if (totalMarketValueRequestDto.getInvestorsId() == null) {
					throw new FundsException("Kinldy enter a valid Funds Id");
				}
			}
		}

		if (investors == null && funds == null) {
			throw new InvalidInputException("No investment was found with the mentioned Investor Id and Funds Id");
		}

		return responseDto;
	}

}
