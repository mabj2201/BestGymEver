import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BestGymEver {
    String bestGymEver = "----------BEST GYM EVER----------";

    public String getPersonNr(String line){
        String[] personNr = line.split(",");
        return personNr[0].trim();
    }

    public String getName(String line){
        String[] name = line.split(",");
        return name[1].trim();
    }

    public boolean yearCard(String line) {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.parse(line);
        Period period = Period.between(date, now);
        int year = period.getYears();
        return year == 0;
    }

    public void bestGymEverMainProgram() {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Personuppgifter.txt"));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("src/Gymhistorik.txt",true)))){
            Scanner scan = new Scanner(bufferedReader);
            String input = JOptionPane.showInputDialog("Skriv in ditt för- och efternamn eller ditt personnummer: ");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Stänger ner...", bestGymEver, JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }

            while(scan.hasNext()){
                String firstLine = scan.nextLine();
                String secondLine = scan.nextLine();

                if(input.trim().equals(getPersonNr(firstLine)) || input.trim().equalsIgnoreCase(getName(firstLine))){
                    JOptionPane.showMessageDialog(null,getName(firstLine) + ", du är medlem!", bestGymEver, JOptionPane.PLAIN_MESSAGE);

                    if(yearCard(secondLine)){
                        JOptionPane.showMessageDialog(null,"Välkommen att gymma!",bestGymEver, JOptionPane.PLAIN_MESSAGE);
                        printWriter.println(getName(firstLine) + "\n" + getPersonNr(firstLine) + "\n" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH.mm")) +
                                "\n" + "-------------------------------------------");

                    }else{
                        JOptionPane.showMessageDialog(null,getName(firstLine) +", ditt årskort har gått ut!", bestGymEver, JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                }else if(!scan.hasNext()){
                    JOptionPane.showMessageDialog(null,input + ", du är inte medlem!", bestGymEver, JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Kan inte hitta något fil med det namnet", bestGymEver, JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Nånting har gått fel!", bestGymEver, JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String [] arg){
        BestGymEver b = new BestGymEver();
        b.bestGymEverMainProgram();
    }
}
