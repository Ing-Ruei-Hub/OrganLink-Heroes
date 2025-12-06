
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.Government){
            enterprise = new GovernmentEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.Logistics){
            enterprise = new LogisticsEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.International){
            enterprise = new InternationalEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
