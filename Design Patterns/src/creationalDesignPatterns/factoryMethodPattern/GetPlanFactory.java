package creationalDesignPatterns.factoryMethodPattern;

class GetPlanFactory{  
    
	   //use getPlan method to get object of type Plan   
	       public Plan getPlan(String planType){  
	            if(planType == null){  
	             return null;  
	            }  
	          if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
	                 return new DomesticPlan();  
	               }   
	           else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){  
	                return new CommercialPlan();  
	            }    
	      return null;  
	   }  
}
