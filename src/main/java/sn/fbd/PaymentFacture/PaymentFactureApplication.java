package sn.fbd.PaymentFacture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class PaymentFactureApplication implements CommandLineRunner {

	@Autowired
	private AgencyRepository agencyRepo;
	@Autowired
	private ServiceRepository serviceRepo;
	@Autowired
	private TicketRepository ticketRepository;

	private final Random random = new Random();

	public static void main(String[] args) {
		SpringApplication.run(PaymentFactureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creating Business Services
		BusinessService orange = new BusinessService("Orange");
		BusinessService senelec = new BusinessService("Senelec");
		BusinessService seneau = new BusinessService("SenEau");
		BusinessService fbank = new BusinessService("FBank");
		serviceRepo.saveAll(Arrays.asList(orange, senelec, seneau, fbank));

		// Creating Agencies
		List<Agency> agencies = Arrays.asList(
				new Agency("Dakar Plateau", 5, senelec),
				new Agency("Medina", 4, senelec),
				new Agency("Parcelles Assainies", 6, senelec),
				new Agency("Ouakam", 7, senelec),
				new Agency("Ngor", 3, senelec),
				new Agency("Hann Bel-Air", 5, seneau),
				new Agency("Mermoz", 5, seneau),
				new Agency("Grand Yoff", 6, seneau),
				new Agency("Yoff", 7, seneau),
				new Agency("Sicap Baobab", 3, seneau),
				new Agency("Cambérène", 5, orange),
				new Agency("Fann-Point E", 4, orange),
				new Agency("Colobane", 6, orange),
				new Agency("Guédiawaye", 7, orange),
				new Agency("Rufisque", 3, orange),
				new Agency("Keur Massar", 8, fbank),
				new Agency("Pikine", 4, fbank),
				new Agency("Malika", 6, fbank),
				new Agency("Tivaouane Peulh", 7, fbank),
				new Agency("Diamniadio", 3, fbank)
		);

		agencyRepo.saveAll(agencies);

		// Initializing Tickets
		for (Agency agency : agencies) {
			// Check if a ticket already exists for the agency
			if (ticketRepository.findTicketByAgency(agency) == null) {
				// Create and save a new ticket
				Ticket ticket = new Ticket(agency, generateRandomTicketNumber(),generateRandomQueueSize(), generateRegisterNumber(agency.getNumbRegisters()));
				ticketRepository.save(ticket);
				System.out.println("Created initial ticket for agency: " + agency.getLocation());
			}
		}
	}



	// Generate a random ticket number between 100 and 999
	private int generateRandomTicketNumber() {
		return random.nextInt(900) + 100;
	}
	private int generateRandomQueueSize(){
		return random.nextInt(100);
	}

	private int generateRegisterNumber(int numbRegisters) {
		return random.nextInt(numbRegisters)+1;
	}
}
