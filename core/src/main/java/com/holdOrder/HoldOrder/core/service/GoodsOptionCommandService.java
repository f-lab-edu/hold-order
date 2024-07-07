package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOption;
import com.holdOrder.HoldOrder.core.domain.goodsOption.GoodsOptionRepository;
import com.holdOrder.HoldOrder.core.dto.goodsOption.GoodsOptionDto;
import com.holdOrder.HoldOrder.core.mapper.GoodsOptionMapper;
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
    public GoodsOptionDto saveWithSort(GoodsOptionDto goodsOptionDto, Long goodsId) {
        Integer topSortValue = goodsOptionRepository.findTopByGoodsIdOrderBySortDesc(goodsId);
        topSortValue = topSortValue == null ? 0 : topSortValue;
        GoodsOption goodsOption = GoodsOptionMapper.INSTANCE.map(goodsOptionDto);
        goodsOption.setSort(topSortValue + 1);

        GoodsOption savedGoodsOption = goodsOptionRepository.save(goodsOption);

        return GoodsOptionMapper.INSTANCE.map(savedGoodsOption);
    }

    // GoodsOption 하나 수정하기
    @Transactional
    public GoodsOptionDto modify(GoodsOptionDto goodsOptionDto) {
        GoodsOption goodsOption = GoodsOptionMapper.INSTANCE.map(goodsOptionDto);

        String errorMessage = "";

        Long goodsIdByGoodsOptionId = goodsOptionRepository.findGoodsIdById(goodsOption.getId()); // TODO

        if (goodsIdByGoodsOptionId == null) {
            errorMessage = "굿즈옵션 정보가 잘못됐습니다";
        }

        // sort 중복여부 체크
        List<GoodsOption> allByGoodsId = goodsOptionRepository.findAllByGoodsId(goodsIdByGoodsOptionId); // TODO
        long countedDuplicateSort = allByGoodsId.stream().filter(item -> item.getSort().equals(goodsOption.getSort())).count();
        if (countedDuplicateSort != 0) {
            errorMessage = "중복된 정렬이 존재합니다";
        }

        // 이름 중복여부 체크
        long countedDuplicateName = allByGoodsId.stream().filter(item -> item.getName().equals(goodsOption.getName())).count();
        if (countedDuplicateName != 0) {
            errorMessage = "중복된 이름이 존재합니다";
        }

        // throw exception
        if (!errorMessage.equals("")) throw new DataIntegrityViolationException(errorMessage);

        GoodsOption savedGoodsOption = goodsOptionRepository.save(goodsOption);

        return GoodsOptionMapper.INSTANCE.map(savedGoodsOption);
    }

    // GoodsOption 하나 삭제하기
    @Transactional
    public void remove(Long id) {
        goodsOptionRepository.delete(goodsOptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("일치하는 굿즈 옵션을 찾을 수 없습니다.")));
    }

}
