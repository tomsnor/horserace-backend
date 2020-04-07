package eu.tommartens.horcerace.lane;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaneRepository extends JpaRepository<Lane, Long> {

}