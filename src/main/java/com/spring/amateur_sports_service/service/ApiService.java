package com.spring.amateur_sports_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ApiService {
    private final WebClient.Builder webClientBuilder;

    public Map<String, List<String>> getAdministrativeData() {
        Map<String, List<String>> allDistrictInfo = new HashMap<>();

        allDistrictInfo.put("서울특별시", List.of("종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구"));
        allDistrictInfo.put("경기도", List.of("수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "평택시", "동두천시", "안산시", "고양시", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시", "김포시", "화성시", "광주시", "양주시", "포천시", "여주시", "연천군", "가평군", "양평군"));
        allDistrictInfo.put("인천광역시", List.of("중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군"));
        allDistrictInfo.put("부산광역시", List.of("중구", "서구", "동구", "영도구", "부산진구", "동래구", "남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군"));
//
//        JsonNode sidoResultArray = getResultArray(null);
//
//        for (JsonNode sidoNode : sidoResultArray) {
//            String sidoCd = sidoNode.get("cd").asText();
//            String sidoName = sidoNode.get("addr_name").asText();
//
//            System.out.println("sidoCd : " + sidoCd + ", sidoName : " + sidoName);
//
//            // cd 로 시군구 api 재호출 후 addr_name 재추출
//            List<String> sigunguInfo = new ArrayList<>();
//            JsonNode sigunguResultArray = getResultArray(sidoCd);
//            for (JsonNode sggNode : sigunguResultArray) {
//                String sggCd = sggNode.get("cd").asText();
//                String sggName = sggNode.get("addr_name").asText();
//
//                sigunguInfo.add(sggName);
//            }
//
//            allDistrictInfo.put(sidoName, sigunguInfo);
//        }

        return allDistrictInfo;
    }

    public JsonNode getResultArray(String code) {
        String API_URL = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";
        String ACCESS_TOKEN = "8ff32236-e39a-43dd-90d7-73f35fa9a146";

        WebClient webClient = webClientBuilder.baseUrl(API_URL).build();
        Mono<String> response = webClient.get()
                .uri(uriBuilder -> { uriBuilder
                        .queryParam("accessToken", ACCESS_TOKEN);
                    if (code != null) {
                        uriBuilder.queryParam("cd", Integer.parseInt(code));
                    }
                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(String.class);

        String json = response.block();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readTree(json).get("result");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}