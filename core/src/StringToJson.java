import org.json.JSONException;
import org.json.JSONObject;

public class StringToJson {
	public static void main(String[] args) {
		
String s = "{\"resourceType\":\"Bundle\",\"type\":\"searchset\",\"timestamp\":\"2021-02-26T12:21:03+00:00\",\"total\":1,\"entry\":[{\"fullUrl\":\"https://api.service.nhs.uk/personal-demographics/FHIR/R4/Patient/9000000009\",\"search\":{\"score\":1},\"resource\":{\"resourceType\":\"Patient\",\"id\":\"9000000009\",\"identifier\":[{\"system\":\"https://fhir.nhs.uk/Id/nhs-number\",\"value\":\"9000000009\",\"extension\":[{\"url\":\"https://fhir.nhs.uk/R4/StructureDefinition/Extension-UKCore-NHSNumberVerificationStatus\",\"valueCodeableConcept\":{\"coding\":[{\"system\":\"https://fhir.nhs.uk/R4/CodeSystem/UKCore-NHSNumberVerificationStatus\",\"version\":\"1.0.0\",\"code\":\"01\",\"display\":\"Number present and verified\"}]}}]}],\"meta\":{\"versionId\":\"2\",\"security\":[{\"system\":\"https://www.hl7.org/fhir/valueset-security-labels.html\",\"code\":\"U\",\"display\":\"unrestricted\"}]},\"name\":[{\"id\":\"123\",\"use\":\"usual\",\"period\":{\"start\":\"2020-01-01\",\"end\":\"2021-12-31\"},\"given\":[\"Jane\"],\"family\":\"Smith\",\"prefix\":[\"Mrs\"],\"suffix\":[\"MBE\"]}],\"gender\":\"female\",\"birthDate\":\"2010-10-22\",\"multipleBirthInteger\":1,\"deceasedDateTime\":\"2010-10-22T00:00:00+00:00\",\"address\":[{\"id\":\"456\",\"period\":{\"start\":\"2020-01-01\",\"end\":\"2021-12-31\"},\"use\":\"home\",\"line\":[\"1 Trevelyan Square\",\"Boar Lane\",\"City Centre\",\"Leeds\",\"West Yorkshire\"],\"postalCode\":\"LS1 6AE\",\"extension\":[{\"url\":\"https://fhir.nhs.uk/R4/StructureDefinition/Extension-UKCore-AddressKey\",\"extension\":[{\"url\":\"type\",\"valueCoding\":{\"system\":\"https://fhir.nhs.uk/R4/CodeSystem/UKCore-AddressKeyType\",\"code\":\"PAF\"}},{\"url\":\"value\",\"valueString\":\"12345678\"}]}]}],\"telecom\":[{\"id\":\"789\",\"period\":{\"start\":\"2020-01-01\",\"end\":\"2021-12-31\"},\"system\":\"phone\",\"value\":\"01632960587\",\"use\":\"home\"},{\"id\":\"OC789\",\"period\":{\"start\":\"2020-01-01\",\"end\":\"2021-12-31\"},\"system\":\"other\",\"value\":\"01632960587\",\"use\":\"home\",\"extension\":[{\"url\":\"https://fhir.nhs.uk/R4/StructureDefinition/Extension-UKCore-OtherContactSystem\",\"valueCoding\":{\"system\":\"https://fhir.nhs.uk/R4/CodeSystem/UKCore-OtherContactSystem\",\"code\":\"textphone\",\"display\":\"Minicom (Textphone)\"}}]}],\"contact\":[{\"id\":\"C123\",\"period\":{\"start\":\"2020-01-01\",\"end\":\"2021-12-31\"},\"relationship\":[{\"coding\":[{\"system\":\"http://terminology.hl7.org/CodeSystem/v2-0131\",\"code\":\"C\",\"display\":\"Emergency Contact\"}]}],\"telecom\":[{\"system\":\"phone\",\"value\":\"01632960587\"}]}],\"generalPractitioner\":[{\"id\":\"254406A3\",\"type\":\"Organization\",\"identifier\":{\"system\":\"https://fhir.nhs.uk/Id/ods-organization-code\",\"value\":\"Y12345\",\"period\":{\"start\":\"2020-01-01\",\"end\":\"2021-12-31\"}}}],\"extension\":[{\"url\":\"https://fhir.nhs.uk/R4/StructureDefinition/Extension-UKCore-DeathNotificationStatus\",\"extension\":[{\"url\":\"deathNotificationStatus\",\"valueCodeableConcept\":{\"coding\":[{\"system\":\"https://fhir.nhs.uk/R4/CodeSystem/UKCore-DeathNotificationStatus\",\"version\":\"1.0.0\",\"code\":\"2\",\"display\":\"Formal - death notice received from Registrar of Deaths\"}]}},{\"url\":\"systemEffectiveDate\",\"valueDateTime\":\"2010-10-22T00:00:00+00:00\"}]}]}}]}";


String a = "{\"resourceType\":\"Bundle\",\"type\":\"searchset\",\"timestamp\":\"2021-02-26T12:19:46+00:00\",\"total\":0}";
try {
	String aa = new JSONObject(new JSONObject(new JSONObject(s).getJSONArray("entry").get(0).toString()).get("resource").toString()).get("id").toString();
} catch (JSONException e) {

}


}
}