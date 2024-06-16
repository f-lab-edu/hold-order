package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOptionRepository;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyRequestDto;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyResponseDto;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionRemoveRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Slf4j
public class GoodsOptionCommandService {

    private final GoodsOptionRepository goodsOptionRepository;

    @Autowired
    public GoodsOptionCommandService(GoodsOptionRepository goodsOptionRepository) {
        this.goodsOptionRepository = goodsOptionRepository;
    }

    /**
     * GoodsOption 저장 서비스
     * 1. DB에서 GoodsOption의 ID값으로 가장 큰 Sort 값을 읽는다
     * 2-1. GoodsOption이 존재하면 가장 큰 값에서 1을 더한 후에 GoodsOption을 저장한다
     * 2-2. GoodsOption이 존재하지 않다면 Sort를 1로 설정하고 GoodsOption을 저장한다
     * 3. 저장된 GoodsOption을 반환한다
     *
     * @param goodsOptionInfo
     * @return goodsOptionInfo
     */
    @Transactional
    public GoodsOption save(GoodsOption goodsOptionInfo) {
        Optional<GoodsOption> biggestSortValueInDb = goodsOptionRepository.findById(goodsOptionInfo.getId());

//        log.info("goodsOptionInfo.getSort() : " + goodsOptionInfo.getSort());

        if (biggestSortValueInDb.isPresent()) {
            goodsOptionInfo.setSort(biggestSortValueInDb.get().getSort() + 1);
        } else {
            goodsOptionInfo.setSort(1);
        }
//        log.info("goodsOptionInfo.getSort() : " + goodsOptionInfo.getSort());
        return goodsOptionRepository.save(goodsOptionInfo);
    }

    /**
     * GoodsOption를 수정 서비스
     * 1. 매개변수로 받은 dto를 GoodsOption으로 변환 후, 저장한다
     * 2. 저장된 GoodsOption 값을 responseDto로 변환 후 반환한다
     *
     * @param goodsOptionModifyRequestDto
     * @return
     */
    @Transactional
    public GoodsOptionModifyResponseDto modify(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        GoodsOption savedGoodsOption = goodsOptionRepository.save(new GoodsOption(goodsOptionModifyRequestDto));
        return new GoodsOptionModifyResponseDto(savedGoodsOption);
    }

    @Transactional
    public boolean remove(GoodsOptionRemoveRequestDto goodsOptionRemoveRequestDto) {
//        try {
//            goodsOptionRepository.deleteAll(goodsOptionList);
//        } catch (IllegalArgumentException illegalArgumentException) {
//            throw new IllegalArgumentException("알맞지 않은 argument입니다");
//        }
        return true;
    }

}
