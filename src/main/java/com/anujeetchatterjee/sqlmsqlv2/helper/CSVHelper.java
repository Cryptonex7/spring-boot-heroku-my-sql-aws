package com.anujeetchatterjee.sqlmsqlv2.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anujeetchatterjee.sqlmsqlv2.models.Citizen;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Id", "Title", "Description", "Published"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Citizen> csvToCitizens(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Citizen> citizens = new ArrayList<Citizen>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                System.out.println(
                        "CSV:" +
                                new Citizen(
                                        Integer.parseInt(csvRecord.get("aadhaarNumber")),
                                        csvRecord.get("name"),
                                        Integer.parseInt(csvRecord.get("age")),
                                        csvRecord.get("gender").charAt(0),
                                        Integer.parseInt(csvRecord.get("phoneNumber")),
                                        csvRecord.get("addressLine1"),
                                        csvRecord.get("addressLine2"),
                                        csvRecord.get("district"),
                                        csvRecord.get("state"),
                                        csvRecord.get("latitude"),
                                        csvRecord.get("longitude"),
                                        csvRecord.get("nationality"),
                                        Boolean.parseBoolean(csvRecord.get("previouslyContractedWithCOVID19")),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(csvRecord.get("dateWhenTestedPositive")),
                                        new SimpleDateFormat("dd/MM/yyyy").parse(csvRecord.get("dateWhenTestedNegative")),
                                        csvRecord.get("hospitalName"),
                                        Boolean.parseBoolean(csvRecord.get("currentlySufferingFromCOVID19")),
                                        csvRecord.get("disability")
                                ).toString()
                );
                Citizen citizen = new Citizen(
                        Integer.parseInt(csvRecord.get("aadhaarNumber")),
                        csvRecord.get("name"),
                        Integer.parseInt(csvRecord.get("age")),
                        csvRecord.get("gender").charAt(0),
                        Integer.parseInt(csvRecord.get("phoneNumber")),
                        csvRecord.get("addressLine1"),
                        csvRecord.get("addressLine2"),
                        csvRecord.get("district"),
                        csvRecord.get("state"),
                        csvRecord.get("latitude"),
                        csvRecord.get("longitude"),
                        csvRecord.get("nationality"),
                        Boolean.parseBoolean(csvRecord.get("previouslyContractedWithCOVID19")),
                        new SimpleDateFormat("dd/MM/yyyy").parse(csvRecord.get("dateWhenTestedPositive")),
                        new SimpleDateFormat("dd/MM/yyyy").parse(csvRecord.get("dateWhenTestedNegative")),
                        csvRecord.get("hospitalName"),
                        Boolean.parseBoolean(csvRecord.get("currentlySufferingFromCOVID19")),
                        csvRecord.get("disability")
                );

                citizens.add(citizen);
            }

            return citizens;
        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream citizensToCSV(List<Citizen> Citizens) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Citizen Citizen : Citizens) {
                List<String> data = Arrays.asList(
                        String.valueOf(Citizen.getId()),
                        Citizen.getName(),
                        String.valueOf(Citizen.getAge()),
                        String.valueOf(Citizen.getGender())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to export data to CSV file: " + e.getMessage());
        }
    }
}