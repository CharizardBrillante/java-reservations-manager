package com.danieleterracciano.reservationmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.danieleterracciano.reservationmanager.configs.Config;
import com.danieleterracciano.reservationmanager.entities.Reservation;
import com.danieleterracciano.reservationmanager.entities.WorkstationType;
import com.danieleterracciano.reservationmanager.services.BuildingService;
import com.danieleterracciano.reservationmanager.services.ReservationService;
import com.danieleterracciano.reservationmanager.services.WorkstationService;


@SpringBootApplication
public class ReservationManagerApplication implements CommandLineRunner{
	
	@Autowired WorkstationService ws;
	
	Logger logger = LoggerFactory.getLogger(ReservationManagerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ReservationManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Abbiamo visto l'errore insieme, ma non siamo ancora riuscito a spiegarcelo
		//logger.info(ws.getWorkstationsByCityAndType("Napoli", WorkstationType.PRIVATE).toString());

		
	}
	
	public Reservation[] config() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		Reservation r1 = ctx.getBean("getReservation1", Reservation.class);
		Reservation r2 = ctx.getBean("getReservation2", Reservation.class);
		Reservation r3 = ctx.getBean("getReservation3", Reservation.class);

		((AnnotationConfigApplicationContext)ctx).close();
		
		return new Reservation[] {r1, r2, r3};
	}

}
