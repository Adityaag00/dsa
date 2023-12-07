import java.io.*;

public class ChatsFixer {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\BACKUPS\\Whatsapp Chat\\output\\919765767862@s.whatsapp.net.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("F:\\BACKUPS\\Whatsapp Chat\\OurChats.txt")));
            String prev="";
            while(true) {
                String current = bufferedReader.readLine();
                if(current==null) {
                    break;
                }
                if(current.contains("None")) {
                    continue;
                }
                if(current.contains("01.01.1970 05:30")) {
                    if(!prev.contains("01.01.1970 05:30") && prev.length() > 15) {
                        String senderReciever = current.substring(0,1);
                        if(senderReciever.equals(">")) {
                            senderReciever="Aditya :";
                        }
                        else {
                            senderReciever="Her :";
                        }
                        String timeSlot=prev.substring(2,18);
                        String msg = senderReciever+" "+timeSlot+" "+current.substring(19);
                        bufferedWriter.write(msg+"\n");
                        continue;
                    }
                    else
                        continue;
                }
                if(current.length()<15) {
                    continue;
                }
                String senderReciever = current.substring(0,1);
                if(senderReciever.equals(">")) {
                    senderReciever="Aditya :";
                }
                else {
                    senderReciever="Her :";
                }
                String msg = senderReciever+" "+current.substring(2);
                bufferedWriter.write(msg+"\n");
                prev=current;
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
