package com.wpsnetwork.consola;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) throws ParseException {
		//JDK7
		//=========
		
		Date fecha = new Date();			//Fecha y hora actual
		System.out.println("Fecha y hora actual: " + fecha);
		
		//Sumar 6 segundos a la fecha
		fecha.setTime(fecha.getTime() + 6000);
		System.out.println("Fecha y hora actual + 6s: " + fecha);
		
		//La clase Calendar nos ayuda a manipular Dates
		Calendar calendario = Calendar.getInstance();
		System.out.println("Primer día de la semana: " + calendario.getFirstDayOfWeek());
		
		//Zona horaria del calendario
		System.out.println("Zona horaria:" + calendario.getTimeZone());
		
		calendario.set(2016, Calendar.FEBRUARY, 28);
		
		//Añadimos un día
		calendario.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(calendario.getTime());
		
		//Día de la semana que corresponde esta fecha
		calendario.setTime(fecha);
		System.out.println("Día de la semana de la fecha: " + 
				calendario.get(Calendar.DAY_OF_WEEK));
		
		//JDK8
		
		//Clase TimeZone
		System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
		
		//La clase LocalDate solo almacena fechas
		LocalDate fecha2 = LocalDate.of(2016, Month.FEBRUARY, 28);
		System.out.println(fecha2);
		
		//Manipular la fecha LocalDate
		fecha2 = fecha2.minusDays(1);		//Restamos un día
		fecha2 = fecha2.plusDays(1);		//Añadimos un día
		fecha2 = fecha2.plusWeeks(1);		//Añadimos una semana
		System.out.println(fecha2);
		
		System.out.println("Día de la semana: " + fecha2.getDayOfWeek());
		System.out.println("Día del mes: " + fecha2.getDayOfMonth());
		System.out.println("Día del año: " + fecha2.getDayOfYear());
		System.out.println("Mes: " + fecha2.getMonth());
		System.out.println("Año: " + fecha2.getYear());
		
		//La clase Period permite almacenar un intervalo de tiempo
		// igual o superior a días
		Period anual = Period.ofYears(1);
		fecha2 = fecha2.plus(anual);
		System.out.println("Fecha sumando el período de 1 año: " + fecha2);
		
		//La clase Duration permite almacenar un intervalo de tiempo
		// igual o inferior a un día
		//Duration duracion = Duration.ofHours(1);
		Duration duracion = Duration.of(1, ChronoUnit.HOURS);
		LocalTime hora = LocalTime.now();			//Hora actual
		hora = hora.plus(duracion);
		System.out.println("Hora sumando la duración de 1 hora: " + hora);
		
		LocalDate fecha_actual = LocalDate.now(); //Fecha actual
		LocalDate fecha_antigua = fecha_actual.minusDays(1);	//Dia anterior
		LocalDate fecha_futura = fecha_actual.plusDays(1);		//Dia posterior
		
		System.out.println("Resultado comparación " + 
                           fecha_actual.isAfter(fecha_antigua));
		System.out.println("Resultado comparación " + 
                fecha_actual.isBefore(fecha_antigua));
		
//		LocalTime
//		==========
		
		//Almacena solo tiempos (hora, minutos y segundos)
		LocalTime horaActual = LocalTime.now();   //Hora actual
		LocalTime hora2 = LocalTime.of(5, 30, 10);
		
		System.out.println(horaActual);
		System.out.println(hora2);
		
		//Manipular tiempos
		hora2 = hora2.plusHours(1);
		System.out.println(hora2);
		
//		LocalDateTime
//		===============
		
//		Almacena día y hora
		
		LocalDateTime fechaHora = LocalDateTime.of(2016, Month.FEBRUARY, 28, 
													12, 30, 10);
		System.out.println("LocalDateTime: " + fechaHora);
		
		//Convertir de Date a LocalDateTime
		Date fechaA = new Date();		//Fecha actual
		Instant instanteDate = fechaA.toInstant();
		LocalDateTime fechaConvertida = LocalDateTime.ofInstant(instanteDate, ZoneId.systemDefault());
		System.out.println("Conversion Date -> LocalDateTime: " + fechaConvertida);
		
		//Convertir de LocalDateTime a Date
		Instant instante = fechaConvertida.toInstant(ZoneOffset.UTC);
		Date fechaDate = Date.from(instante);
		System.out.println("Conversion LocalDate -> Date: " + fechaDate);
		
		//Formateo de fechas según Locale
		
//		JDK 7 o anterior
//		----------------
		
		DateFormat df = DateFormat.getDateInstance();
		String fechaString = df.format(new Date());
		
		System.out.println("Fecha en formato texto: " + fechaString);
		
		fechaDate = df.parse("10-ene-2016");
		System.out.println("Fecha en formato Date: " + fechaDate);
		
		//El DateFormat hay que saber el formato que tiene el Locale
		
		SimpleDateFormat dfs = new SimpleDateFormat("dd/MMMM/yyyy HH:mm");
		System.out.println(dfs.format(new Date()));
		
		//JDK8
//		========
		
		System.out.println(fecha_actual.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		//para convertir a String
		//DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
		System.out.println(fecha_actual.format(dtf));
		
		//Para convertir a LocalDate, LocalDateTime,...
		LocalDate fechaN = LocalDate.from(dtf.parse("01/enero/2016"));
		System.out.println(fechaN);
		
//		Formatear Números y Monedas
//		===========================
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		System.out.println(nf.format(1000.2321));
		
		nf = NumberFormat.getCurrencyInstance();
		NumberFormat nfe = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println(nf.format(1000.2321));
		System.out.println(nfe.format(1000.2321));
		
		double numero = (Double) nf.parse("23,55 €");
		System.out.println(numero);
	}

}




















