package horarios;

import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class horarios {

	public static void main(String[] args) {
		//Establecemos la fecha que deseamos en un Calendario
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				
				//Desplegamos la fecha
				Date tempDate = cal.getTime();
				System.out.println("Fecha actual: " + tempDate);
				
				//Le cambiamos la hora y minutos
				cal.set(Calendar.HOUR, cal.get(Calendar.HOUR)+ 2);
				cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)- 5);
				tempDate = cal.getTime();
				System.out.println("Hora modificada: " + tempDate);
				
				//Le cambiamos el mes
				cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
				System.out.println("Fecha modificada: " + cal.getTime());
				
		//De la misma forma se puede cambiar año, semana, etc
				
				
				
				Calendar calP= Calendar.getInstance();
				calP.setTime(new Date());
				Date fecha = calP.getTime();
				System.out.println("Fecha/hora hoy: "+fecha);
				
				Calendar calC= Calendar.getInstance();
				calC.setTime(new Date());
				
				calC.set(Calendar.HOUR, 11);
				calC.set(Calendar.MINUTE, 10);
				calC.set(Calendar.DAY_OF_MONTH,cal.get(Calendar.MINUTE) + 45);
				calC.set(Calendar.MONTH,5);
				
				
				Date fechaC = calC.getTime();
				System.out.println("Fecha/Hora CITA: "+fechaC);
				int horaP= calP.get(Calendar.HOUR_OF_DAY);
				int minsP=calP.get(Calendar.MINUTE);
				int horaC= calC.get(Calendar.HOUR_OF_DAY);
				int minsC=calC.get(Calendar.MINUTE);
				
				if(calP.get(Calendar.MINUTE)<10) {
					String horaPrueba=horaP+":0"+minsP;
					LocalTime horaCitaPrueba= LocalTime.parse(horaPrueba);
					System.out.println("Fecha/Hora CITA PRUEBA en LocalTime: "+horaCitaPrueba);
					String horaPeticion=horaC+":"+minsC;
					LocalTime horaCita= LocalTime.parse(horaPeticion);
					System.out.println("Fecha/Hora CITA en LocalTime: "+horaCita);
					int minutes = (int) ChronoUnit.MINUTES.between(horaCitaPrueba, horaCita);
					System.out.println("Diferencia de minutos: "+minutes);
				}else {
					String horaPrueba=horaP+":"+minsP;
					LocalTime horaCitaPrueba= LocalTime.parse(horaPrueba);
					System.out.println("Fecha/Hora CITA PRUEBA en LocalTime: "+horaCitaPrueba);
					String horaPeticion=horaC+":"+minsC;
					LocalTime horaCita= LocalTime.parse(horaPeticion);
					System.out.println("Fecha/Hora CITA en LocalTime: "+horaCita);
					int minutes = (int) ChronoUnit.MINUTES.between(horaCitaPrueba, horaCita);
					System.out.println("Diferencia de minutos: "+minutes);
				}
				
				
				
	}
	
}
