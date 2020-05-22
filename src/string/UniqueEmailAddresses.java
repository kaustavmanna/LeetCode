package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses
{
    public static void main(String[] args)
    {
        String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        UniqueEmailAddresses uniqueEmail = new UniqueEmailAddresses();
        System.out.println(uniqueEmail.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails)
    {
        Set<String> set = new HashSet<>();
        for(String s:emails)
        {
            int skipIndex = s.indexOf('+');
            int addressIndex = s.indexOf('@');
            String mail_id = skipIndex != -1 ? s.substring(0, skipIndex) : s.substring(0, addressIndex);
            String domain = s.substring(addressIndex);
            String email_address = mail_id.replace(".", "") + domain;
            set.add(email_address);
        }
        return set.size();
    }
}
