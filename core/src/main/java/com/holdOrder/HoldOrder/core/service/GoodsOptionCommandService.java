package com.holdOrder.HoldOrder.core.service;

import com.holdOrder.HoldOrder.core.domain.goods.Goods;
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
import java.util.Optional;


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

        // goods id 설정
        goodsOption.setGoods(Goods.builder().id(goodsId).build());

        GoodsOption savedGoodsOption = goodsOptionRepository.save(goodsOption);

        return GoodsOptionMapper.INSTANCE.map(savedGoodsOption);
    }

    // GoodsOption 하나 수정하기
    @Transactional
    public GoodsOptionDto modify(GoodsOptionDto goodsOptionDto) {
        GoodsOption goodsOption = GoodsOptionMapper.INSTANCE.map(goodsOptionDto);

        GoodsOption findGoodsOption = goodsOptionRepository.findById(goodsOption.getId()).orElseThrow(() -> new EntityNotFoundException("굿즈옵션을 찾을 수 없습니다."));

        // sort 중복여부 체크
        List<GoodsOption> allByGoodsId = goodsOptionRepository.findAllByGoodsId(findGoodsOption.getGoods().getId());
        allByGoodsId.forEach(item -> {
            if (goodsOptionDto.getSort() != null && item.getSort().equals(goodsOptionDto.getSort())) {
                throw new DataIntegrityViolationException("중복된 정렬이 존재합니다");
            }

            if (goodsOptionDto.getName() != null && item.getName().equals(goodsOptionDto.getName())) {
                throw new DataIntegrityViolationException("중복된 이름이 존재합니다");
            }
        });

        Optional.ofNullable(goodsOptionDto.getName()).ifPresent(a -> findGoodsOption.setName(goodsOptionDto.getName()));
        Optional.ofNullable(goodsOptionDto.getOptionPrice()).ifPresent(a -> findGoodsOption.setOptionPrice(goodsOptionDto.getOptionPrice()));
        Optional.ofNullable(goodsOption.getSort()).ifPresent(a -> findGoodsOption.setSort(goodsOption.getSort()));

        GoodsOption savedGoodsOption = goodsOptionRepository.save(findGoodsOption);

        return GoodsOptionMapper.INSTANCE.map(savedGoodsOption);
    }

    // GoodsOption 하나 삭제하기
    @Transactional
    public void remove(Long id) {
        goodsOptionRepository.delete(goodsOptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("일치하는 굿즈 옵션을 찾을 수 없습니다.")));
    }

}
