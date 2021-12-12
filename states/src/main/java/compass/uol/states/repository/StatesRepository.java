package compass.uol.states.repository;

import compass.uol.states.model.RegionEnum;
import compass.uol.states.model.States;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatesRepository extends JpaRepository<States, RegionEnum> {

    List<States> findByRegion(RegionEnum region);

    Optional<States> findById(Long id);

    Object getById(Long id);

    void deleteById(Long id);
}
