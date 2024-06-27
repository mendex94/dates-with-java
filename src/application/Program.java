package application;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {
    public static void main(String[] args) {
        // LocalDate irá pegar a data atual do sistema operacional do usuário sem o horário.
        LocalDate date = LocalDate.now();
        System.out.println(date);

        // LocalDateTime irá pegar a data e o horário atual do sistema operacional do usuário.
        LocalDateTime date_hour = LocalDateTime.now();
        System.out.println(date_hour);

        // Instant irá pegar a data e o horário atual do sistema operacional do usuário em UTC.
        Instant date_hour_z = Instant.now();
        System.out.println(date_hour_z);

        // Parseando uma data no formato ISO 8601 para LocalDate.
        String date_iso = "2021-07-25";
        LocalDate date_iso_parse = LocalDate.parse(date_iso);
        System.out.println(date_iso_parse);

        // Parseando uma data no formato ISO 8601 para LocalDateTime.
        String date_hour_iso = "2021-07-25T15:42:07";
        LocalDateTime date_hour_iso_parse = LocalDateTime.parse(date_hour_iso);
        System.out.println(date_hour_iso_parse);

        // Parseando uma data no formato ISO 8601 para Instant.
        Instant date_hour_iso_z_parse = Instant.parse("2021-07-25T15:42:07Z");
        System.out.println(date_hour_iso_z_parse);

        // Parseando OffsetDateTime para Instant.

        // A linha abaixo está comentada pois funciona apenas em JDK 11 ou inferior.
        // OffsetDateTime offset_date_hour = OffsetDateTime.parse("2021-07-25T15:42:07-03:00");
        //Instant offset_date_hour_z = offset_date_hour.toInstant();
        //System.out.println(offset_date_hour_z);
        Instant offset_date_hour_z = Instant.parse("2021-07-25T15:42:07-03:00");
        System.out.println(offset_date_hour_z);


        // Formatando uma data no formato padrão.
        DateTimeFormatter formatter_default = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime date_hour_default = LocalDateTime.now();
        System.out.println(date_hour_default.format(formatter_default));

        // Formatando uma data no formato customizado.
        DateTimeFormatter formatter_custom = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date_hour_custom = LocalDateTime.now();
        System.out.println(date_hour_custom.format(formatter_custom));

        // Parseando uma data no formato customizado para LocalDate.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate custom_date = LocalDate.parse("25/07/2021", formatter);
        System.out.println(custom_date);

        // LocalDate para String.
        String custom_date_string = custom_date.format(formatter);
        System.out.println(custom_date_string);

        // LocalDateTime para String.
        String custom_date_hour_string = date_hour_custom.format(formatter_custom);
        System.out.println(custom_date_hour_string);

        // OffsetDateTime para String.
        OffsetDateTime offset_date_hour = OffsetDateTime.parse("2021-07-25T15:42:07-03:00");
        DateTimeFormatter formatter_offset = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss Z");
        String offset_date_hour_string = offset_date_hour.format(formatter_offset);
        System.out.println(offset_date_hour_string);

        // Instant para String.
        Instant date_hour_iso_z = Instant.parse("2021-07-25T01:42:07Z");
        DateTimeFormatter formatter_instant = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        String date_hour_iso_z_string = formatter_instant.format(date_hour_iso_z);
        System.out.println(date_hour_iso_z_string);

        // Instant para LocalDate.
        Instant date_hour_iso_z_to_localdate = Instant.parse("2021-07-25T01:42:07Z");
        LocalDate date_hour_iso_z_to_localdate_parse = date_hour_iso_z_to_localdate.atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(date_hour_iso_z_to_localdate_parse);

        // Subtraindo dias de LocalDate.
        LocalDate past_week = LocalDate.now().minusDays(7);
        LocalDate next_week = LocalDate.now().plusDays(7);
        System.out.println(past_week);

        // Subtraindo horas de LocalDateTime.
        LocalDateTime past_hour = LocalDateTime.now().minusHours(1);
        LocalDateTime next_hour = LocalDateTime.now().plusHours(1);
        System.out.println(past_hour);

        // Subtraindo de Instant.
        Instant past_seven_days = Instant.now().minus(7, ChronoUnit.DAYS);
        Instant next_seven_days = Instant.now().plus(7, ChronoUnit.DAYS);
        System.out.println(past_seven_days);

        // Calculando a diferença entre duas datas.
        Duration duration = Duration.between(past_seven_days, next_seven_days);
        System.out.println(duration.toDays());

        // Calculando a diferença entre duas datas.
        Period period = Period.between(past_week, next_week);
        System.out.println(period.getDays());

    }
}
