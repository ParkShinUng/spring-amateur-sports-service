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

        JsonNode sidoResultArray = getResultArray(null);

        for (JsonNode sidoNode : sidoResultArray) {
            String sidoCd = sidoNode.get("cd").asText();
            String sidoName = sidoNode.get("addr_name").asText();

            System.out.println("sidoCd : " + sidoCd + ", sidoName : " + sidoName);

            // cd 로 시군구 api 재호출 후 addr_name 재추출
            List<String> sigunguInfo = new ArrayList<>();
            JsonNode sigunguResultArray = getResultArray(sidoCd);
            for (JsonNode sggNode : sigunguResultArray) {
                String sggCd = sggNode.get("cd").asText();
                String sggName = sggNode.get("addr_name").asText();

                sigunguInfo.add(sggName);
            }

            allDistrictInfo.put(sidoName, sigunguInfo);
        }

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