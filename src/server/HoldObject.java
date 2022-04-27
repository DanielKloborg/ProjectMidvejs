package server;

public class HoldObject {
     int id;
     String holdnavn;
     int vind;
     int tab;
     int uafgjort;
     int point;

     public HoldObject(String navnHO, Integer vindHO, Integer tabHO, Integer uafgjortHO, Integer pointHO) {
         holdnavn = navnHO;
         vind = vindHO;
         tab = tabHO;
         uafgjort = uafgjortHO;
         point = pointHO;
     }
     
     public String getHoldNavn() {
    	 return holdnavn;
     }
     public Integer getVind() {
    	 return vind;
     }
     public Integer getTab() {
    	 return tab;
     }
     public Integer getUafgjort() {
    	 return uafgjort;
     }
     public Integer getPoint() {
    	 return point;
     }
}
