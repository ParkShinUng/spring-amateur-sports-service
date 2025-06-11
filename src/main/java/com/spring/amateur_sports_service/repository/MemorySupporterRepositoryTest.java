package com.spring.amateur_sports_service.repository;

import com.spring.amateur_sports_service.domain.Supporter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemorySupporterRepositoryTest {

    MemorySupporterRepository repository = new MemorySupporterRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Supporter supporter = new Supporter();
        supporter.setGroundName("우장산 축구장");

        repository.save(supporter);

        Supporter result = repository.findById(supporter.getId()).get();
        Assertions.assertThat(supporter).isEqualTo(result);
    }

    @Test
    public void findByGroundName() {
        Supporter supporter1 = new Supporter();
        supporter1.setGroundName("우장산축구장");
        repository.save(supporter1);

        Supporter supporter2 = new Supporter();
        supporter2.setGroundName("개화 축구장");
        repository.save(supporter2);

        Supporter result = repository.findByGroundName("우장산축구장").get();

        Assertions.assertThat(result).isEqualTo(supporter1);
    }

    @Test
    public void findAll() {
        Supporter supporter1 = new Supporter();
        supporter1.setGroundName("우장산축구장");
        repository.save(supporter1);

        Supporter supporter2 = new Supporter();
        supporter2.setGroundName("개화축구장");
        repository.save(supporter2);

        List<Supporter> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
