package com.spring.amateur_sports_service.repository;

import com.spring.amateur_sports_service.domain.Supporter;

import java.util.*;

public class MemorySupporterRepository implements SupporterRepository {

    private static Map<Long, Supporter> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Supporter save(Supporter supporter) {
        supporter.setId(++sequence);
        store.put(supporter.getId(), supporter);
        return supporter;
    }

    @Override
    public Optional<Supporter> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Supporter> findByGroundName(String groundName) {
        return store.values().stream()
                .filter(supporter -> supporter.getGroundName().equals(groundName))
                .findAny();
    }

    @Override
    public Optional<Supporter> findByMatchDate(String date) {
        return Optional.empty();
    }

    @Override
    public Optional<Supporter> findByGroundAddress(String groundAddress) {
        return store.values().stream()
                .filter(supporter -> supporter.getGroundAddr().equals(groundAddress))
                .findAny();
    }

    @Override
    public List<Supporter> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
