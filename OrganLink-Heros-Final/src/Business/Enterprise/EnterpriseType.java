
package Business.Enterprise;

/**
 *
 * @author rrheg
 */
public enum EnterpriseType {
    
    Hospital("Hospital"),
    Government("Government"),
    Logistics("Logistics"),
    International("International");
    
    private String value;
    
    private EnterpriseType(String value){
        this.value=value;
    }
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString(){
        return value;
    }
    
}
