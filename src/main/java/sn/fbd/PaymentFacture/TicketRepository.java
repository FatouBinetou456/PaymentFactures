package sn.fbd.PaymentFacture;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

//
//    Optional<Ticket> findTicketBy(Long aLong);



    Ticket findTicketByAgency(Agency agency);


    List<Ticket> findAll();


}
