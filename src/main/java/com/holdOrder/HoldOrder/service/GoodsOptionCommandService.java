package com.holdOrder.HoldOrder.service;

import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.domain.goodsOption.GoodsOptionRepository;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyRequestDto;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionModifyResponseDto;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionRemoveRequestDto;
import com.holdOrder.HoldOrder.dto.goodsOption.GoodsOptionSaveRequestDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class GoodsOptionCommandService {

    private final GoodsOptionRepository goodsOptionRepository;

    // GoodsOption 하나 저장하기
    @Transactional
    public GoodsOption save(GoodsOptionSaveRequestDto goodsOptionSaveRequestDto) {
        Integer topSortValue = goodsOptionRepository.findTopByGoodsIdOrderBySortDesc(goodsOptionSaveRequestDto.getGoodsId());
        topSortValue = topSortValue == null ? 0 : topSortValue;
        GoodsOption goodsOptionDto = goodsOptionSaveRequestDto.getGoodsOption();
        goodsOptionDto.setSort(topSortValue + 1);

        return goodsOptionRepository.save(goodsOptionDto);
    }

    // GoodsOption 하나 수정하기
    @Transactional
    public GoodsOptionModifyResponseDto modify(GoodsOptionModifyRequestDto goodsOptionModifyRequestDto) {
        GoodsOption goodsOptionDto = new GoodsOption(goodsOptionModifyRequestDto);
        String errorMessage = "";

        Long goodsIdByGoodsOptionId = goodsOptionRepository.findGoodsIdByGoodsOptionId(goodsOptionDto.getId());

        // sort 중복여부 체크
        List<GoodsOption> allByGoodsId = goodsOptionRepository.findAllByGoodsId(goodsIdByGoodsOptionId);
        long countedDuplicateSort = allByGoodsId.stream().filter(item -> item.getSort().equals(goodsOptionDto.getSort())).count();
        if (countedDuplicateSort != 0) errorMessage = "중복된 정렬이 존재합니다";

        // 이름 중복여부 체크
        long countedDuplicateName = allByGoodsId.stream().filter(item -> item.getName().equals(goodsOptionDto.getName())).count();
        if (countedDuplicateName != 0) errorMessage = "중복된 이름이 존재합니다";

        // throw exception
        if (!errorMessage.equals("")) throw new DataIntegrityViolationException(errorMessage);

        GoodsOption savedGoodsOption = goodsOptionRepository.save(goodsOptionDto);
        return new GoodsOptionModifyResponseDto(savedGoodsOption);
    }

    // GoodsOption 하나 삭제하기
    @Transactional
    public void remove(Long id) {
        goodsOptionRepository.delete(goodsOptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("일치하는 굿즈 옵션을 찾을 수 없습니다.")));
    }

}
