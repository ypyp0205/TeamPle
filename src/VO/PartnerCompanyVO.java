package VO;

import java.util.ArrayList;
import java.util.List;

public class PartnerCompanyVO {
    private String companyName;
    private String agentName;
    private ArrayList<String> publishingBook = new ArrayList<String>();
    private String directorName;
    private String directPhoneNumber;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public ArrayList<String> getPublishingBook() {
        return publishingBook;
    }

    public void setPublishingBook(String publishingBook) {
        this.publishingBook.add(publishingBook);
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectPhoneNumber() {
        return directPhoneNumber;
    }

    public void setDirectPhoneNumber(String directPhoneNumber) {
        this.directPhoneNumber = directPhoneNumber;
    }
}
