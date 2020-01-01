package Dao;

import VO.PartnerCompanyVO;

import java.util.ArrayList;
import java.util.Scanner;

public class PartnerCompanyDao {
    public static ArrayList<PartnerCompanyVO> partnerCompanys = new ArrayList<>();

    /*public void addPartnerCompany() {
        Scanner scanner = new Scanner(System.in);
        String companyName;
        String agentName;
        String directorName;
        String directPhoneNumber;
        System.out.print("회사이름 입력: ");
        companyName = scanner.nextLine();
        System.out.println("대표자이름 입력:");
        agentName = scanner.nextLine();
        System.out.println("담당자 이름 입력:");
        directorName = scanner.nextLine();
        System.out.println("담당자 연락처 입력:");
        directPhoneNumber = scanner.nextLine();
        PartnerCompanyVO partnerCompanyVO = new PartnerCompanyVO();
        partnerCompanyVO.setCompanyName(companyName);
        partnerCompanyVO.setDirectPhoneNumber(directPhoneNumber);
        partnerCompanyVO.setDirectorName(directorName);
        partnerCompanyVO.setAgentName(agentName);
        for (int i = 0; i < BookDao.BookList.size(); i++) {
            if (BookDao.BookList.get(i).getPublishCompanyName().equals(companyName)) {
                partnerCompanyVO.setPublishingBook(BookDao.BookList.get(i).getName());
            } else {
                partnerCompanyVO.setPublishingBook("");
            }
        }
        partnerCompanys.add(partnerCompanyVO);
    }*/

    public void deletePartnerCompany() {
        Scanner scanner = new Scanner(System.in);
        String companyName;
       
        System.out.print("회사 이름을 입력하세요:");
        companyName = scanner.nextLine();
        for (int i = 0; i < partnerCompanys.size(); i++) {
            if (partnerCompanys.get(i).getCompanyName().equals(companyName)) {
                partnerCompanys.remove(i);
            }
        }
    }

    public void getPartnerList() {
    	
    
    	
        if (partnerCompanys.size() != 0) {
        	System.out.println("                        ▼");
            System.out.println("                        ▼");
        	System.out.println("=================================================");
        	System.out.println("                 < 등록된 출판사 목록 >");
        	System.out.println("=================================================");
            System.out.println("회사이름\t담당자번호\t담당자 이름\t출판도서\t");
            for (int i = 0; i < partnerCompanys.size(); i++) {
                if (partnerCompanys.get(i).getAgentName().equals("") || partnerCompanys.get(i).getDirectorName().equals("") || partnerCompanys.get(i).getDirectPhoneNumber().equals("")) {
                    updatePartnerInfo();
                }
            }
                    
                    
            for (PartnerCompanyVO vo : partnerCompanys) {
            	
            	System.out.println(vo.getCompanyName() + "\t" + vo.getDirectPhoneNumber() + "\t" + vo.getDirectorName() + "\t" + vo.getPublishingBook());
            }
        } else {
            System.out.println("출판사 목록없음");

        }
    }

    private void updatePartnerInfo() {
        for (int i = 0; i < partnerCompanys.size(); i++) {
            if (partnerCompanys.get(i).getAgentName().equals("") ||
                    partnerCompanys.get(i).getDirectorName().equals("") ||
                    partnerCompanys.get(i).getDirectPhoneNumber().equals("")) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("회사이름: " + partnerCompanys.get(i).getCompanyName());
                String agentName;
                String directorName;
                String directorPhoneNumber;
                System.out.println(partnerCompanys.get(i).getCompanyName() + "의 대표이름 입력");
                agentName = scanner.nextLine();
                System.out.println(partnerCompanys.get(i).getCompanyName() + "의 담담자 이름 입력");
                directorName = scanner.nextLine();
                System.out.println(partnerCompanys.get(i).getCompanyName() + "의 담담자 전화 번호 입력");
                directorPhoneNumber = scanner.nextLine();
                partnerCompanys.get(i).setDirectPhoneNumber(directorPhoneNumber);
                partnerCompanys.get(i).setDirectorName(directorName);
                partnerCompanys.get(i).setAgentName(agentName);

            }

        }

    }
}
